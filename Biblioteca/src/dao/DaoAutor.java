package dao;

import dao.filter.AutorFiltro;
import dao.fromDB.AutorFromDB;
import dao.idao.IDaoAutor;
import exceptions.AutorInvalidoException;
import model.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoAutor implements IDaoAutor {
    private Connection conn;

    public DaoAutor() throws SQLException {
        this.conn = new PostgresConnection().getConnection();
    }
    @Override
    public void postAutor(Autor autorNovo) throws SQLException {
        String query = "INSERT INTO autor (nome, sexo, data_nascimento) "+
                        "values (?, ?, ?);";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString( 1, autorNovo.getNome());
        ps.setString(2, autorNovo.getSexo());
        ps.setDate(3, new java.sql.Date(autorNovo.getDataNascimento().getTime()));
        ps.executeUpdate();
    }

    @Override
    public void putAutor(Autor autorAtualizado) throws SQLException, AutorInvalidoException {
        AutorFiltro filtro = new AutorFiltro( );
        filtro.codAutor = autorAtualizado.getCodAutor() + "";
        ArrayList<AutorFromDB> autorFromDB = this.getAutor(filtro);

        if( autorFromDB.size() == 0 )
            throw new AutorInvalidoException("O autor selecionado para atualizar não existe no banco.");

        String query = "UPDATE autor " +
                       "SET nome = ? , " +
                       "sexo = ? , " +
                       "data_nascimento = ? " +
                       "WHERE cod_autor = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, autorAtualizado.getNome());
        ps.setString(2, autorAtualizado.getSexo());
        ps.setDate(3, new java.sql.Date(autorAtualizado.getDataNascimento().getTime()));
        ps.setInt( 4, autorAtualizado.getCodAutor());
        ps.executeUpdate();
    }

    @Override
    public void deleteAutor(Autor autorDeletado) throws SQLException, AutorInvalidoException {
        AutorFiltro filtro = new AutorFiltro( );
        filtro.codAutor = autorDeletado.getCodAutor() + "";
        ArrayList<AutorFromDB> autorFromDB = this.getAutor(filtro);

        if( autorFromDB.size() == 0 )
            throw new AutorInvalidoException("O autor selecionado para excluir não existe no banco.");

        String query = "DELETE FROM autor " +
                        "WHERE cod_autor = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, autorDeletado.getCodAutor());
        ps.executeUpdate();
    }

    @Override
    public ArrayList<AutorFromDB> getAutor(AutorFiltro autorFiltro) throws SQLException {
        if( autorFiltro == null || ( autorFiltro.codAutor.isBlank() &&
            autorFiltro.dataNascimento.isBlank() &&
            autorFiltro.nome.isBlank() &&
            autorFiltro.sexo.isBlank() )){
            return this.getAutor();
        }
        boolean parametro = false;

        String query = "SELECT * " +
                        "FROM autor ";

        if( autorFiltro.codAutor != null && !autorFiltro.codAutor.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "cod_autor = " + autorFiltro.codAutor;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( autorFiltro.nome != null && !autorFiltro.nome.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(nome) like '" + autorFiltro.nome.toUpperCase() + "%'";
            parametro = ( parametro ? parametro : !parametro);
        }
        if( autorFiltro.sexo != null && !autorFiltro.sexo.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(sexo) like '" + autorFiltro.sexo.toUpperCase() + "%'";
            parametro = ( parametro ? parametro : !parametro);
        }
        if( autorFiltro.dataNascimento != null && !autorFiltro.dataNascimento.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "data_nascimento = '" + autorFiltro.dataNascimento + "'";
            parametro = ( parametro ? parametro : !parametro);
        }

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<AutorFromDB> resultado = new ArrayList<AutorFromDB>();

        while( rs.next() ){
            resultado.add(new AutorFromDB(
                    rs.getInt("cod_autor"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getDate("data_nascimento")));
        }
        return resultado;
    }

    @Override
    public ArrayList<AutorFromDB> getAutor()
            throws SQLException {
        String query = "SELECT * " +
                        "FROM autor;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<AutorFromDB> resultado = new ArrayList<AutorFromDB>();

        while(rs.next()){
            resultado.add( new AutorFromDB(
                    rs.getInt("cod_autor"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getDate("data_nascimento")));
        }
        return resultado;
    }
}
