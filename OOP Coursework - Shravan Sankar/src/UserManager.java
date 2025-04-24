import java.io.*;
import java.util.*;

public class UserManager {
    private Map<String, Role> Users;
    String filename = "C:\\Users\\shrav\\eclipse-workspace\\OOP Coursework - Shravan Sankar\\src\\UserAccounts.txt";
    private int UserID;

    public UserManager(String filename) throws IOException {
        Users = new HashMap<>();
        this.filename = filename;
        UserID = 104;
        UsersFrom(filename);
    }

    private void UsersFrom(String filename) throws IOException {
        int maxID = 104;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != 7) continue;
                String userID = values[0].trim();
                String username = values[1].trim();
                String name = values[2].trim();
                int houseNumber = Integer.parseInt(values[3].trim());
                String postcode = values[4].trim();
                String city = values[5].trim();
                String role = values[6].trim();

                Address address = new Address(houseNumber, postcode, city);
                Role user;
                if (role.equalsIgnoreCase("admin")) {
                    user = new Admin(userID, username, name, address);
                } else {
                    user = new Customer(userID, username, name, address);
                }
                Users.put(username, user);

                try {
                    int numericID = Integer.parseInt(userID);
                    if (numericID > maxID) {
                        maxID = numericID;
                    }
                } catch (NumberFormatException ignored) {}
            }
        }
        UserID = maxID + 1;
    }

    public String newUserID() {
        return String.valueOf(UserID++);
    }

    public Role authenticateUser(String username) {
        return Users.get(username);
    }

    public void addUser(String username, String name, int houseNum, String postcode, String city, String role) throws IOException {
        String userID = newUserID();
        Address address = new Address(houseNum, postcode, city);

        Role user;
        if (role.equalsIgnoreCase("admin")) {
            user = new Admin(userID, username, name, address);
        } else {
            user = new Customer(userID, username, name, address);
        }

        Users.put(username, user);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(userID + ", " + username + ", " + name + ", " + houseNum + ", " + postcode + ", " + city + ", " + role);
            writer.newLine();
        }
    }
}
