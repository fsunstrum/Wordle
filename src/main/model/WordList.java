package model;

import java.util.ArrayList;

public class WordList {
    private ArrayList<Word> words;

    public WordList() {
        words = new ArrayList<Word>();
    }

    public void addWord(Word w) {
        String s = w.getWord();
        if (s.length() == 5) {
            words.add(w);
        } else {
            System.out.println("please enter a 5 letter word");
        }
    }

    public Word getWord(int index) {
        return words.get(index);
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public int wordListLength() {
        return words.size();
    }

    public Word getRandomWord() {
        int index = (int) ((Math.random() * (words.size() - 0)) + 0);
        return words.get(index);
    }
}
