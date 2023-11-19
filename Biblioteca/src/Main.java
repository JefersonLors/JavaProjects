import dao.DaoAutor;
import dao.DaoEditora;
import dao.PostgresConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.filter.AutorFiltro;
import dao.filter.EditoraFiltro;
import dao.idao.IDaoAutor;
import dao.idao.IDaoEditora;
import model.Autor;
import model.Editora;
import org.postgresql.jdbc.SslMode;

public class Main {
    private IDaoAutor iDaoAutor;
    private IDaoEditora iDaoEditora;
    public static void main(String[] args) throws SQLException {
        Main obj = new Main();
        obj.teste();
        System.out.println("Hello world!");
    }
    public void teste(){
        try{
            this.iDaoAutor =  new DaoAutor();
            this.iDaoEditora = new DaoEditora();
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

//            this.iDaoAutor.getAutor(new AutorFiltro("","José","M","1977-10-10"))
//                    .stream()
//                    .forEach(item-> System.out.println(item));

            this.iDaoEditora.getEditora( new EditoraFiltro( "", "", "null"))
                    .stream()
                    .forEach(item-> System.out.println(item));

            this.iDaoEditora.postEditora(new Editora( "Barbaridades", "Salvador-BA"));
            this.iDaoEditora.deleteEditora(new Editora( 4, "Barbaridades", "Salvador-BA"));
//            this.iDaoAutor.postAutor(new Autor("Jeferson", "M", df.parse("2001/01/01")));
//            this.iDaoAutor.putAutor(new Autor( 7, "john Mayer", "M", df.parse("2001/01/01")));
//            this.iDaoAutor.deleteAutor(new Autor( 7, "john Mayer", "M", df.parse("2001/01/01")));
        }catch( Exception ex ){
            ex.printStackTrace();
        }

    }
}