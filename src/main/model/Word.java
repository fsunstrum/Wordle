package model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class Word {
    String word;
    char[] result;

    static int MAXINDEX = 4;
    static final List<String> wordBank = new ArrayList<String>() {
        {
            add("PLANT");
            add("HORSE");
            add("CORKS");
            add("VENUE");
            add("GREAT");
            add("CRAMP");
            add("PRANK");
            add("QUEST");
            add("BLUNT");
            add("WORSE");
        }
    };

    static String SAMPLEWORD = "PLANT";

    //Requires: a five-letter word
    //Modifies: this
    //Effects: creates a new Word object with a value and an empty list of results
    public Word(String word) {
        this.word = word;
        this.result = new char[5];
    }


    //Requires: a String of length 5
    //Modifies: this
    //Effects: populates this.result with each letter's respective validity (G, Y, R). G for green, letter is in right
    //         position, Y for yellow, letter is in word but different position, R for Red, letter is not in word.
    public void checkWord(String m) {
        for (int index = 0; index <= MAXINDEX; index++) {
            if (this.word.charAt(index) == m.charAt(index)) {
                this.result[index] = 'G';
            } else {
                if (isPresent(this.word.charAt(index), m)) {
                    this.result[index] = 'Y';
                } else {
                    this.result[index] = 'R';
                }
            }
        }
    }

    //Requires: a Word that has been checked
    //Modifies:...
    //Effects: produce TRUE if word has been guessed. IE result = {'G','G','G','G','G'}. Else FALSE
    public boolean isSolved() {
        for (int i = 0; i <= MAXINDEX; i++) {
            if (this.result[i] != 'G') {
                return FALSE;
            }
        }
        return TRUE;
    }

    //Requires: a character and a 5-letter Word
    //Modifies: ...
    //Effects: return True if the given character is found in the Word, else False
    public Boolean isPresent(char given, String m) {
        for (int i = 0; i <= MAXINDEX; i++) {
            if (m.charAt(i) == given) {
                return TRUE;
            }
        }
        return FALSE;
    }

    public String getWord() {
        return this.word;
    }

    public char[] getResults() {
        return this.result;
    }


}
