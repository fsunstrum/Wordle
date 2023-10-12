package ui;

import model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private List<String> wordBank = new ArrayList<>();
    private List<Word> wordLog;

    public Game() {
        wordLog = new ArrayList<Word>();
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        runGame();
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void runGame() {
        String stringGuess;
        Word wordGuess;
        int count = 1;

        printInstructions();
        while (true) {
            stringGuess = scanner.nextLine();
            if (stringGuess.length() != 5) {
                System.out.println("Please enter a 5-letter word!!!");
                continue;
            }
            wordGuess = new Word(stringGuess.toUpperCase());
            wordGuess.checkWord();
            wordLog.add(wordGuess);
            if (wordGuess.isSolved()) {
                if (count == 1) {
                    System.out.println("Congratulations! You have guessed the mystery word in one attempt."
                            + "Impressive!");
                    break;
                } else {
                    System.out.println("Congratulations! You have guessed the mystery word in " + count + " attempts");
                    System.out.println("Here are the words you guessed:");
                    for (Word w : wordLog) {
                        System.out.println(w.getWord());
                    }
                    break;
                }
            } else {
                System.out.println(wordGuess.getResults());
                System.out.println("Please enter your next guess (must be a 5-letter word):");
                count++;
            }
        }
    }

    private void processInput(String guess) {
        Word wordGuess = new Word(guess.toUpperCase());

    }

    private void printInstructions() {
        System.out.println("The goal is to guess a mystery five-letter word.");
        System.out.println("You will receive feedback based on each character you entered.");
        System.out.println("R means the letter is not in the word,");
        System.out.println("Y means the letter is in the word in another position,");
        System.out.println("and G means the letter is in the word at that position.");
        System.out.println("Please enter your first guess (must be a 5-letter word):");
    }
}
