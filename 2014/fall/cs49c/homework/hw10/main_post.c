/*
 *  main_post.c
 *
 *  Created on: Nov 30, 2014
 *      Author: Tom Howell
 *
 *      HW10 Crooked Tic-Tac-Toe *
 *
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "hw10.h"

int pflag, wintype, evcount = 0, chcount = 0;

// the following is used to re-initialize the game configuration
struct config game = {{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, X, 9};

//This function is for manually inputing moves
void mymove(struct config *cp){
        //make next move manually
        int row, col;
        do {
          if (cp->toplay == O) printf("enter coordinates for O move: " );
          else printf("enter coordinates for X move: " );
          //fflush(stdout);
          scanf("%d %d", &row, &col);
          row %= 3;               //make sure it is on the grid
          col %= 3;               //make sure it is on the grid
        } while(cp->grid[row][col] != ' ');
        if (cp->toplay == O) cp->grid[row][col] = 'O';
        else cp->grid[row][col] = 'X';
        return;
}

int checkGrid(struct config *cp){
        //not required; might be useful for debugging
        //The server will check your grids this way
        int row, col, cnt = 0;
        //Count the blank squares
        for (row = 0; row < 3; row++){
                for (col = 0; col < 3; col++){  
                        if (cp->grid[row][col] == ' '){
                                cnt++;
                        }
                }
        }
        //Blank square count should be equal to playsLeft
        if (cp->playsLeft != cnt){
                printGrid(cp);                                  //debug code
                printf("playsLeft = %d\n", cp->playsLeft);      //debug code
                return 1;
        }
        return 0;
}

void move(struct config *cp) {
        //make next move
        if (cp->toplay == X) Xmove(cp);            //make an X move
        //if (cp->toplay == X) mymove(cp);         //or play X manually
        else Omove(cp);                            //make an O move
        //else mymove(cp);                         //or play O manually
        cp->playsLeft--;
        cp->toplay ^= 1;                           //alternate X and O
        return;
}

enum player play(struct config *cp){
        //play one game and return the winner
        enum player winner;
        if (pflag){
                printf ("It is %c\'s turn with %d moves left.\n", (cp->toplay == X) ? 'X' : 'O', cp->playsLeft);
                printGrid(cp);
                //fflush(stdout);
        }

        while (cp->playsLeft > 0){
                move(cp);
                
                if (eval(cp) == X) {
                        break;
                }
                if (pflag){
                        printf("It is %c\'s turn with %d moves left.\n", (cp->toplay == X) ?'X' : 'O', cp->playsLeft);
                        printGrid(cp);
                }
        }
        winner = eval(cp);
        return winner;
}


int main(int argc, char *argv[]){
        int i, nruns, seed, Xwins = 0, Owins = 0;
        struct config g = game;                 //set to initial state
        pflag = 1;                              //set pflag to 0 to suppress all printing
        seed = ((int) time(NULL)) % 1000000;    //make the games different
        srand(seed);
        if (pflag) printf("seed = %d\n", seed); //optional, use for debugging
        if (argc > 1){                          //if user gives a command line argument it is games to play
                pflag = 0;
                nruns = atoi(argv[1]);          //number of games to play
                for (i = nruns; i > 0; i--){
                        g = game;               //reset to initial state
                        wintype = 0;            //reset
                        (play(&g) == X) ? Xwins++ : Owins++;
                }
                printf("%d games played.  %d wins for X, %d wins for O\n", nruns, Xwins, Owins);
        }
        else if (pflag) {
                printf("The winner is %c\n", (play(&g) == X) ? 'X' : 'O');
                printGrid(&g);
                //fflush(stdout);
        }
        return 0;
}
