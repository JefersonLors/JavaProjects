import dao.PostgresConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Main obj = new Main();
        obj.teste();
        System.out.println("Hello world!");
    }
    public void teste() throws SQLException {
        var conn = new PostgresConnection().getConnection();
        PreparedStatement ps = conn.prepareStatement( "SELECT * FROM autor");
        ResultSet rs = ps.executeQuery();

        rs.next();
        System.out.println(rs);
    }
}