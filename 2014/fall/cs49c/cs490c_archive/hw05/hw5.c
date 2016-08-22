/*
 * hw5.c
 *
 *  Created on: Oct 10, 2014
 *      Author: Scot Matson
 *      Course: cs49c
 *     Section: 1
 *        Assn: 5
 *        Desc: Excluding all non-alphabetic characters, function
 *        will return 0 if a given text is a palindrome or a -1 if
 *        it is not.
 */
#include <string.h>
#include <stdio.h>
#include <ctype.h>

int notPalindrome(char * x) {
	const int LEN = strlen(x);
	const int HALF_LEN = LEN / 2;
	int isPalindrome = 0; //Equivocates to true
	int i = 0;
	int j = LEN - 1;

	while(i <= HALF_LEN + 1) {
		if (!isalpha(x[i])) { //Filtering non-alpha characters
			++i;
			continue;
		}
		if (!isalpha(x[j])) { //Filtering non-alpha characters
			--j;
			continue;
		}

		if (toupper(x[i]) != toupper(x[j])) { //Comparing characters
			isPalindrome = j; //The ride-sided mismatch index
			break;
		}

		++i;
		--j;
	}

	return isPalindrome;
}
