package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
//Templated from JsonSerializationDemo.JsonReader.java
public class JsonReader {
    private String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    public String getWord(int index) throws IOException {
        String data = readFile(source);
        JSONArray jsonarray = new JSONArray(data);
        return jsonarray.getString(index);
    }

    // EFFECTS: reads wordList from File and returns it;
    // throws IOException if an error occurs reading data from file
    public WordList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWordList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    //MODIFIES: wl
    //EFFECTS: parses wordList from JSON object and returns it
    private WordList parseWordList(JSONObject jsonObject) {
        String mystWord = jsonObject.getString("mystWord");
        WordList wl = new WordList();
        wl.setMystWord(mystWord);
        addWords(wl, jsonObject);
        return wl;
    }

    //MODIFIES: wl
    //EFFECTS: parses words from JSON object and adds it to wordList
    private void addWords(WordList wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("words");
        for (Object json : jsonArray) {
            JSONObject nextWord = (JSONObject) json;
            addWord(wl, nextWord);
        }
    }

    //MODIFIES: wl
    //EFFECTS: parses word from JSON object and adds them to wordList
    private void addWord(WordList wl, JSONObject jsonObject) {
        String word = jsonObject.getString("word");
        String result = jsonObject.getString("result");
        Word wordToAdd = new Word(word);
        wordToAdd.setResult(result);
        wl.addWord(wordToAdd);
    }
}
