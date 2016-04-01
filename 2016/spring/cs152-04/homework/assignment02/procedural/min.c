#include <time.h>
#include <stdlib.h>
#include <stdio.h>

int findMin(int*, int);
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

    int min;
    min = findMin(randInts, ARR_LEN);
    printf("\nMinimum int: %d\n\n", min);

    return 0;
}

void printIntArray(int* intArr, int ARR_LEN) {
    int i;
    printf("%d", intArr[0]);
    for (i = 1; i < ARR_LEN; ++i) {
        printf(" %d", intArr[i]);
    }
}

int findMin(int* intArr, int ARR_LEN) {
    int currMin = intArr[0];
    int i;
    for (i = 1; i < ARR_LEN; ++i) {
        if (currMin > intArr[i]) {
            currMin = intArr[i];
        }
    }

    return currMin;
}
