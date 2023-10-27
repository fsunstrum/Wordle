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
    void testConstructor() {
        assertEquals("PLANT", testMyst.getWord());
        String res = testWord1.getResults();
        assertEquals(5, res.length());
    }


    @Test
    void checkWordTest() {
        testWord1.checkWord("PLANT");
        String expectedResult1 = "RRGGR";
        assertEquals(testWord1.getResults(), expectedResult1);
        testWord2.checkWord("PLANT");
        String expectedResult2 = "RGRYR";
        assertEquals(testWord2.getResults(), expectedResult2);

        Word testWord3 = new Word("PPPPP");
        String expectedResult3 = "GYYYY";
        testWord3.checkWord("PLANT");
        assertEquals(testWord3.getResults(), expectedResult3);

        Word testWord4 = new Word("XXXXX");
        String expectedResult4 = "RRRRR";
        testWord4.checkWord("PLANT");
        assertEquals(testWord4.getResults(), expectedResult4);

        Word testWord5 = new Word("PLANT");
        String expectedResult5 = "GGGGG";
        testWord5.checkWord("PLANT");
        assertEquals(testWord5.getResults(), expectedResult5);

        Word testWord6 = new Word("PLANT");
        String expectedResult6 = "RGRRR";
        testWord6.checkWord("CLOCK");
        assertEquals(expectedResult6, testWord6.getResults());

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
        assertEquals("RRGGR", testWord1.getResults());
    }

//    @Test
//    public void getWordTest() {
//        assertEquals(testWord1.getWord(),testWord1.word);
//    }

}
