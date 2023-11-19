package dao;

import dao.filter.AutorFiltro;
import dao.filter.LivroFiltro;
import dao.fromDB.AutorFromDB;
import dao.fromDB.LivroFromDB;
import dao.idao.IDaoLivro;
import exceptions.AutorInvalidoException;
import exceptions.LivroInvalidoException;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLivro implements IDaoLivro {
    private Connection conn;

    public DaoLivro() throws SQLException {
        this.conn =  PostgresConnection.getConnection();
    }
    @Override
    public void postLivro(Livro livroNovo) throws SQLException {
        String query = "INSERT INTO livro (isbn, titulo, num_edicao, preco, cod_editora) "+
                "values (?, ?, ?, ?, ?) ;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt( 1, livroNovo.getIsbn());
        ps.setString(2, livroNovo.getTitulo());
        ps.setInt( 3, livroNovo.getNumEdicao());
        ps.setDouble( 4, livroNovo.getPreco());
        ps.setInt(5, livroNovo.getCodEditora());
        ps.executeUpdate();
    }

    @Override
    public void putLivro(Livro livroAtualizado) throws SQLException, LivroInvalidoException {
        LivroFiltro filtro = new LivroFiltro();
        filtro.codLivro = livroAtualizado.getCodLivro() + "";

        ArrayList<LivroFromDB> livroFromDB = this.getLivro(filtro);

        if( livroFromDB.size() == 0 )
            throw new LivroInvalidoException("O livro selecionado para atualizar não existe no banco.");

        String query = "UPDATE livro " +
                "SET isbn = ? , " +
                "titulo = ? , " +
                "num_edicao = ?, " +
                "preco = ?, " +
                "cod_editora = ? " +
                "WHERE cod_livro = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt( 1, livroAtualizado.getIsbn());
        ps.setString(2, livroAtualizado.getTitulo());
        ps.setInt( 3, livroAtualizado.getNumEdicao());
        ps.setDouble( 4, livroAtualizado.getPreco());
        ps.setInt(5, livroAtualizado.getCodEditora());
        ps.setInt(6, livroAtualizado.getCodLivro());
        ps.executeUpdate();
    }

    @Override
    public void deleteLivro(Livro livroDeletado) throws SQLException, LivroInvalidoException {
        LivroFiltro filtro = new LivroFiltro( );
        filtro.codLivro = livroDeletado.getCodLivro() + "";
        ArrayList<LivroFromDB> livroFromDB = this.getLivro(filtro);

        if( livroFromDB.size() == 0 )
            throw new LivroInvalidoException("O autor selecionado para excluir não existe no banco.");

        String query = "DELETE FROM livro " +
                "WHERE cod_livro = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, livroDeletado.getCodLivro());
        ps.executeUpdate();
    }

    @Override
    public ArrayList<LivroFromDB> getLivro(LivroFiltro livroFiltro) throws SQLException {
        if( livroFiltro == null || ( livroFiltro.codLivro.isBlank() &&
                livroFiltro.isbn.isBlank() &&
                livroFiltro.titulo.isBlank() &&
                livroFiltro.preco.isBlank() &&
                livroFiltro.codEditora.isBlank() &&
                livroFiltro.numEdicao.isBlank() )){
            return this.getLivro();
        }
        boolean parametro = false;

        String query = "SELECT * " +
                "FROM livro ";

        if( livroFiltro.codLivro != null && !livroFiltro.codLivro.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "cod_livro = " + livroFiltro.codLivro;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroFiltro.isbn != null && !livroFiltro.isbn.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "isbn = " + livroFiltro.isbn;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroFiltro.titulo != null && !livroFiltro.titulo.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(titulo) like '" + livroFiltro.titulo.toUpperCase() + "%'";
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroFiltro.numEdicao != null && !livroFiltro.numEdicao.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "num_edicao = " + livroFiltro.numEdicao;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroFiltro.preco != null && !livroFiltro.preco.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "preco = " + livroFiltro.preco;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( livroFiltro.codEditora != null && !livroFiltro.codEditora.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "cod_editora = " + livroFiltro.codEditora;
            parametro = ( parametro ? parametro : !parametro);
        }

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<LivroFromDB> resultado = new ArrayList<LivroFromDB>();

        while(rs.next()){
            resultado.add( new LivroFromDB(
                    rs.getInt("cod_livro"),
                    rs.getInt("isbn"),
                    rs.getString("titulo"),
                    rs.getInt("num_edicac"),
                    rs.getDouble("preco"),
                    rs.getInt("cod_editora")));
        }
        return resultado;
    }

    @Override
    public ArrayList<LivroFromDB> getLivro() throws SQLException {
        String query = "SELECT * " +
                "FROM livro;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<LivroFromDB> resultado = new ArrayList<LivroFromDB>();

        while(rs.next()){
            resultado.add( new LivroFromDB(
                    rs.getInt("cod_livro"),
                    rs.getInt("isbn"),
                    rs.getString("titulo"),
                    rs.getInt("num_edicac"),
                    rs.getDouble("preco"),
                    rs.getInt("cod_editora")));
        }
        return resultado;
    }
}
