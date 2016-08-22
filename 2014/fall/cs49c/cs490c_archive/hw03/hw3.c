/*
 * hw3.c
 *
 *  Created on: Sep 26, 2014
 *      Author: Scot Matson - 009602502
 *      Course: cs49c-01
 *        Desc:
 *        First function simply returns
 *        the selected range of a data type.
 *
 *        Second function does some binomial magic based upon
 *        Pascal's triangle returning the desired coefficient.
 *
 *
 */

#include <limits.h>
#include <stdio.h>
#include "../hw01/hw1.h"

long long int lim(int s, int max, char t) {

	long long int value = 0;

	switch (t) {
	case 'c': //char
		if (s != 0)
			value = (max == 0) ? CHAR_MIN : CHAR_MAX;
		else if (s == 0)
			value = (max == 0) ? 0 : UCHAR_MAX;
		break;
	case 's': //short
		if (s != 0)
			value =  (max == 0) ? SHRT_MIN : SHRT_MAX;
		else if (s == 0)
			value = (max == 0) ? 0 : USHRT_MAX;
		break;
	case 'd': //int
		if (s != 0)
			value =  (max == 0) ? INT_MIN : INT_MAX;
		else if (s == 0)
			value = (max == 0) ? 0 : UINT_MAX;
		break;
	case 'l': //long
		if (s != 0)
			value =  (max == 0) ? LONG_MIN : LONG_MAX;
		else if (s == 0)
			value = (max == 0) ? 0 : ULONG_MAX;
		break;
	case 'z': //long long int
		if (s != 0)
			value =  (max == 0) ? LLONG_MIN : LLONG_MAX;
		else if (s == 0)
			value = (max == 0) ? 0 : ULLONG_MAX;
		break;
	}

	return value;
}

long long int binomial(int n, int m) {
	if (n<0 || m<0 || m>n) return -1;

	int i;
	int num[m], den[m];
	long long int product = 1;

	for(i=0; i<m; i++) {
		num[i] = n - i;
		den[i] = i + 1;

		if (GCD(num[i], den[i]) > 1) {
			int gcd = GCD(num[i], den[i]);
			num[i] = num[i] / gcd;
			den[i] = den[i] / gcd;
		}

		product = (product / den[i]) * num[i];
	}

	return product;
}
