/*
 * calc.h
 *
 *  Created on: Nov 3, 2014
 *      Author: scot
 */

#ifndef CALC_H_

#define CALC_H_
#define NUMBER '0'
#define COMMENT '1'
#include <stdio.h>

int RPNCalc (FILE*, FILE*);
void push(double);
double pop(void);
int getop(char [], FILE*);
int getch(FILE*);
void ungetch(int);

#endif /* CALC_H_ */
