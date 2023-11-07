import dao.PostgreSQLConnection;
public class Main {
    public static void main(String[] args) {
        try{
            var postgreSQLConnection = new PostgreSQLConnection();
            var conn = postgreSQLConnection.getConnection();
            var statement = conn.createStatement();
            var result = statement.executeQuery("Select*from produtos");
            System.out.println(result.getMetaData().getColumnName(1));

        }catch( Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Hello world!");
    }
}