package persistence;

import model.*;
import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkWord(String s, String result, Word word) {
        assertEquals(s, word.getWord());
        assertEquals(result,word.getResults());
    }
}
