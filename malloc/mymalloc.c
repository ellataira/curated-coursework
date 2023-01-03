#define _DEFAULT_SOURCE
#define _BSD_SOURCE 
#include <malloc.h> 
#include <assert.h> 
#include <unistd.h>
#include <string.h>
#include <debug.h> // definition of debug_printf

#define BLOCK_SIZE sizeof(block_t)

/**
 * represents a block of memory in a linked list
 * */
typedef struct block {
  size_t size;        // How many bytes beyond this block have been allocated in the heap
  struct block *next; // Where is the next block in your linked list
  int is_free;           // Is this memory free, i.e., available to give away?
} block_t;

block_t* request_space(block_t* last, size_t size);
block_t* find_if_free(block_t** last, size_t size);

/**
 * the head of the linked list
 * */
block_t* head = NULL;

/**
 * allocates memory in the same way as <stdlib.h>'s malloc function
 * 
 * @param s the number of bytes of memory 
 * 
 * @return a pointer to the allocated memory
 * */
void *mymalloc(size_t s) {
	// cannot allocate space of 0 
	assert(s > 0); 

	block_t* block; 

	// case: head == null => request space, and set new head to the new block 
	if (!head) {
		block = request_space(NULL, s); 
		
		// if request returns NULL, return NULL
		if (!block) {
			return NULL;
		}
		
		head = block; 
	}

	// case: head != null => check if we can reuse space, else request new space 
	else {
		block_t* last = head; 
		block = find_if_free(&last, s);
		
		// if cannot find any free space to reuse, then request space  
		if (!block) {
			block = request_space(last, s); 
			if (!block) {
				return NULL;
			}
		}
	}

	debug_printf("malloc %zu bytes\n", block->size);
	
	return block + 1; // add 1 because we want to return the actual memory 
}

/**
 * checks if there is a free block of the proper size to use
 * using first-fit approach
 * 
 * @param last the last block 
 * @param size the size of block to look for 
 *
 * @return pointer to free block of size, or NULL if no such block exists  
 * */
block_t* find_if_free(block_t** last, size_t size) {
	block_t* current = head; 
	
	// while current exists, and either current is too small or not free, increment 
	while (current && (current->size < size || current->is_free == 0)) {
		*last = current;
		current = current->next; 
	}
	return current; 
}

/**
 * requests space from OS and adds new block to linked list 
 * 
 * @param last the last block 
 * @param size the amount of space to request 
 * 
 * @return pointer to new block of size
 * */ 
block_t* request_space(block_t* last, size_t size) {
	block_t* block = sbrk(0); 
	void* request = sbrk(BLOCK_SIZE + size); 

	// if sbrk fails 
	if (request == (void*) -1) {
		return NULL;
	}	

	// if there is a block before, then link the new block to it 
	if (last) {
		last->next = block; 
	}
	
	block->size = size; 
       	block->next = NULL;
	block->is_free = 0; // is not free 	
	return block; 
}

/**
 * contiguously allocates enough space for
 * a given number of objects of a given  
 * size of memory each. the allocated memory is
 * filled in with bytes of value 0
 *
 * @param nmemb the number of objects
 * @param s the number of bytes of each object
 *
 * @return pointer to the allocated memory 
 * */ 
void *mycalloc(size_t nmemb, size_t s) {

	size_t size = nmemb *s;
	void* p = mymalloc(size); 
  	
	if (!p){
    		// we are out of memory
    		// if we get NULL back from malloc
  		return NULL; 
	}

	// clear the memory of the pointer 
  	memset(p, 0, size);

	debug_printf("calloc %zu bytes\n", size);
	return p;
}

/**
 *  frees the memory associated with the given pointer
 *  
 *  @param ptr the pointer to look at
 */
void myfree(void *ptr) {
	
	if (!ptr) {
		return;
	}

	block_t* to_free  = (block_t*) ptr - 1; // -1 because are accessing the struct 
	
	to_free->is_free = 1; // this memory is now "free"

	debug_printf("Freed %zu bytes\n", to_free->size);

}

