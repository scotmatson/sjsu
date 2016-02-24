/*
  4) Making the minor changes to program 3 above needed to get
     the code below, execute the following 'C' program several
     times interactively.

     a) Explain how and why the order of the output from this 
        program is different from that of program 3. 
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
    else if (pid == 0) {printf("child %d\n", i);}
    else
    {
      wait(NULL);
      printf("parent %d\n", i);
    }
  }

  exit(0);
}
