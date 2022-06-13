import db.mark.MarkTable;
import db.mark.MarkTableImpl;
import db.user.UserTable;
import db.user.UserTableImpl;
import model.Mark;
import model.User;

import java.util.Scanner;

public class UserManager {

    private static UserManager instance;

    private UserTable usersDB = UserTableImpl.getInstance();
    private MarkTable markDB = MarkTableImpl.getInstance();

    private UserManager() throws Exception {}

    public void startSelector(){
        System.out.println("\n1. Add User");
        System.out.println("2. Get Users");
        System.out.println("3. Get User");
        System.out.println("4. Delete User");
        System.out.println("5. Users Marks");
        System.out.println("6. User Marks");

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
        if(option.equals("5"))
            usersMarks();
        else
        if(option.equals("6"))
            userMarks(Integer.parseInt(scanner.next()));
        startSelector();
    }

    private void userMarks(int id){
        for(Mark mark: markDB.getMarksForUserId(id)){
            System.out.println(mark);
        }
    }

    private void usersMarks(){
        for(Mark mark: markDB.getMarks()){
            System.out.println(mark);
        }
    }

    private void deleteUser(int id) {
        usersDB.removeUser(id);
        getUsers();
    }

    private void getUser(int id) {
        System.out.println(usersDB.getUser(id));
    }

    private void getUsers() {
        for (User user : usersDB.getUsers()) {
            System.out.println(user);
        }
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
