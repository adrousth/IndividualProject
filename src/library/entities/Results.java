package library.entities;

import java.util.ArrayList;

/**
 * Created by Alex on 4/28/2016.
 */
public abstract class Results {
    protected boolean success;
    protected ArrayList<String> messages;

    public Results() {
        messages = new ArrayList<>();
    }


    public void addMessage(String message) {
        messages.add(message);
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
