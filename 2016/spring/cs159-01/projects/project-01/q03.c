/*
  3) Run the following 'C' program several times interactively.
     Note the different execution order on different runs.
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void)
{
  int pid;
  int i;
  for (i = 0; i < 3; i++)
  {
    if ((pid = fork()) < 0) {printf("Sorry ... cannot fork\n");}
    else if (pid == 0)      {printf("child %d\n", i);}
    else                    {printf("parent %d\n", i);}  
  }

  exit(0);
}
