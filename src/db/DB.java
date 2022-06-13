package db;

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
}
