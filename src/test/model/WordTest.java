package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordTest {
    private Word testMyst;
    private Word testWord1;
    private Word testWord2;

    @BeforeEach
    void runBefore() {
        testMyst = new Word("PLANT");
        testWord1 = new Word("CRANE");
        testWord2 = new Word("CLOAK");
    }

    @Test
    void checkWordTest() {
        String given = testWord1.getWord();
        testWord1.checkWord();
        char[] expectedResult1 = {'R', 'R', 'G', 'G', 'R'};
        assertArrayEquals(testWord1.result, expectedResult1);
        testWord2.checkWord();
        char[] expectedResult2 = {'R','G','R','Y','R'};
        assertArrayEquals(testWord2.result, expectedResult2);

        Word testWord3 = new Word("PPPPP");
        char[] expectedResult3 = {'G','Y','Y','Y','Y'};
        testWord3.checkWord();
        assertArrayEquals(testWord3.result, expectedResult3);

        Word testWord4 = new Word("XXXXX");
        char[] expectedResult4 = {'R','R','R','R','R'};
        testWord4.checkWord();
        assertArrayEquals(testWord4.result, expectedResult4);

        Word testWord5 = new Word("PLANT");
        char[] expectedResult5 = {'G','G','G','G','G'};
        testWord5.checkWord();
        assertArrayEquals(testWord5.result, expectedResult5);

    }

    @Test
    void isPresentTest() {
        assertTrue(testMyst.isPresent('P'));
        assertTrue(testMyst.isPresent('L'));
        assertTrue(testMyst.isPresent('T'));
        assertFalse(testMyst.isPresent('Z'));
    }

    @Test
    void isSolvedTest(){
        testWord1.checkWord();
        assertFalse(testWord1.isSolved());
        Word testWord5 = new Word("PLANT");
        testWord5.checkWord();
        assertTrue(testWord5.isSolved());
    }
}
