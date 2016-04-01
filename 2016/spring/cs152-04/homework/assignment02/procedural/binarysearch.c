#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#define SWAP(a,b) { int t; t=a, a=b, b=t; }

int binarySearch(int*, int, int, int);
void mergeSort(int*, int, int);
void merge(int*, int, int, int);
void printIntArray(int*, int);

int main(void) {
    srand((unsigned) time(NULL)); 
    const int ARR_LEN = 10;
    int randInts[ARR_LEN];
    int targetElement, elementPosition;

    printf("Initializing array values.\n");
    int i;
    for (i = 0; i < ARR_LEN; ++i) {
        randInts[i] = rand() % 101;
    }
    mergeSort(randInts, 0, ARR_LEN-1);
    printIntArray(randInts, ARR_LEN);

    targetElement = rand() % 101;
    printf("\nInitiating binary search.\n");
    printf("Target element: %d\n", targetElement);

    elementPosition = binarySearch(randInts, 0, ARR_LEN-1, targetElement); 
    if (elementPosition >= 0) {
        printf("\nTarget element located at index %d\n", elementPosition);
    }
    else {
        printf("\nTarget element does not exist.\n");
    }
    return 0;
}

int binarySearch(int *intArr, int low, int high, int targetElement) {
    int mid;
    while (low <= high) {
       mid = (low + high) / 2; 
       if (intArr[mid] > targetElement) {
           high = mid - 1; 
       }
       else if (intArr[mid] < targetElement) {
           low = mid + 1;
       }
       else {
           return mid;
       }
    }
    return -1;
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
