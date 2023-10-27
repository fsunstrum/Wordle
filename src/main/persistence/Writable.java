package persistence;

import org.json.JSONObject;

// Templated from JsonSerializationDemo.Writable.java

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
