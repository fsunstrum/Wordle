package persistence;
import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WordList wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyWorkWoom() {
        JsonReader reader = new JsonReader("data/testReaderEmptyWordList.json");
        try {
            WordList wl = reader.read();
            assertEquals(0,wl.wordListLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWordList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWordList.json");
        try {
            WordList wl = reader.read();
            assertEquals("HORSE", wl.getMystWord());
            List<Word> words = wl.getWords();
            assertEquals(3,words.size());
            checkWord("PLANT","RRRRR",words.get(0));
            checkWord("GREAT","RYYRR",words.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
