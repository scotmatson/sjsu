#include <stdio.h>

int main(void)
{
int pid;
pid = fork();
printf ("PID is %d\n", pid);
}
