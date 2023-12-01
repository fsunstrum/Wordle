package ui;

import model.Word;
import model.WordList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

//WORDLE game remake
public class GameWithUI {
    private static final String JSON_STORE = "./data/wordlist.json";
    private WordList wordBank;
    private WordList wordLog;
    //private Word currentGuess;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private GamePanel gamePanel;

    //Effects: creates a new Game object and runs the game
    public GameWithUI() throws FileNotFoundException {

        wordBank = new WordList("");

        gamePanel = new GamePanel(this);

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

        wordLog = new WordList(wordBank.getRandomWord().getWord());


        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }


    //Modifies: this.WordLog
    //Effects: checks the validity of a guess
    public void processInput(Word input) {
        input.checkWord(this.wordLog.getMystWord());
        wordLog.addWord(input);
    }

    //Effects: congratulates the user for solving the puzzle, and provides some recap information
    public String congratulate() {
        return "Congratulations! You guessed the mystery word in "
                + wordLog.getWords().size()
                + " attempt" + (wordLog.getWords().size() == 1 ? "." : "s");


    }


    //Effects: saves wordList to file
    public void saveWordList() {
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
    public void loadWordList() {
        try {
            wordLog = jsonReader.read();

            System.out.println("Loaded previous game from" + JSON_STORE);

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //EFFECTS: returns the list of entered words
    public ArrayList<Word> getWordLog() {
        return this.wordLog.getWords();
    }
}
