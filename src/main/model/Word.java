package model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class Word {
    String word;
    char[] result;

    static int MAXINDEX = 4;
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
    public void checkWord() {
        for (int index = 0; index <= MAXINDEX; index++) {
            if (this.word.charAt(index) == SAMPLEWORD.charAt(index)) {
                this.result[index] = 'G';
            } else {
                if (isPresent(this.word.charAt(index))) {
                    this.result[index] = 'Y';
                } else {
                    this.result[index] = 'R';
                }
            }
        }
    }

    //Requires: a character and a 5-letter Word
    //Modifies: ...
    //Effects: return True if the given character is found in the Word at the 2nd, 3rd, 4th, or 5th position, else False
    public Boolean isPresent(char given) {
        for (int i = 0; i <= MAXINDEX; i++) {
            if (SAMPLEWORD.charAt(i) == given) {
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
}
