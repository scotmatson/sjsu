/*
  7) Write a program that will create a process tree structure as shown
     below. Again, have the processes print informational messages to
     verify that their parent-child relationship is that as shown. So
     processes B and C should both report the same parent pid (that of A).
     Also, processes E, and F should both report the same parent pid 
     (that of C) and D should report its parent as being B. Label each
     node in the figure with the PID of the process your program creates.
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

void forkError(void);
void childMessage(int, int);
void parentMessage(int, int);

int main(void) {
  int b, c, d, e, f;

  /* Process A */
  printf("root: %d\n", getpid());

  /* Process C */
  if ((c = fork()) < 0) {forkError();}
  else if (c == 0) {
    childMessage(getpid(), getppid());
    /* Process F */
    if ((f = fork()) < 0) {forkError();}
    else if (f == 0) {
      childMessage(getpid(), getppid());
    }
    else {
      parentMessage(getpid(), f); wait(NULL);

      /* Process E */
      switch(e=fork()) {
        case -1: forkError(); break;
        case 0 : childMessage(getpid(), getppid()); break;
        default: parentMessage(getpid(), e); wait(NULL); break;
      }
    }
  }
  else {
    parentMessage(getpid(), c);
    /* Process B */
    if ((b = fork()) < 0) {forkError();}
    else if (b == 0) {
      childMessage(getpid(), getppid()); wait(NULL);

      /* Process D */
      switch (d=fork()) {
        case -1: forkError(); break;
        case 0 : childMessage(getpid(), getppid()); break;
        default: parentMessage(getpid(), d); wait(NULL); break; 
      }
    }
    else {
      parentMessage(getpid(), b);
      wait(NULL);
    }
  }
  exit(0);
}

void forkError(void) {printf("Sorry ... cannot fork.\n"); fflush(stdout);}

void childMessage(cpid, ppid) {
  printf("I'm the child. My pid is %d. My parent's process is %d.\n",
    cpid, ppid);
  fflush(stdout);
}

void parentMessage(ppid, cpid) {
  printf("I'm the parent. My pid is %d. My child's process is %d.\n",
    ppid, cpid);
  fflush(stdout);
}
