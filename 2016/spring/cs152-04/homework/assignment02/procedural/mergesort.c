#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#define SWAP(a,b) { int t; t=a, a=b, b=t; }

void mergeSort(int*, int, int);
void merge(int*, int, int, int);
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

    printf("\nInitiating merge sort.\n");
    mergeSort(randInts, 0, ARR_LEN-1);
    printIntArray(randInts, ARR_LEN);
    return 0;
}

void printIntArray(int *intArr, int ARR_LEN) {
    int i;
    printf("%d", intArr[0]);
    for (i = 1; i < ARR_LEN; ++i) {
        printf(" %d", intArr[i]);
    }
}

void mergeSort(int *intArr, int low, int high) {
    int mid;
    if (low < high) {
        mid = (low + high) / 2;
        mergeSort(intArr, low, mid);
        mergeSort(intArr, mid+1, high);
        merge(intArr, low, mid, high);
    }
}

void merge(int *intArr, int low, int mid, int high) {
    int n1 = (mid - low) + 1;
    int n2 = (high - mid);
    int lTemp[n2], rTemp[n1];

    int i, j, k;
    for (i = 0; i < n1; i++) {
      lTemp[i] = intArr[low + i];
    }
    for (j = 0; j < n2; j++) {
      rTemp[j] = intArr[mid + j + 1];
    }

    i = 0;
    j = 0;
    k = low;
    while (i < n1 && j < n2) {
        if (lTemp[i] <= rTemp[j]) {
            intArr[k] = lTemp[i];
            i++;
        }
        else {
            intArr[k] = rTemp[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        intArr[k] = lTemp[i];
        i++;
        k++;
    }
    while (j < n2) {
        intArr[k] = rTemp[j];
        j++;
        k++;
    }
}
