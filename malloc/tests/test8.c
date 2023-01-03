// Basic test

#ifndef DEMO_TEST
#include <malloc.h>
#else
#include <stdlib.h>
#endif

#include <string.h>
#include <stdio.h>
#include <debug.h>

#define ARRAY_ELEMENTS 1024

int main() {

  // Allocate some data
  int *data = (int *) calloc(ARRAY_ELEMENTS, ARRAY_ELEMENTS * sizeof(int));

  // Do something with the data
  int i = 0;
  for (i = 0; i < ARRAY_ELEMENTS; i++) {
	debug_printf("%zu\n", data[i]);
	data[i] = i;
        debug_printf("%zu\n", data[i]);

  } 

  // Free the data
  free(data);

  return 0;
}
