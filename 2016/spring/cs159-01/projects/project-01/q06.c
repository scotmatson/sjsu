/*
  6) Write a program that will create a child process.
      - Have the parent print out its pid and that of its child.
      - Have the child print its pid and that of its parent.
      - Have the processes print informational messages during
        various phases of their execution as means of tracing
        them.

    A typical printout might contain the following output
    (not necessarily in this order).
      - Immediatley before the fork. Only one process at this point.
      - Immediately after the fork. This statement should print twice.
      - Immediately after the fork. This statement should print twice.
      - I'm the child. My pid is XXXX. My parent's pid is XXXX.
      - I'm the parent. My pid is XXXX. My child's pid is XXXX.
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(void)
{
  int pid;
  int i;
  int pnum = 1;
  
  printf("Immediately before the fork. Only one process at this point.\n");

  for (int i = 0; i < 3; i++)
  {
 
    if ((pid = fork()) < 0) 
    {
      printf("Sorry ... cannot fork.\n");
      fflush(stdout);
    }
    else if (pid == 0)
    {
      /* Increment process counter */
      ++pnum; 

      /* Child notification */
      printf("I'm the child. My pid is %d. My parent's pid is %d.\n",
        getpid(), getppid());
      fflush(stdout);
    }
    else
    {
      /* Parent notification */
      printf("I'm the parent. My pid is %d. My child's pid is %d.\n",
        getpid(), pid);
      fflush(stdout);

      printf("Parent %d is waiting for their child process to finish.\n",
        getpid());
      fflush(stdout);
      wait(NULL);
    }

    printf("%d processes running.\n", pnum);
    fflush(stdout);
  } 

  /* Signal user that process is ending and decrement counter */
  printf("Process %d terminating.\n", getpid());
  fflush(stdout);
  --pnum;

  exit(0);
}
