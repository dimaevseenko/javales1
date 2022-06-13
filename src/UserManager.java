import db.DB;
import db.UserDB;
import model.User;

import java.util.Scanner;

public class UserManager {

    private static UserManager instance;

    private UserDB usersDB = DB.getInstance();

    private UserManager() throws Exception {}

    public void startSelector(){
        System.out.println("\n1. Add User");
        System.out.println("2. Get Users");
        System.out.println("3. Get User");
        System.out.println("4. Delete User");

        Scanner scanner = new Scanner(System.in);

        String option = scanner.next();

        if(option.equals("1"))
            addUser(scanner.next());
        else
        if(option.equals("2"))
            getUsers();
        else
        if(option.equals("3"))
            getUser(Integer.parseInt(scanner.next()));
        else
        if(option.equals("4"))
            deleteUser(Integer.parseInt(scanner.next()));
        else
            startSelector();
    }

    private void deleteUser(int id) {
        usersDB.removeUser(id);
        getUsers();
        startSelector();
    }

    private void getUser(int id) {
        System.out.println(usersDB.getUser(id));
        startSelector();
    }

    private void getUsers() {
        for (User user : usersDB.getUsers()) {
            System.out.println(user);
        }
        startSelector();
    }

    private void addUser(String name) {
        usersDB.addUser(new User(name));
        getUsers();
    }

    public static UserManager getInstance() throws Exception {
        if(instance == null)
            instance = new UserManager();
        return instance;
    }
}
