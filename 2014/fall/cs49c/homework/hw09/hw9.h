#ifndef _hw9_HEADER
#define _hw9_HEADER 

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

struct ListNode {
  unsigned int data;
  char name[16];
  char grade;
  struct ListNode *next;
};

void insertList(struct ListNode *lptr, unsigned int idata, char *iname, char igrade);
void printList(FILE *fpo, struct ListNode *lptr);
void freeList (struct ListNode *lptr);

#endif
