/*
  1) Execute the following 'C' program, first interactively, then by
     redirecting output to a file at the UNIX shell level with a ">".
     Explain the difference between the output observed on the terminal
     and that contained in the target piped file.
*/

#include <stdio.h>
#include <unistd.h>

int main(void)
{
  printf("Line 1 ..\n");
  write(1, "Line 2 ", 7);
}
