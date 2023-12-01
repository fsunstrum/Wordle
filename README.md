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

- I want to be able to enter a word and be told if it has the right number of letters
- I want to receive feedback on which characters in my guessed word are in the right position, in the mystery word, or not present in the mystery word
- After guessing the correct word, I want to know how many attempts I needed, and to see which words I entered
- I want to replay the game with a new mystery word

- I want to have the option of saving an in-progress game
- I want the option to load a saved game when starting up a new game

## Instructions for Grader
- You can enter a 5-letter word in the text field at the bottom, then press the submit button.
- Look above the text field to see visual feedback on your guess. 
- Based on above feedback, enter more guesses until you are congratulated for guessing the mystery word.
- You will know you have guessed the word when a green banner will tell you how many guessed you used, and a cool guy emoji will appear next to the submit button. 
- At any time during a game, you can press the save button at the top to save the current game state to memory.
- At any time during a game, you can press the load button at the top to load a previously saved game. 

## Phase 4: Task 2
##### Sample EventLog printout:

Thu Nov 30 22:00:39 PST 2023

Game state saved

Thu Nov 30 22:00:42 PST 2023

Guess word has been entered and checked

Thu Nov 30 22:00:42 PST 2023

Mystery word has been guessed by user

Thu Nov 30 22:00:47 PST 2023

Guess word has been entered and checked

Thu Nov 30 22:00:47 PST 2023

Mystery word has been guessed by user

Thu Nov 30 22:00:49 PST 2023

Game state saved


## Phase 4: Task 3

The first refactoring I thought of doing is to better organize my panel classes. Now I have one main GamePanel that depends (dependency not visible on UML diagram) on the LetterPanel class. 
The letter panels are added and laid out locally using the swing methods, but I could have designed a class for a word panel, that has a field with 5 letter panels.
The word panels could possibly extend the Word class, with added graphical functionality while still having access to the Word fields. This would reduce the steps needed to convert a word to a series of LetterPanels.
The main GamePanel could then have a field of an arbitrary number of word panels. This would be very similar functionally but the coupling visible on the diagram would reflect the programs structure and function more accurately.
Alternatively, this main panel class could extend WordList, and add graphical functionality. Again, this would reduce the steps required to display all the guessed words.  

Another idea is to change how the individual letter results (red,yellow,green) are encoded. Currently, the word class has two string fields, one for the word, and one for the result. The result string is the same length as the word string, and its characters correspond to the characters in the word string. They are either R for red, Y for yellow, and G for green. I learned while making the GUI about the Color class, and thought that the result string could be replaced by a list of Colors (of length = 5) directly. This would remove the need for the step of converting the characters to their corresponding colors.




