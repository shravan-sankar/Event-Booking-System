public abstract class Role {
    protected String userID;
    protected String username;
    protected String name;
    protected Address address;

    public Role(String userID, String username, String name, Address address) {
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }
}
