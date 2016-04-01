int main(void) {
  int i, j, k;
  int M[1000][1000];
 
  /* Row major order */
  for (k = 0; k < 1000; k++) {
    for (i = 0; i < 1000; i++) {
      for (j = 0; j < 1000; j++) {
        M[i][j] = 0;
      }
    }
  }

  /* Column major order
  for (k = 0; k < 1000; k++) {
    for (j = 0; j < 1000; j++) {
      for (i = 0; i < 1000; i++) {
        M[i][j] = 0;
      }
    }
  }
  */
}
  
