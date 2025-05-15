package app.coding;

public class UserData  extends Data{

    private String username;

    public UserData(String id, String username) {
        super(id);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserData [id=" + getId() + ", username=" + username + "]";
    }
}
