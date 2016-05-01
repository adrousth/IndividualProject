package library.results;

/**
 * Created by Alex on 4/22/2016.
 */
public class NewUserResults extends Results {
    private int newUserId;
    private String newUserPassword;


    public NewUserResults() {
        super();
    }

    public int getNewUserId() {
        return newUserId;
    }

    public void setNewUserId(int newUserId) {
        this.newUserId = newUserId;
    }

    public String getNewUserPassword() {
        return newUserPassword;
    }

    public void setNewUserPassword(String newUserPassword) {
        this.newUserPassword = newUserPassword;
    }
}
