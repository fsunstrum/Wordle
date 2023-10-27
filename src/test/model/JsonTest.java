package model;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkWord(String s, String result, Word word) {
        assertEquals(s, word.getWord());
        assertEquals(result,word.getResults());
    }
}
