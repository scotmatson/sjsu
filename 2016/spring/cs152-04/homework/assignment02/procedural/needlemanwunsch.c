#include <stdio.h>

void printMatrix(int**, int, int);

int main(void) {
    const int ROW_LEN = 5;
    const int COL_LEN = 5;
    int matrix[ROW_LEN][COL_LEN];


    int i, j;
    for (i = 0; i < ROW_LEN; ++i) {
        for (j = 0; j < COL_LEN; ++j) {
            matrix[i][j] = 0;
        }
    }

    printMatrix((int **)matrix, ROW_LEN, COL_LEN);
    return 0;
}

void printMatrix(int ** matrix, int m, int n) {
    int i, j;
    for (i = 0; i < m; ++i) {
        for (j = 0; j < n; ++j) {
            printf("%d", matrix[i][j]);
        }
    }
}
