package ui;

import model.Word;
import model.WordList;

import java.util.Scanner;

//WORDLE game remake
public class Game {
    public final Scanner scanner;
    private WordList wordBank;
    private WordList wordLog;


    //Effects: creates a new Game object and runs the game
    public Game() {
        wordLog = new WordList();
        wordBank = new WordList();
        wordBank.addWord(new Word("PLANT"));
        wordBank.addWord(new Word("HORSE"));
        wordBank.addWord(new Word("CORKS"));
        wordBank.addWord(new Word("VENUE"));
        wordBank.addWord(new Word("GREAT"));
        wordBank.addWord(new Word("CRAMP"));
        wordBank.addWord(new Word("PRANK"));
        wordBank.addWord(new Word("QUEST"));
        wordBank.addWord(new Word("BLUNT"));
        wordBank.addWord(new Word("WORSE"));

        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        runGame();
    }


//    private void runGame() {
//        String stringGuess;
//        Word wordGuess;
//        int count = 1;
//        printInstructions();
//
//        while (true) {
//            stringGuess = scanner.nextLine();
//            if (stringGuess.length() != 5) {
//                System.out.println("Please enter a 5-letter word!!!");
//                continue;
//            }
//            wordGuess = new Word(stringGuess.toUpperCase());
//            wordGuess.checkWord();
//            wordLog.add(wordGuess);
//            if (wordGuess.isSolved()) {
//                if (count == 1) {
//                    System.out.println("Congratulations! You have guessed the mystery word in one attempt."
//                            + "Impressive!");
//                    break;
//                } else {
//                    System.out.println("Congratulations! You have guessed the mystery word in " + count + " 
//                    attempts");
//                    System.out.println("Here are the words you guessed:");
//                    for (Word w : wordLog) {
//                        System.out.println(w.getWord());
//                    }
//                    break;
//                }
//            } else {
//                System.out.println(wordGuess.getResults());
//                System.out.println("Please enter your next guess (must be a 5-letter word):");
//                count++;
//            }
//        }
//    }

    //Modifies: this
    //Processes user input and provides feedback
    private void runGame() {
        printInstructions();
        int count = 0;
        Word mystWord = wordBank.getRandomWord();
        String mystString = mystWord.getWord();
        while (true) {
            String stringGuess = scanner.nextLine();
            if (stringGuess.length() != 5) {
                System.out.println("Please enter a 5-letter word!!!");
                continue;
            }
            Word wordGuess = new Word(stringGuess.toUpperCase());
            wordGuess.checkWord(mystString);
            wordLog.addWord(wordGuess);
            if (wordGuess.isSolved()) {
                congratulate(count);
                break;
            } else {
                System.out.println(wordGuess.getResults());
                System.out.println("Please enter your next guess (must be a 5-letter word):");
                count++;
            }
        }
    }

    //Requires: count >= 0
    //Effects: congratulates the user for solving the puzzle, and provides some recap information
    private void congratulate(int count) {
        System.out.println("Congratulations! You guessed the mystery word in "
                + (count + 1) + " attempt" + (count == 0 ? "." : "s"));
        if (count > 0) {
            System.out.println("Here are the words you guessed:");
            for (Word w : wordLog.getWords()) {
                System.out.println(w.getWord());
            }
        }
    }


    //Effects: Prints instructions to user
    private void printInstructions() {
        System.out.println("The goal is to guess a mystery five-letter word.");
        System.out.println("You will receive feedback based on each character you entered.");
        System.out.println("R means the letter is not in the word,");
        System.out.println("Y means the letter is in the word in another position,");
        System.out.println("and G means the letter is in the word at that position.");
        System.out.println("Please enter your first guess (must be a 5-letter word):");
    }


}
