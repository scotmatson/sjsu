#include <stdio.h>

int main(void)
{
int pid;
printf ("Before Fork ");
pid = fork();
printf ("After Fork\n");
}
