#include <stdio.h>

int main(void)
{
int pid;
printf ("Before Fork ");
fflush(stdout);
pid = fork();
printf ("After Fork\n");

