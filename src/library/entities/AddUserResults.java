package library.entities;

import java.util.ArrayList;

/**
 * Created by Alex on 4/22/2016.
 */
public class AddUserResults {
    private ArrayList<String> messages;
    private boolean success;
    private int newUserId;
    private String newUserPassword;


    public AddUserResults() {
        messages = new ArrayList<>();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getNewUserId() {
        return newUserId;
    }

    public void setNewUserId(int newUserId) {
        this.newUserId = newUserId;
    }

    public ArrayList<String> getMessages() {

        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public String getNewUserPassword() {
        return newUserPassword;
    }

    public void setNewUserPassword(String newUserPassword) {
        this.newUserPassword = newUserPassword;
    }
}
