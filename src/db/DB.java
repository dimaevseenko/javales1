package db;

import db.mark.MarkTable;
import db.mark.MarkTableImpl;
import db.user.UserTable;
import db.user.UserTableImpl;

import java.sql.*;

public class DB {

    protected Connection connection;

    protected DB() throws Exception {
        connect(DBConfig.getDBEvseenkoConfig().get("name"),
                DBConfig.getDBEvseenkoConfig().get("user"),
                DBConfig.getDBEvseenkoConfig().get("password"));
    }

    protected Connection connect(String dbName, String dbUser, String dbPassword) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = String.format("jdbc:mysql://db4free.net:3306/%s?serverTimezone=UTC", dbName);
        connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
        return connection;
    }

    public static UserTable getUserTable() throws Exception {
        return UserTableImpl.getInstance();
    }

    public static MarkTable getMarkTable() throws Exception {
        return MarkTableImpl.getInstance();
    }
}
