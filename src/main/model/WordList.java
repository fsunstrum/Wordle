package model;

import java.util.ArrayList;

//Represents a list of Words
public class WordList {
    private final ArrayList<Word> words;

    //Modifies: this
    //Effects: creates a new empty WordList object
    public WordList() {
        words = new ArrayList<>();
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
}
