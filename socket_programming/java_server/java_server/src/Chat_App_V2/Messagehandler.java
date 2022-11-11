package Chat_App_V2;

import java.util.HashMap;

public class Messagehandler {
    HashMap messages = new HashMap();
    String key;
    String value;

    Messagehandler() {

    }

    public Messagehandler(String key, String  value) {
        this.key = key;
        this.value = value;
        messages.put(key, value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HashMap getMessages() {
        return messages;
    }
}
