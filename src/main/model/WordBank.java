package model;

import java.util.ArrayList;
import java.util.List;

public class WordBank {
    public List<String> bank;

    public WordBank() {
        bank = new ArrayList<>();
    }

    public void addWord(String word) {
        this.bank.add(word);
    }


}
