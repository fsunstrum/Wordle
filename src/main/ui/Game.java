package ui;

import model.Word;
import model.WordList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//WORDLE game remake
public class Game {
    private static final String JSON_STORE = "./data/wordlist.json";
    public final Scanner scanner;
    private WordList wordBank;
    private WordList wordLog;
    private Word currentGuess;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //Effects: creates a new Game object and runs the game
    public Game() throws FileNotFoundException {
        wordBank = new WordList("");
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

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runGame();
    }

    //Modifies: this
    //Processes user input and provides feedback
    private void runGame() {
        wordLog = new WordList(wordBank.getRandomWord().getWord());
        boolean keepGoing = true;

        printInstructions();
        String instruction = scanner.nextLine();
        if (instruction.equals("l")) {
            loadWordList();
            System.out.println("Here are your previous guesses:");
            for (Word w : wordLog.getWords()) {
                System.out.println(w.getWord());
            }
            continueGame(keepGoing);
        } else {
            //this.wordLog.setMystWord(wordBank.getRandomWord().getWord());
            continueGame(keepGoing);
        }
    }

    private void continueGame(boolean keepGoing) {
        while (keepGoing) {
            String stringGuess = scanner.nextLine();
            if (stringGuess.equals("q")) {
                keepGoing = false;
            } else {
                processInput(stringGuess);
            }
            if (currentGuess.isSolved()) {
                congratulate();
                break;
            } else {
                System.out.println(currentGuess.getResults());
                System.out.println("enter s to save,l to load, q to quit, or:");
                System.out.println("Enter your next guess (must be a 5-letter word):");
            }
        }
    }

    private void processInput(String input) {
        if (input.equals("s")) {
            saveWordList();
        } else if (input.equals("l")) {
            loadWordList();
        }
        this.currentGuess = new Word(input.toUpperCase());
        if (input.length() != 5) {
            System.out.println("Too many/few letters. Please enter a 5-letter word.");
        } else {
            wordLog.addWord(this.currentGuess);
            currentGuess.checkWord(this.wordLog.getMystWord());
        }
    }

    //Effects: congratulates the user for solving the puzzle, and provides some recap information
    private void congratulate() {
        System.out.println("Congratulations! You guessed the mystery word in "
                + wordLog.getWords().size()
                + " attempt" + (wordLog.getWords().size() == 0 ? "." : "s"));
        if (wordLog.getWords().size() > 1) {
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
        System.out.println("Press l to load your previous game or a five-letter word to start a new game");
        //System.out.println("Please enter your first guess (must be a 5-letter word):");
    }

    //Effects: saves wordList to file
    private void saveWordList() {
        try {
            jsonWriter.open();
            jsonWriter.write(wordLog);
            jsonWriter.close();
            System.out.println("saved current game to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //Modifies: this
    //Effects: loads wordList from File
    private void loadWordList() {
        try {
            wordLog = jsonReader.read();
            System.out.println("Loaded previous game from" + JSON_STORE);

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
