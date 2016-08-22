/*
 * getop.c
 *
 *  Created on: Nov 3, 2014
 *      Author: scot
 */
#include <stdio.h>
#include <ctype.h>
#include "calc.h"

int getop(char s[], FILE *fpi){
    int i, c;

    while ((s[0] = c = getch(*fpi)) == ' ' || c == '\t')
        ;
    s[1] = '\0';

    i = 0;
    if (!isdigit(c) && c != '.' && c != '-')
        return c;

    if (c == '-') {
        if (isdigit(c = getch(*fpi)) || c == '.') {
            s[++i] = c;
    	}
        else {
            if (c != EOF)
                ungetch(c);
            return '-';
        }
    }

    if (isdigit(c)) {
        while (isdigit(s[++i] = c = getch(*fpi)))
            ;
    }
    if (c == '.') {
        while (isdigit(s[++i] = c = getch(*fpi)))
            ;
    }
    s[i] = '\0';
    if (c != EOF) {
        ungetch(c);
    }
    return NUMBER;
}
