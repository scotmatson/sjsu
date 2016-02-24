/*
  8) One way for a parent process to attack a very large problem might be to split
     it into several smaller pieces, create several new child processes, and
     allocate each child a piece of the problem. In this and other scenarios, it
     is important that processes be able to synchronize with each other. The
     wait(&status) function provides one mechanism in which two processes can
     re-synchronize at some point in their executions. It causes a parent process
     to be suspended until some child process terminates. In some ways, it is a
     specialized version of the sleep(x) function which causes a process to suspend
     itself for x seconds.

     Write a program that will create a child process. Have the child sleep for 5
     seconds; have the parent wait for the child process to finish sleeping. Put
     print messages in the program such that you can keep track of where each process
     is. For example, the following strings would enable you to compare the
     time-based execution with and without the parent waiting.

     Child going to sleep.
     Parent starting wait.
     Child finished sleeping.
     Parent finished wait.
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(void) {
  int pid;
  int status;
  
  if ((pid=fork()) < 0) {printf("Sorry ... cannot fork.\n"); fflush(stdout);}
  else if (pid==0) {
    printf("Child pid: %d\n", getpid()); fflush(stdout);
    printf("Child going to sleep.\n"); fflush(stdout);
    sleep(5);
    printf("Child process finished sleeping.\n"); fflush(stdout);
  }
  else {
    printf("Parent pid: %d\n", getpid()); fflush(stdout);
    printf("Parent starting wait.\n"); fflush(stdout);
    wait(NULL);
    printf("Parent finished wait.\n"); fflush(stdout);
  }

  exit(0); 
}
