package db.user;

import model.User;
import model.Users;

public interface UserTable {
    public void addUser(User user);
    public void removeUser(int userId);
    public User getUser(int id);
    public Users getUsers();
}
