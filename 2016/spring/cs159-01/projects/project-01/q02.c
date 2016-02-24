/*
  2) Execute the following 'C' program, first interactively, then by 
     redirecting output to a file at the UNIX shell level with a ">".
     Explain what has happened with the addition of the fflush system
     call.
*/

#include <stdio.h>
#include <unistd.h>

int main(void)
{
  printf("Line 1 ..\n");
  fflush(stdout);
  write(1, "Line 2 ", 7);
}
