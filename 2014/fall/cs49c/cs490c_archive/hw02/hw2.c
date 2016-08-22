/*
 * hw2.c
 *
 *  Created on: Sep 12, 2014
 *      Author: Scot Matson
 *  Assignment: 2
 * Description: Builds a simple console based calendar given
 * the month, year, and  weekday as an argument.
 */

#include <stdio.h>
#include <string.h>

// Constants
#define true  1;
#define false 0;

// Global variables
char buf[256];

/*
 *  The calendar function builds out a calendar given
 *  a month[1-12], year, and day of the week[0-6].
 */
char * calendar(int mm, int yyyy, int wdStart) {
	char *bufp = buf;
	int i, j;
	const char month[12][10] = {" January ", "February", "  March  ", "  April  ",
			"   May   ", "  June  ", "  July  ", "  August  ", "September", " October ",
			"November", "December"};

	// Beginning to build out the header of the calendar.
	bufp += sprintf(bufp, "   %9s %4i    \n", month[mm-1], yyyy);
	bufp += sprintf(bufp, "                     \n");
	bufp += sprintf(bufp, " Su M  T  W  Th F  Sa\n");

	// This sets the starting index for the
	// weekday in the calendar.
	for (i = 1; i <= (wdStart * 3); ++i) {
		bufp += sprintf(bufp, " ");
	}

	// Given the month, the days are populated and tracked with
	// a counter[i] which determines when to insert a new line break.
	for (j = 1, ++i; j <= daysInMonth(mm, yyyy); ++j, i += 3) {
		bufp += sprintf(bufp, " %2i", j);
		if (i >= 19) {
			bufp += sprintf(bufp, "\n");
			i = 0;
		}
	}

	return buf;
}

/*
 * Algorithm to calculate if the given year is a leap year
 * credited psuedocode of unknown author at
 * http://en.wikipedia.org/wiki/Leap_year#Algorithm.
 */
int isLeap(int year) {
	int leap = true;
	if (((year % 100) == 0 && (year % 400) != 0)
			|| (year % 4) != 0) {
		leap = false;
	}
	return leap;
}

/*
 * Returns the number of days in a given month.
 */
int daysInMonth(int month, int year) {
	int numDays;
	switch(month) {
		case 4:case 6:
		case 9:case 11:
			numDays = 30;
			break;
		case 1:case 3:
		case 5:case 7:
		case 8:case 10:
		case 12:
			numDays = 31;
			break;
		case 2:
			numDays = isLeap(year) ? 29 : 28;
			break;
		default:
			numDays =  0;
			break;
	}
	return numDays;
}

