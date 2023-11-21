package model;


import org.json.JSONObject;
import persistence.Writable;

import static java.lang.Boolean.*;

//Represents a 5-letter word, and information on which of its characters are present in the mystery word.
public class Word implements Writable {
    private String word;
    private String result;
    //private boolean solved;

    static int MAXINDEX = 4;

    //Requires: a five-letter word
    //Modifies: this
    //Effects: creates a new Word object with a string value and an empty list of results
    public Word(String word) {
        this.word = word;
        this.result = "";
        //this.solved = false;
    }


    //Requires: a String of length 5
    //Modifies: this
    //Effects: populates this.result with each letter's respective validity (G, Y, R). G for green, letter is in right
    //         position, Y for yellow, letter is in word but different position, R for Red, letter is not in word.
    public void checkWord(String m) {
        char[] values = new char[5];
        for (int index = 0; index <= MAXINDEX; index++) {
            if (this.word.charAt(index) == m.charAt(index)) {
                values[index] = 'G';
            } else {
                if (isPresent(this.word.charAt(index), m)) {
                    values[index] = 'Y';
                } else {
                    values[index] = 'R';
                }
            }
        }
        this.result = new String(values);
    }


    //Effects: produce TRUE if word has been guessed. IE result = {'G','G','G','G','G'}. Else FALSE
    public boolean isSolved() {
        return this.result.equals("GGGGG");
//        this.solved = this.result.equals("GGGGG");
//        return this.solved;
    }

    //Requires: a character and a 5-letter Word
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

    public String getResults() {
        return this.result;
    }

    public void setResult(String r) {
        this.result = r;
    }

    //Templated from JsonSerializationDemo.Thingy.java
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("word", word);
        json.put("result", result);
        return json;
    }

    public void temporarySetResultForTesting() {
        this.result = "RGYYG";
    }
}
