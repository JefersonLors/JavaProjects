package dao;

import dao.filter.AutorFiltro;
import dao.filter.LivroAutorExtFiltro;
import dao.filter.LivroAutorFiltro;
import dao.filter.LivroFiltro;
import dao.fromDB.AutorFromDB;
import dao.fromDB.LivroAutorExtFromDB;
import dao.fromDB.LivroAutorFromDB;
import dao.fromDB.LivroFromDB;
import dao.idao.IDaoAutor;
import dao.idao.IDaoLivro;
import dao.idao.IDaoLivroAutor;
import exceptions.AutorInvalidoException;
import exceptions.LivroAutorInvalidoException;
import exceptions.LivroInvalidoException;
import model.LivroAutor;

import java.sql.*;
import java.util.ArrayList;

public class DaoLivroAutor implements IDaoLivroAutor {
    private IDaoAutor iDaoAutor;
    private IDaoLivro iDaoLivro;
    private Connection conn;

    public DaoLivroAutor() throws SQLException {
        this.iDaoAutor = new DaoAutor();
        this.iDaoLivro = new DaoLivro();
        this.conn = PostgresConnection.getConnection();
    }
    @Override
    public void postLivroAutor(LivroAutor livroAutorNovo)
            throws SQLException, AutorInvalidoException, LivroInvalidoException {
        ArrayList<AutorFromDB> autoresFromDB = iDaoAutor.getAutor(new AutorFiltro(  livroAutorNovo.getCodAutor() + "", "", "", ""));
        ArrayList<LivroFromDB> livrosFromDB = iDaoLivro.getLivro(new LivroFiltro( livroAutorNovo.getCodLivro() + "", "", "", "", "", ""));

        if( autoresFromDB.size() == 0 )
            throw new AutorInvalidoException("O autor não existe nas relações do banco de dados.");

        if( livrosFromDB.size() == 0 )
            throw new LivroInvalidoException("O livro não existe nas relações do banco de dados.");

        String query = "INSERT INTO autor (cod_livro, cod_autor) "+
                       "values (?, ?);";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt( 1, livroAutorNovo.getCodAutor());
        ps.setInt(2, livroAutorNovo.getCodLivro());
        ps.executeUpdate();
    }

    @Override
    public void putLivroAutor(LivroAutor livroAutorAtualizado) throws SQLException, AutorInvalidoException, LivroInvalidoException {
        ArrayList<AutorFromDB> autoresFromDB = iDaoAutor.getAutor(new AutorFiltro(  livroAutorAtualizado.getCodAutor() + "", "", "", ""));
        ArrayList<LivroFromDB> livrosFromDB = iDaoLivro.getLivro(new LivroFiltro( livroAutorAtualizado.getCodLivro() + "", "", "", "", "", ""));

        if( autoresFromDB.size() == 0 )
            throw new AutorInvalidoException("O autor não existe nas relações do banco de dados.");

        if( livrosFromDB.size() == 0 )
            throw new LivroInvalidoException("O livro não existe nas relações do banco de dados.");

        String query = "UPDATE autor SET "+
                        "cod_autor = ?, " +
                        "cod_livro = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt( 1, livroAutorAtualizado.getCodAutor());
        ps.setInt(2, livroAutorAtualizado.getCodLivro());
        ps.executeUpdate();
    }

    @Override
    public void deleteLivroAutor(LivroAutor livroAutorDeletado)
            throws SQLException, LivroAutorInvalidoException {
        ArrayList<LivroAutorFromDB> livroAutoresFromDB = this.getLivroAutor(new LivroAutorFiltro(livroAutorDeletado.getCodLivro() + " ",
                livroAutorDeletado.getCodAutor() + " "));

        if( livroAutoresFromDB.size() == 0 ){
            throw new LivroAutorInvalidoException("Esse livro não possui autores cadastrado.");
        }

        String query = "DELETE FROM livroautor " +
                       "WHERE cod_livro = ? AND" +
                       "cod_autor = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, livroAutorDeletado.getCodLivro());
        ps.setInt(2, livroAutorDeletado.getCodAutor());
        ps.executeUpdate();
    }

    @Override
    public ArrayList<LivroAutorFromDB> getLivroAutor(LivroAutorFiltro livroAutorFiltro) throws SQLException {
        if( livroAutorFiltro == null || ( livroAutorFiltro.codAutor.isBlank() &&
                livroAutorFiltro.codLivro.isBlank() )){
            return this.getLivroAutor();
        }
        boolean parametro = false;

        String query = "SELECT * " +
                        "FROM livroAutor ";

        if( livroAutorFiltro.codAutor != null && !livroAutorFiltro.codAutor.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "cod_autor = " + livroAutorFiltro.codAutor;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorFiltro.codLivro != null && !livroAutorFiltro.codLivro.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "cod_livro = " + livroAutorFiltro.codLivro.toUpperCase();
            parametro = ( parametro ? parametro : !parametro);
        }

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<LivroAutorFromDB> resultado = new ArrayList<LivroAutorFromDB>();

        while(rs.next()){
            resultado.add( new LivroAutorFromDB(
                    rs.getInt("cod_autor"),
                    rs.getInt("cod_autor")));
        }
        return resultado;
    }

