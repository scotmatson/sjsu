#include <time.h>
#include <stdlib.h>
#include <stdio.h>

int findMax(int*, int);
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

    int max;
    max = findMax(randInts, ARR_LEN);
    printf("\nMaximum int: %d\n\n", max);
    return 0;
}

void printIntArray(int* intArr, int ARR_LEN) {
    int i;
    printf("%d", intArr[0]);
    for (i = 1; i < ARR_LEN; ++i) {
        printf(" %d", intArr[i]);
    }
}

int findMax(int* intArr, int ARR_LEN) {
    int i;
    int currMax;

    currMax = intArr[0];
    for (i = 1; i < ARR_LEN; ++i) {
        if (currMax < intArr[i]) {
            currMax = intArr[i];
        }
    }
    return currMax;
}
