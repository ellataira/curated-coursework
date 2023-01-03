#
# Usage: ./calculator <op> <arg1> <arg2>
#

# Make `main` accessible outside of this module
.global main

# Start of the code section
.text

# int main(int argc, char argv[][])
main:
  # Function prologue
  enter $0, $0

  # Variable mappings:
  # op -> %r12
  # arg1 -> %r13
  # arg2 -> %r14
  movq 8(%rsi), %r12  # op = argv[1]
  movq 16(%rsi), %r13 # arg1 = argv[2]
  movq 24(%rsi), %r14 # arg2 = argv[3]


  # Hint: Convert 1st operand to long int
	movq %r13, %rdi
	call atol
	movq %rax, %r13

  # Hint: Convert 2nd operand to long int
        movq %r14, %rdi
        call atol
	movq %rax, %r14 

  # Hint: Copy the first char of op into an 8-bit register
  # i.e., op_char = op[0] - something like mov 0(%r12), ???

	mov 0(%r12), %al
	
  # if (op_char == '+') {
  #   ...
  # }
  # else if (op_char == '-') {
  #  ...
  # }
  # ...
  # else {
  #   // print error
  #   // return 1 from main
  # }


## compare symbol to call function 
cmpb $'+', %al 
je Add 	 

cmpb $'-', %al
je Subtract

cmpb $'*', %al
je Multiply 

cmpb $'/', %al  
jne Error

	# else divide 
	xor %rdx, %rdx
        # check if denom == 0 
        cmpq %rdx, %r14
        je DivisionError

        movq %r13, %rax
        movq  %r14, %rbx
	cqto
        idiv %rbx
        mov %rax, %rsi
        movq $long_format, %rdi
        mov $0, %al
        call printf
	
	jmp Exit 


## addition function 
Add: 
	addq %r13, %r14
	movq %r14, %rsi  	 
	jmp Print
	
	jmp Exit

# subtract function
Subtract: 
	subq %r14, %r13
	movq %r13, %rsi 
	jmp Print
	
	jmp Exit 

# multiply function
Multiply: 
	imulq %r13, %r14
	movq %r14, %rsi
	jmp Print 
	
	jmp Exit 

# sets error for invalid denominator 
DivisionError:
	 mov $0, %al
        mov $div_error, %rdi	
        call printf

	jmp Exit 

# throws "unknown op" error
Error: 
	mov $error, %rdi
	mov $0, %al
        call printf

	jmp Exit

# print function
Print: 
	movq $long_format, %rdi
       	mov $0, %al
	call printf

# exit function
Exit: 
    # Function epilogue
    leave
    ret

# Start of the data section
.data

long_format: 
  .asciz "%ld\n"

error: 
.asciz "Unknown operation\n"

div_error: 
.asciz "invalid denominator\n" 

