import db.user.UserDB;
import model.Mark;
import model.User;

import java.util.Scanner;

public class UserManager {

    private static UserManager instance;

    private UserDB userDB = UserDB.getInstance();

    private UserManager() throws Exception {}

    public void startSelector() throws Exception {
        System.out.println("\n1. Add User");
        System.out.println("2. Get Users");
        System.out.println("3. Get User");
        System.out.println("4. Delete User");
        System.out.println("5. Users Marks");
        System.out.println("6. User Marks");
        System.out.println("7. Add Mark");
        System.out.println("8. Quit");

        Scanner scanner = new Scanner(System.in);

        String option = scanner.next();

        switch (option){
            case "1":
                addUser(scanner.next());
                break;
            case "2":
                getUsers();
                break;
            case "3":
                getUser(Integer.parseInt(scanner.next()));
                break;
            case "4":
                deleteUser(Integer.parseInt(scanner.next()));
                break;
            case "5":
                usersMarks();
                break;
            case "6":
                userMarks(Integer.parseInt(scanner.next()));
                break;
            case "7":
                addMark(Integer.parseInt(scanner.next()), scanner.next(), Integer.parseInt(scanner.next()));
                break;
            default:
                return;
        }

        startSelector();
    }

    private void addMark(int userId, String lessonName, int mark) throws Exception {
        userDB.getMarkTable().addMark(new Mark(new User(userId, null), lessonName, mark));
    }

    private void userMarks(int id) throws Exception {
        for(Mark mark: userDB.getMarkTable().getMarksForUserId(id)){
            System.out.println(mark);
        }
    }

    private void usersMarks() throws Exception {
        for(Mark mark: userDB.getMarkTable().getMarks()){
            System.out.println(mark);
        }
    }

    private void deleteUser(int id) throws Exception {
        userDB.getUserTable().removeUser(id);
        getUsers();
    }

    private void getUser(int id) throws Exception {
        System.out.println(userDB.getUserTable().getUser(id));
    }

    private void getUsers() throws Exception {
        for (User user : userDB.getUserTable().getUsers()) {
            System.out.println(user);
        }
    }

    private void addUser(String name) throws Exception {
        userDB.getUserTable().addUser(new User(name));
        getUsers();
    }

    public static UserManager getInstance() throws Exception {
        if(instance == null)
            instance = new UserManager();
        return instance;
    }
}
