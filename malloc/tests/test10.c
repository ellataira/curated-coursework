#ifndef DEMO_TEST
#include <malloc.h>
#else
#include <stdlib.h>
#endif

#include <stdio.h>
#include <string.h>

int main() {

  // Allocate several different uniquely sized blocks
  // Ideally your allocator will be able to re-use many
  // of these blocks.
  for (int i = 0; i < 100; i++) {
    int *data = (int *) calloc(1,8);
    int *data1 = (int *) calloc(1,16);
    int *data2 = (int *) calloc(1,32);
    int *data3 = (int *) calloc(1,64);
    int *data4 = (int *) calloc(1,128);

    free(data);
    free(data1);
    free(data2);
    free(data3);
    free(data4);
  }

  return 0;
}
