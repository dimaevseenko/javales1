package db;

import model.User;
import model.Users;
import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class DB implements UserDB{

    private Connection connection;

    private static DB instance;

    private DB() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/testevseenkodv?serverTimezone=UTC", "evseenko", "Pizzamand110");
    }

    public static DB getInstance() throws Exception {
        if(instance == null)
            instance = new DB();
        return instance;
    }

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
}
