#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

unsigned int calculateBitLength(unsigned int);
void binaryPrinter(unsigned int);
int hammingDistance(unsigned int, unsigned int);

int main(void) {
    srand((unsigned) time(NULL)); 
    unsigned int int1, len1;
    unsigned int int2, len2;
    int ham;

    do {
        int1 = rand() % 1001;
        int2 = rand() % 1001;
        len1 = calculateBitLength(int1);
        len2 = calculateBitLength(int2);
    } while (len1 != len2);

    printf("Integer 1 -> %d = ", int1);
    binaryPrinter(int1);
    printf("\n");
    printf("Integer 2 -> %d = ", int2);
    binaryPrinter(int2);
    printf("\n");
    
    ham = hammingDistance(int1, int2);
    printf("\nThe hamming distance is %d.\n", ham);

    return 0;
}

unsigned int calculateBitLength(unsigned int n) {
    unsigned int bitLength = 0;
    while (n) {
        bitLength += 1;
        n >>= 1;
    }
    return bitLength;
}

void binaryPrinter(unsigned int base10) {
    while (base10) {
        if (base10 & 1) {
            printf("1");
        }
        else {
            printf("0");
        }
        base10 >>= 1;
    }
}

int hammingDistance(unsigned int num1, unsigned int num2) {
    unsigned int xor, bitLength;
    int distance;
    xor = num1 ^ num2;
    while (xor) {
        if (xor & 1) {
            distance += 1; 
        }
        xor >>= 1;
    }
    return distance;
}
