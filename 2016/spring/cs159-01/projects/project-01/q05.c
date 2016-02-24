/*
  5) Making the minor changes to program 4, execute the following 'C'
     program several times interactively, as well as several times
     while redirecting to a file. Explain what has happened.
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{
  int pid;
  int i;
  for (i = 0; i < 3; i++)
  {
    if ((pid = fork()) < 0) {printf("Sorry ... cannot fork\n");}
    else if (pid == 0) 
    { 
      printf("child %d\n", i);
      fflush(stdout);
    }
    else
    {
      wait(NULL);
      printf("parent %d\n", i);
      fflush(stdout);
    }
  }
}
