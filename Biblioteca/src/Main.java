import dao.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.filter.*;
import dao.fromDB.*;
import dao.idao.IDaoAutor;
import dao.idao.IDaoEditora;
import dao.idao.IDaoLivro;
import dao.idao.IDaoLivroAutor;
import model.Autor;
import model.Editora;
import model.Livro;
import model.LivroAutor;
import org.postgresql.jdbc.SslMode;

import javax.lang.model.type.ArrayType;

public class Main {
    private IDaoAutor iDaoAutor;
    private IDaoEditora iDaoEditora;
    private IDaoLivroAutor iDaoLivroAutor;
    private IDaoLivro iDaoLivro;
    public static void main(String[] args) throws SQLException {
        Main obj = new Main();
        obj.teste();
    }
    public void teste(){
        try{
            this.iDaoAutor =  new DaoAutor();
            this.iDaoEditora = new DaoEditora();
            this.iDaoLivro = new DaoLivro();
            this.iDaoLivroAutor =  new DaoLivroAutor();

            ArrayList<AutorFromDB> autoresFromDb = iDaoAutor.getAutor();
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

            //Recuperando autores sem filtro;
//            autoresFromDb.stream().forEach( autor -> System.out.println(autor));
//            System.out.println("Total: " + autoresFromDb.size() + " autores");
            //Recuperando autores com filtro;
//            autoresFromDb = iDaoAutor.getAutor(new AutorFiltro( "", "", "", "1970-01-01"));
//            autoresFromDb.stream().forEach( autor -> System.out.println(autor));
//            System.out.println("Total: " + autoresFromDb.size() + " autores");

            //Criando novo autor
//            iDaoAutor.postAutor( new Autor( "Antônio Carlos", "M", df.parse("199/05/15")));
//            autoresFromDb.stream().forEach( autor -> System.out.println(autor));
//            System.out.println("Total: " + autoresFromDb.size() + " autores");

            //Atualizando autor
//            iDaoAutor.putAutor(new Autor( 17,"putowisky", "M", df.parse("99/05/15")));
//            autoresFromDb = iDaoAutor.getAutor();
//            autoresFromDb.stream().forEach( autor -> System.out.println(autor));
//            System.out.println("Total: " + autoresFromDb.size() + " autores");
//
//            iDaoAutor.putAutor(new Autor( 18,"poxaBinho", "F", df.parse("99/02/15")));
//            autoresFromDb = iDaoAutor.getAutor();
//            autoresFromDb.stream().forEach( autor -> System.out.println(autor));
//            System.out.println("Total: " + autoresFromDb.size() + " autores");

            //Exclui autor
//            iDaoAutor.deleteAutor(new Autor( 19,"putowisky", "M", df.parse("99/05/15")) );
//            iDaoAutor.deleteAutor(new Autor( 18,"poxaBinho", "F", df.parse("99/02/15")));
//
//            autoresFromDb = iDaoAutor.getAutor();
//            autoresFromDb.stream().forEach( autor -> System.out.println(autor));
//            System.out.println("Total: " + autoresFromDb.size() + " autores");

            //teste livros
            //Recuperando livros sem filtro
//            ArrayList<LivroFromDB> livrosFromDB = iDaoLivro.getLivro();
//            livrosFromDB.stream().forEach( livro -> System.out.println(livro));

            //Recuperando livros com filtro
//            ArrayList<LivroFromDB> livrosFromDB = iDaoLivro.getLivro(new LivroFiltro("", "", "", "", "", "2"));
//            livrosFromDB.stream().forEach( livro -> System.out.println(livro));

            //Cria livro
//            iDaoLivro.postLivro(new Livro("", "65324", 69, 0.99, 6));
//            ArrayList<LivroFromDB> livrosFromDB = iDaoLivro.getLivro();
//            livrosFromDB.stream().forEach( livro -> System.out.println(livro));

            //Atualiza livro
//            iDaoLivro.putLivro(new Livro( 2, "69069", "A Branca de Porra 1", 69, 0.69, 6));
//            iDaoLivro.putLivro(new Livro( 8, "85264", "O Massacre da Geba Elétrica", 66, 666.00, 7));
//            iDaoLivro.putLivro(new Livro( 9, "95137", "Vingarde-os ou Leve Rola", 66, 66.69, 8));
//            ArrayList<LivroFromDB> livrosFromDB = iDaoLivro.getLivro();
//            livrosFromDB.stream().forEach( livro -> System.out.println(livro));

            //Exclui livro
//            iDaoLivro.deleteLivro(new Livro( 6, "69069", "A Branca de Porra 1", 69, 0.69, 6));
//            ArrayList<LivroFromDB> livrosFromDB = iDaoLivro.getLivro();
//            livrosFromDB.stream().forEach( livro -> System.out.println(livro));

            //teste editora
            //recupera editoras sem filtro
//            ArrayList<EditoraFromDB> editorasFromDB = iDaoEditora.getEditora();
//            editorasFromDB.stream().forEach(editora -> System.out.println(editora));

            //recupera editoras com filtro
//            ArrayList<EditoraFromDB> editorasFromDB = iDaoEditora.getEditora( new EditoraFiltro( "", "", "Salvador"));
//            editorasFromDB.stream().forEach(editora -> System.out.println(editora));

            //Cria editora
//            iDaoEditora.postEditora(new Editora( "Sarraí-vá", "Quero ver-AL"));
//            ArrayList<EditoraFromDB> editorasFromDB = iDaoEditora.getEditora( new EditoraFiltro( "", "", ""));
//            editorasFromDB.stream().forEach(editora -> System.out.println(editora));

            //Atualiza editora
//            iDaoEditora.putEditora(new Editora( 10, "Cultura", "Shopping da Bahia"));
//            ArrayList<EditoraFromDB> editorasFromDB = iDaoEditora.getEditora( new EditoraFiltro( "", "", ""));
//            editorasFromDB.stream().forEach(editora -> System.out.println(editora));

            //Teste livroautor
            //recupera livroAutor sem filtro
//            ArrayList<LivroAutorFromDB> livrosAutoresFromDB = iDaoLivroAutor.getLivroAutor();
//            livrosAutoresFromDB.stream().forEach(livroAutorFromDB -> System.out.println(livroAutorFromDB) );

            //recupera livroAutor com filtro
//            ArrayList<LivroAutorFromDB> livrosAutoresFromDB = iDaoLivroAutor.getLivroAutor(new LivroAutorFiltro("3", ""));
//            livrosAutoresFromDB.stream().forEach(livroAutorFromDB -> System.out.println(livroAutorFromDB) );

            //criar livroautor
//            iDaoLivroAutor.postLivroAutor(new LivroAutor(3, 4));
//            ArrayList<LivroAutorFromDB> livrosAutoresFromDB = iDaoLivroAutor.getLivroAutor(new LivroAutorFiltro("", ""));
//            livrosAutoresFromDB.stream().forEach(livroAutorFromDB -> System.out.println(livroAutorFromDB) );

//            //Altera livroautor
//            iDaoLivroAutor.deleteLivroAutor(new LivroAutor( 7, 4));
//            ArrayList<LivroAutorFromDB> livrosAutoresFromDB = iDaoLivroAutor.getLivroAutor(new LivroAutorFiltro("", ""));
//            livrosAutoresFromDB.stream().forEach(livroAutorFromDB -> System.out.println(livroAutorFromDB) );

            //recupera livroAutor sem filtro
//            ArrayList<LivroAutorExtFromDB> livrosAutoresFromDB = iDaoLivroAutor.getLivroAutorExt();
//            livrosAutoresFromDB.stream().forEach(livroAutorFromDB -> System.out.println(livroAutorFromDB) );

            //recupera livroAutor com filtro
            ArrayList<LivroAutorExtFromDB> livrosAutoresFromDB = iDaoLivroAutor.getLivroAutorExt(
                    new LivroAutorExtFiltro("", "69069", "", "", "", "", "", "", "", ""));
            livrosAutoresFromDB.stream().forEach(livroAutorFromDB -> System.out.println(livroAutorFromDB) );


        }catch( Exception ex ){
            ex.printStackTrace();
        }

    }
}