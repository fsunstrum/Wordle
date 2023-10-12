package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class WordBankTest {
    private WordBank testBank;

    @BeforeEach
    void runBefore(){
        testBank = new WordBank();
    }

    @Test
    void testConstructor(){
        assertTrue(testBank.bank.isEmpty());
    }

    @Test
    void testAddWord(){
        //testBank.bank
    }
}
