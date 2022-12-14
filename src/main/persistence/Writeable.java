package persistence;

import org.json.JSONObject;

// Writeable interface
public interface Writeable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
