package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PostgreSQLConnection {
    private final String URL = "jdbc:postgresql://localhost/Mercearia";
    private final String user = "postgres";
    private final String password = "Jeff$_0301_";
    private Connection conn;

    public PostgreSQLConnection()
        throws SQLException
    {
        this.conn = DriverManager.getConnection(this.URL, this.user, this.password);
    }
    public Connection getConnection(){
        return this.conn;
    }

}
