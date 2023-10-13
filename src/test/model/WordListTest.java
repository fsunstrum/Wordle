package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordListTest {
    private WordList testWords;

    @BeforeEach
    void runBefore(){
        testWords = new WordList();
    }

    @Test
    public void addWordAndLengthTest() {
        assertEquals(0,testWords.wordListLength());
        testWords.addWord(new Word("blobs"));
        assertEquals(1,testWords.wordListLength());
        testWords.addWord(new Word ("snake"));
        assertEquals(2,testWords.wordListLength());
    }


}