    @Override
    public ArrayList<LivroAutorFromDB> getLivroAutor() throws SQLException {
        String query = "SELECT * " +
                "FROM livroautor;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<LivroAutorFromDB> resultado = new ArrayList<LivroAutorFromDB>();

        while(rs.next()){
            resultado.add( new LivroAutorFromDB(
                    rs.getInt("cod_autor"),
                    rs.getInt("cod_autor")));
        }
        return resultado;
    }

    @Override
    public ArrayList<LivroAutorExtFromDB> getLivroAutorExt() throws SQLException {
        String query = "SELECT l.cod_livro, l.isbn, titulo, l.num_edicao, l.preco, l.cod_editora, a.cod_autor, a.nome, a.sexo " +
                       "FROM livro_autor la " +
                       "LEFT JOIN livro l ON (la.cod_livro = l.cod_livro) " +
                       "LEFT JOIN autor a on (la.cod_autor = a.cod_autor) " +
                       "ORDER BY isbn;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<LivroAutorExtFromDB> resultado = new ArrayList<LivroAutorExtFromDB>();

        while(rs.next()){
            resultado.add( new LivroAutorExtFromDB(
                    rs.getInt("cod_autor"),
                    rs.getInt("isbn"),
                    rs.getString("titulo"),
                    rs.getInt("num_edicao"),
                    rs.getDouble("preco"),
                    rs.getInt("cod_editora"),
                    rs.getInt("cod_autor"),
                    rs.getString("nome"),
                    rs.getString("sexo")));
        }
        return resultado;
    }

    @Override
    public ArrayList<LivroAutorExtFromDB> getLivroAutorExt(LivroAutorExtFiltro livroAutorExtFiltro ) throws SQLException {
        if( livroAutorExtFiltro == null || ( livroAutorExtFiltro.codAutor.isBlank() &&
                livroAutorExtFiltro.isbn.isBlank() &&
                livroAutorExtFiltro.titulo.isBlank() &&
                livroAutorExtFiltro.numEdicao.isBlank() &&
                livroAutorExtFiltro.preco.isBlank() &&
                livroAutorExtFiltro.codEditora.isBlank() &&
                livroAutorExtFiltro.codAutor.isBlank() &&
                livroAutorExtFiltro.nomeAutor.isBlank() &&
                livroAutorExtFiltro.sexoAutor.isBlank() )){
            return this.getLivroAutorExt();
        }

        String query = "SELECT l.cod_livro, l.isbn, titulo, l.num_edicao, l.preco, l.cod_editora, a.cod_autor, a.nome, a.sexo " +
                "FROM livro_autor la " +
                "LEFT JOIN livro l ON (la.cod_livro = l.cod_livro) " +
                "LEFT JOIN autor a on (la.cod_autor = a.cod_autor) ";

        boolean parametro = false;

        if( livroAutorExtFiltro.codAutor != null && !livroAutorExtFiltro.codAutor.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "a.cod_autor = " + livroAutorExtFiltro.codAutor;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.isbn != null && !livroAutorExtFiltro.isbn.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "l.isbn = " + livroAutorExtFiltro.isbn;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.titulo != null && !livroAutorExtFiltro.titulo.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(l.titulo) like '" + livroAutorExtFiltro.titulo.toUpperCase() + "%'";
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.numEdicao != null && !livroAutorExtFiltro.numEdicao.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "l.num_edicao = " + livroAutorExtFiltro.numEdicao;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.preco != null && !livroAutorExtFiltro.preco.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "l.preco = " + livroAutorExtFiltro.preco;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.codEditora != null && !livroAutorExtFiltro.codEditora.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "l.cod_editora = " + livroAutorExtFiltro.codEditora;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.codAutor != null && !livroAutorExtFiltro.codAutor.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "la.cod_autor = " + livroAutorExtFiltro.codAutor;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.nomeAutor != null && !livroAutorExtFiltro.nomeAutor.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(a.nome) like '" + livroAutorExtFiltro.nomeAutor + "%'";
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroAutorExtFiltro.sexoAutor != null && !livroAutorExtFiltro.sexoAutor.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(a.sexo) like '" + livroAutorExtFiltro.sexoAutor + "'";
            parametro = ( parametro ? parametro : !parametro);
        }

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<LivroAutorExtFromDB> resultado = new ArrayList<LivroAutorExtFromDB>();

        while(rs.next()){
            resultado.add( new LivroAutorExtFromDB(
                    rs.getInt("cod_autor"),
                    rs.getInt("isbn"),
                    rs.getString("titulo"),
                    rs.getInt("num_edicao"),
                    rs.getDouble("preco"),
                    rs.getInt("cod_editora"),
                    rs.getInt("cod_autor"),
                    rs.getString("nome"),
                    rs.getString("sexo")));
        }
        return resultado;
    }
}
