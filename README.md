# WORDLE remake

- What will the application do?

I want to remake the popular NYT word puzzle game WORDLE. In this game, players will attempt to guess a mystery five-letter word.
After they enter and submit their first guess, the individual letters will be colored grey if they are not found in the mystery word, yellow if they are found in the mystery word, and green if they are found in the mystery word *in that position*. For example, if the mystery word is *bridge*, and the player enters the word *flare*, the first three letters "f", "l", and "a" will be colored grey, the "r" will be colored yellow since it is found in bridge, but in another position, and the "e" will be colored green.
The player will then have the opportunity to enter a subsequent guess and receive the same type of feedback. The goal is to guess the mystery word in the fewest number of guesses.
If the player enters the mystery word, then all 5 letters will be colored green and the game will finish. I also hope to add a functionality where the player can see a graph of how many guesses were required in their game history, and some summary statistics about their performance.
This version of the game will differ from the original WORDLE in the sense that the player will be allowed to enter unlimited guesses to satisfy the requirements. 


- Who will use it?

The project is intended for word puzzle enthusiasts.


- Why is this project of interest to you?

As a word puzzle enthusiast myself, I look forward to figuring out how such a puzzle is implemented, and perhaps gain inspiration for further variations to this popular game. 

## User stories

- I want to be able to enter individual letters on the game board to form a five-letter word
- I want to be able to submit my word
- I want to be a able to receive feedback on whether the entered letters are present in the mystery word
  - I want to be able to receive feedback on whether the present letter(s) are already in the right position
- I want to be able to view a graph of my previous games, showing trends in how many guesses I needed to find the mystery word
