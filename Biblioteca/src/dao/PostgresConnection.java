package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private String url = "jdbc:postgresql://localhost/Biblioteca";
    private String user = "postgres";
    private String password = "Jeff$_0301_";
    private static Connection conn;

    public PostgresConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }
    public static Connection getConnection() throws SQLException {
        PostgresConnection pc = new PostgresConnection();
        return pc.conn;
    }
}
