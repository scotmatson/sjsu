#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#define SWAP(a,b) { int t; t=a, a=b, b=t; }

void bubbleSort(int*, int);
void printIntArray(int*, int);

int main(void) {
    srand((unsigned) time(NULL)); 
    const int ARR_LEN = 10;
    int randInts[ARR_LEN];

    printf("Initializing array values.\n");
    int i;
    for (i = 0; i < ARR_LEN; ++i) {
        randInts[i] = rand() % 101;
    }
    printIntArray(randInts, ARR_LEN);

    printf("\nInitiating bubble sort.\n");
    bubbleSort(randInts, ARR_LEN);
    printIntArray(randInts, ARR_LEN);
    return 0;
}

void printIntArray(int* intArr, int ARR_LEN) {
    int i;
    printf("%d", intArr[0]);
    for (i = 1; i < ARR_LEN; ++i) {
        printf(" %d", intArr[i]);
    }
}

void bubbleSort(int *intArr, int ARR_LEN) {
    int i, j;
    for (i = 0; i < ARR_LEN; ++i) { 
        for (j = 0; j < ARR_LEN-1; ++j) {
            if (intArr[j] > intArr[j+1]) {
                SWAP(intArr[j], intArr[j+1]);
            }
        }
    }
}
