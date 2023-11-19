package dao;

import dao.filter.AutorFiltro;
import dao.filter.EditoraFiltro;
import dao.fromDB.AutorFromDB;
import dao.fromDB.EditoraFromDB;
import dao.idao.IDaoEditora;
import exceptions.AutorInvalidoException;
import exceptions.EditoraInvalidaException;
import model.Editora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEditora implements IDaoEditora {
    private Connection conn;

    public DaoEditora() throws SQLException {
        this.conn = PostgresConnection.getConnection();
    }

    @Override
    public void postEditora(Editora editoraNova) throws SQLException {
        String query = "INSERT INTO editora ( descricao, endereco) "+
                "values (?, ?);";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString( 1, editoraNova.getDescricao());
        ps.setString(2, editoraNova.getEndereco());
        ps.executeUpdate();
    }

    @Override
    public void putEditora(Editora editoraAtualizada) throws SQLException, EditoraInvalidaException {
        EditoraFiltro filtro = new EditoraFiltro();
        filtro.codEditora = editoraAtualizada.getCodEditora() + "";
        ArrayList<EditoraFromDB> editoraFromDB = this.getEditora(filtro);

        if( editoraFromDB.size() == 0 )
            throw new EditoraInvalidaException("A editora selecionada para atualizar não existe no banco.");

        String query = "UPDATE editora " +
                "SET descricao = ? , " +
                "endereco = ?  " +
                "WHERE cod_editora = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, editoraAtualizada.getDescricao());
        ps.setString(2, editoraAtualizada.getEndereco());
        ps.setInt( 3, editoraAtualizada.getCodEditora());
        ps.executeUpdate();
    }

    @Override
    public void deleteEditora(Editora editoraDeletada) throws SQLException, EditoraInvalidaException {
        EditoraFiltro filtro = new EditoraFiltro( );
        filtro.codEditora = editoraDeletada.getCodEditora() + "";
        ArrayList<EditoraFromDB> autorFromDB = this.getEditora(filtro);

        if( autorFromDB.size() == 0 )
            throw new EditoraInvalidaException("A editora selecionada para excluir não existe no banco.");

        String query = "DELETE FROM editora " +
                "WHERE cod_editora = ?;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, editoraDeletada.getCodEditora());
        ps.executeUpdate();
    }

    @Override
    public ArrayList<EditoraFromDB> getEditora(EditoraFiltro editoraFiltro) throws SQLException {
        if( editoraFiltro == null || ( editoraFiltro.codEditora.isBlank() &&
                editoraFiltro.descricao.isBlank() &&
                editoraFiltro.endereco.isBlank() )){
            return this.getEditora();
        }
        boolean parametro = false;

        String query = "SELECT * " +
                "FROM editora ";

        if( editoraFiltro.codEditora != null && !editoraFiltro.codEditora.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "cod_editora = " + editoraFiltro.codEditora;
            parametro = ( parametro ? parametro : !parametro);
        }
        if( editoraFiltro.descricao != null &&!editoraFiltro.descricao.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(descricao) like '" + editoraFiltro.descricao.toUpperCase() + "%'";
            parametro = ( parametro ? parametro : !parametro);
        }
        if( editoraFiltro.endereco != null && !editoraFiltro.endereco.isBlank()){
            query += !parametro ? " WHERE " : " AND ";
            query += "UPPER(endereco) like '%" + editoraFiltro.endereco.toUpperCase() + "%'";
            parametro = ( parametro ? parametro : !parametro);
        }

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<EditoraFromDB> resultado = new ArrayList<EditoraFromDB>();

        while( rs.next() ){
            resultado.add(new EditoraFromDB(
                    rs.getInt("cod_editora"),
                    rs.getString("descricao"),
                    rs.getString("endereco")));
        }
        return resultado;
    }

    @Override
    public ArrayList<EditoraFromDB> getEditora() throws SQLException {
        String query = "SELECT *" +
                       "FROM editora;";

        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<EditoraFromDB> resultado = new ArrayList<>();

        while( rs.next() ){
            resultado.add( new EditoraFromDB(
                    rs.getInt("cod_editora"),
                    rs.getString("descricao"),
                    rs.getString("endereco")));
        }
        return resultado;
    }
}
