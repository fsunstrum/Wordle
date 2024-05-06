package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.Writable;

import java.io.IOException;
import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

//import static ui.GameWithUI.JSON_STORE;

//Represents a list of Words
public class WordList implements Writable {
    private final ArrayList<Word> words;
    private String mystWord;
    private static final String JSON_STORE = "./data/5-letter-words.json";

    private JsonReader jsonReader;

//    public static final int WIDTH = 800;
//    public static final int HEIGHT = 600;

    //Modifies: this
    //Effects: creates a new empty WordList object, with a given mystery word
    public WordList() {
        words = new ArrayList<>();
        jsonReader = new JsonReader(JSON_STORE);
        int index = ThreadLocalRandom.current().nextInt(0, 9999 + 1);


        try {
            this.mystWord = jsonReader.getWord(index);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.mystWord = this.mystWord.toUpperCase();
    }



    //Effects: returns the mystery word associated with the current game
    public String getMystWord() {
        return this.mystWord;
    }

    public void setMystWord(String s) {
        this.mystWord = s;
    }

    //Modifies: this
    //Effects: adds given word to this wordlist
    public void addWord(Word w) {
        String s = w.getWord();
        if (s.length() == 5) {
            words.add(w);
        }
    }


    // Effects: returns all words in this wordlist
    public ArrayList<Word> getWords() {
        return words;
    }

    //Effects: returns number of words in this wordlist
    public int wordListLength() {
        return words.size();
    }

    //Effects: returns a random member of this wordlist
//    public Word getRandomWord() {
//        EventLog.getInstance().logEvent(new Event("Mystery word has been randomly selected"));
//        int index = (int) (Math.random() * (words.size()));
//        return words.get(index);
//    }

    // Templated from JsonSerializationDemo.WorkRoom.java
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("words", wordsToJson());
        json.put("mystWord",this.mystWord);
        return json;
    }

    // Templated from JsonSerializationDemo.WorkRoom.java
    // EFFECTS: returns words in this wordlist as a JSON array
    private JSONArray wordsToJson() {
        EventLog.getInstance().logEvent(new Event("Game state saved"));

        JSONArray jsonArray = new JSONArray();
        for (Word w : words) {
            jsonArray.put(w.toJson());
        }
        return jsonArray;
    }
}
