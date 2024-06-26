package persistence;

import model.Word;
import model.WordList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

public class JsonWriterTest extends JsonTest {


    @Test
    void testWriterInvalidFile() {
        try {
            WordList wl = new WordList();
            wl.setMystWord("CANOE");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWordList() {
        try {
            WordList wl = new WordList();
            wl.setMystWord("APPLE");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            wl = reader.read();
            assertEquals("APPLE", wl.getMystWord());
            assertEquals(0, wl.wordListLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWordList() {
        try {
            WordList wl = new WordList();
            wl.setMystWord("WORDS");
            wl.addWord(new Word("SNOOP"));
            wl.addWord(new Word("MOOSE"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWordList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWordList.json");
            wl = reader.read();
            assertEquals("WORDS", wl.getMystWord());
            List<Word> words = wl.getWords();
            assertEquals(2, words.size());
            checkWord("SNOOP", "", words.get(0));
            checkWord("MOOSE", "", words.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
