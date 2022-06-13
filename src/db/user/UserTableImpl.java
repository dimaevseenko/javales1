package db.user;

import db.DB;
import model.User;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTableImpl extends DB implements UserTable {

    private static UserTableImpl instance;

    private UserTableImpl() throws Exception {}

    @Override
    public void addUser(User user) {
        String query = String.format("insert into users(name) values('%s')", user.getName());
        try(Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUser(int id) {
        User user = null;
        String query = String.format("select * from users where id = %d", id);
        try(Statement stmt = connection.createStatement()) {
            ResultSet userResult = stmt.executeQuery(query);
            while(userResult.next()){
                user = new User(
                        userResult.getInt("id"),
                        userResult.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public Users getUsers() {
        Users users = new Users();
        String query = "select * from users";
        try(Statement stmt = connection.createStatement()) {
            ResultSet usersResult = stmt.executeQuery(query);

            while (usersResult.next()){
                users.add(new User(
                        usersResult.getInt("id"),
                        usersResult.getString("name")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void removeUser(int userId){
        String query = String.format("delete from users where id = %d", userId);
        try(Statement stmt = connection.createStatement()){
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserTableImpl getInstance() throws Exception {
        if(instance == null)
            instance = new UserTableImpl();
        return instance;
    }
}

