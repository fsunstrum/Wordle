package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//Represents a list of Words
public class WordList implements Writable {
    private final ArrayList<Word> words;
    private String mystWord;

    //Modifies: this
    //Effects: creates a new empty WordList object, with a null mystery word
    public WordList(String m) {
        words = new ArrayList<>();
        this.mystWord = m;
    }

    //Modifies: this
    //Effects: sets the random mystery word
    //public void setMystWord(String w) {
//        String this.mystWord = w;
//    }

    //Effects: returns the mystry word associated with the current game
    public String getMystWord() {
        return this.mystWord;
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
    public Word getRandomWord() {
        int index = (int) (Math.random() * (words.size()));
        return words.get(index);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("words", wordsToJson());
        json.put("mystWord",this.mystWord);
        return json;
    }

    // EFFECTS: returns words in this wordlist as a JSON array
    private JSONArray wordsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Word w : words) {
            jsonArray.put(w.toJson());
        }
        return jsonArray;
    }
}
