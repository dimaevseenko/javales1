package db;

import model.User;
import model.Users;

public interface UserDB {
    public void addUser(User user);
    public void removeUser(int userId);
    public User getUser(int id);
    public Users getUsers();
}
