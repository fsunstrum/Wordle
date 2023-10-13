package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static model.Word.wordBank;
import static org.junit.jupiter.api.Assertions.*;

public class WordListTest {
    private WordList testWords;
    private WordList wordBank;

    @BeforeEach
    void runBefore(){
        testWords = new WordList();
        wordBank = new WordList();
        wordBank.addWord(new Word("PLANT"));
        wordBank.addWord(new Word("HORSE"));
    }


    @Test
    public void addWordAndLengthTest() {
        assertEquals(0,testWords.wordListLength());
        testWords.addWord(new Word("blobs"));
        assertEquals(1,testWords.wordListLength());
        testWords.addWord(new Word ("snake"));
        assertEquals(2,testWords.wordListLength());
    }

    @Test
    public void getWordsTest() {
        ArrayList<Word> test = wordBank.getWords();
        assertFalse(test.isEmpty());
        assertEquals(2, test.size());
    }

    @Test
    public void getRandomWordTest() {
        Word testWord = wordBank.getRandomWord();
        assertTrue(wordBank.getWords().contains(testWord));

    }


    }
