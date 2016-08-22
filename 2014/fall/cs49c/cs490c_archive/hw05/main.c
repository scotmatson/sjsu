///*
// * main.c
// *
// *  Created on: Oct 10, 2014
// *      Author: scot
// */
//
//#include <stdio.h>
//#include <string.h>
//#include "hw5.h"
//
//int main(void) {
//
//	static char *examples[] = {
//			"racecar",
//			"RACEcar", // uppercase equals lowercase
//			"rotator",
//			"rotor",
//			"civic",
//			"Red rum, sir, is murder!",
//				// punctuation and spaces are neglected
//			"Rats live on no evil star.",
//			"Neil, a trap! Sid is part alien!",
//			"Step on no pets.",
//			"Dammit, I’m mad!",
//			"Madam, I’m Adam.",
//			"Madam, in Eden, I’m Adam.",
//			"Rise to vote, sir.",
//			"Never odd or even",
//			"If I had a hi-fi",
//			"Yo, banana boy!",
//			"Do geese see God?",
//			"No devil lived on.",
//			"Ah, Satan sees Natasha.",
//			"A dog, a panic in a pagoda",
//			"Was it a cat I saw?",
//			"Was it a car or a cat I saw?",
//			"No lemons, no melon",
//			"A dog, a plan, a canal, pagoda",
//			"A man, a plan, a canal--Panama!",
//			"A Santa lived as a devil at NASA",
//			"acaacaacaacaacaacaacaacaacaacaac",
//			"acaacaacaacaacaacaacaacaacaacaaccaacaacaacaacaacaacaacaacaacaaca",
//			"addaeaddaeaddaeaddaeaddaeaddaead",
//			"addaeaddaeaddaeaddaeaddaeaddaeaddaeaddaeaddaeaddaeaddaeaddaeadda",
//			"aedeaffaedeaffaedeaffaedeaffaede",
//			"aedeaffaedeaffaedeaffaedeaffaedeedeaffaedeaffaedeaffaedeaffaedea",
//			"afbkkbfaihiafbkkbfaihiafbkkbfaih",
//			"afbkkbfaihiafbkkbfaihiafbkkbfaihhiafbkkbfaihiafbkkbfaihiafbkkbfa",
//			"agblklbgajhhjagblklbgajhhjagblkl",
//			"agblklbgajhhjagblklbgajhhjagblkllklbgajhhjagblklbgajhhjagblklbga",
//			"ahqkgeegkqhamjijmahqkgeegkqhamji",
//			"ahqkgeegkqhamjijmahqkgeegkqhamjiijmahqkgeegkqhamjijmahqkgeegkqha",
//			"aislgdcdglsianjhhjnaislgdcdglsia",
//			"aislgdcdglsianjhhjnaislgdcdglsiaaislgdcdglsianjhhjnaislgdcdglsia",
//			"ajukctpnnptckujaqlihilqajukctpnn",
//			"ajukctpnnptckujaqlihilqajukctpnnnnptckujaqlihilqajukctpnnptckuja",
//			"abbabbabbabbabbabbabbabbabbabbab",
//			"abbabbabbabbabbabbabbabbabbabbabbabbabbabbabbabbabbabbabbabbabba",
//			"abeebabeebabeebabeebabeebabeebab",
//			"abeebabeebabeebabeebabeebabeebabbabeebabeebabeebabeebabeebabeeba",
//			"affae  af,a-d+a faedeaffaedeaffaaffaedeaffaedeaf a+d-a,fa  eaffa",
//			"acgbj  bg,a-c+b ijbgcaacgbjijbgccgbjijbgcaacgbji b+c-a,gb  jbgca",
//			"abejd  km,j-b+b jdmkkmdjebabejdmmdjebabejdmkkmdj b+b-j,mk  djeba",
//			"appae  lg,c-g+b eappaekblgdcdglbblgdcdglbkeappae b+g-c,gl  eappa",
//			"aqpqa  cn,d-b+h cmfaqpqafmcnhdbbbbdhncmfaqpqafmc h+b-d,nc  aqpqa",
//			"arnll  ai,h-o+g gjovhsiarnllnraiiarnllnraishvojg g+o-h,ia  llnra",
//			"aacaa  ac,a-a+c acaacaacaacaacaaaacaacaacaacaaca c+a-a,ca  aacaa",
//			"aeadd  ad,a-a+d eaddaeaddaeaddaeeaddaeaddaeaddae d+a-a,da  ddaea",
//			"agadb  ag,d-b+a adbbdagadbbdagaddagadbbdagadbbda a+b-d,ga  bdaga",
//			"akadi  ce,d-k+d ecceidakadiecceiiecceidakadiecce d+k-d,ec  idaka"
//
//	};
//
//
//	int i;
//	for (i = 0; i <= 55; i++) {
//		if (notPalindrome(examples[i]) != 0) {
//		printf("%s...is not a palindrome.\n", examples[i]);
//		}
//		else {
//		printf("%s...is a palindrome!\n", examples[i]);
//		}
//	}
//	return 0;
//}
