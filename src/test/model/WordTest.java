package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordTest {
    private Word testMyst;
    private Word testMyst2;
    private Word testWord1;
    private Word testWord2;

    @BeforeEach
    void runBefore() {
        testMyst = new Word("PLANT");
        testMyst2 = new Word("CANOE");
        testWord1 = new Word("CRANE");
        testWord2 = new Word("CLOAK");
    }

    @Test
    void testConstructor() {
        assertTrue(testMyst.word == "PLANT");
        char[] res = testWord1.getResults();
        assertEquals(5, res.length);
    }


    @Test
    void checkWordTest() {
        String given = testWord1.getWord();
        testWord1.checkWord("PLANT");
        char[] expectedResult1 = {'R', 'R', 'G', 'G', 'R'};
        assertArrayEquals(testWord1.result, expectedResult1);
        testWord2.checkWord("PLANT");
        char[] expectedResult2 = {'R', 'G', 'R', 'Y', 'R'};
        assertArrayEquals(testWord2.result, expectedResult2);

        Word testWord3 = new Word("PPPPP");
        char[] expectedResult3 = {'G', 'Y', 'Y', 'Y', 'Y'};
        testWord3.checkWord("PLANT");
        assertArrayEquals(testWord3.result, expectedResult3);

        Word testWord4 = new Word("XXXXX");
        char[] expectedResult4 = {'R', 'R', 'R', 'R', 'R'};
        testWord4.checkWord("PLANT");
        assertArrayEquals(testWord4.result, expectedResult4);

        Word testWord5 = new Word("PLANT");
        char[] expectedResult5 = {'G', 'G', 'G', 'G', 'G'};
        testWord5.checkWord("PLANT");
        assertArrayEquals(testWord5.result, expectedResult5);

        Word testWord6 = new Word("PLANT");
        char[] expectedResult6 = {'R', 'G', 'R', 'R', 'R'};
        testWord6.checkWord("CLOCK");
        assertArrayEquals(expectedResult6, testWord6.result);

    }

    @Test
    void isPresentTest() {
        assertTrue(testMyst.isPresent('P', "PLANT"));
        assertTrue(testMyst.isPresent('L', "PLANT"));
        assertTrue(testMyst.isPresent('T',"PLANT"));
        assertFalse(testMyst.isPresent('Z',"PLANT"));

    }

    @Test
    void isSolvedTest() {
        testWord1.checkWord("PLANT");
        assertFalse(testWord1.isSolved());
        Word testWord5 = new Word("PLANT");
        testWord5.checkWord("PLANT");
        assertTrue(testWord5.isSolved());
    }

    @Test
    void getResultTest() {
        testWord1.checkWord("PLANT");
        assertArrayEquals(new char[]{'R', 'R', 'G', 'G', 'R'}, testWord1.getResults());
    }

    @Test
    public void getWordTest() {
        assertEquals(testWord1.getWord(),testWord1.word);
    }

}
