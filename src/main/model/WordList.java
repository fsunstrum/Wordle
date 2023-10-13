package model;

import java.util.ArrayList;

public class WordList {
    private final ArrayList<Word> words;

    public WordList() {
        words = new ArrayList<Word>();
    }

    public void addWord(Word w) {
        String s = w.getWord();
        if (s.length() == 5) {
            words.add(w);
        }
    }


    public ArrayList<Word> getWords() {
        return words;
    }

    public int wordListLength() {
        return words.size();
    }

    public Word getRandomWord() {
        int index = (int) (Math.random() * (words.size()));
        return words.get(index);
    }
}
