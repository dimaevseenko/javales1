package db;

import db.mark.MarkTable;
import db.mark.MarkTableImpl;
import db.user.UserTable;
import db.user.UserTableImpl;
import model.User;

import java.sql.*;

public class UserDB {

    private Connection connection;

    private static UserDB instance;

    private UserDB() throws Exception {
        if (connect(DBConfig.getDBEvseenkoConfig().get("host"),
                DBConfig.getDBEvseenkoConfig().get("name"),
                DBConfig.getDBEvseenkoConfig().get("user"),
                DBConfig.getDBEvseenkoConfig().get("password")) == null)
            return;
    }

    protected Connection connect(String host, String dbName, String dbUser, String dbPassword) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = String.format("jdbc:mysql://%s/%s?serverTimezone=UTC", host, dbName);
        System.out.println(String.format("Connecting to %s...", host));
        connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
        return connection;
    }

    public UserTable getUserTable() throws Exception {
        return UserTableImpl.getInstance(connection);
    }

    public MarkTable getMarkTable() throws Exception {
        return MarkTableImpl.getInstance(connection);
    }

    public static final UserDB getInstance() throws Exception {
        if(instance == null)
            instance = new UserDB();
        return instance;
    }
}
