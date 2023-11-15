package dao;

import dao.Idao.IDaoProduto;
import dao.fromDB.ProdutoFDB;

import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;
import exceptions.ProdutoInexistenteException;

import model.Produto;
import model.filtros.ProdutoFiltro;

import java.sql.*;
import java.util.ArrayList;


public class DaoProduto implements IDaoProduto {
    private Connection conn;
    private PreparedStatement pStatement;
    public DaoProduto() throws SQLException {
        this.conn = new PostgreSQLConnection().getConnection();
    }

    @Override
    public ArrayList<ProdutoFDB> getProdutos()
            throws SQLException, NomeInvalidoException, PrecoInvalidoException {
        String query = "SELECT * " +
                       "FROM produtos;";

        this.pStatement = conn.prepareStatement(query);
        ResultSet resultSet = pStatement.executeQuery();

        ArrayList<ProdutoFDB> listaProdutos = new ArrayList<ProdutoFDB>();

        while( resultSet.next() ){
            listaProdutos.add(new ProdutoFDB(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)));
        }
        return listaProdutos;
    }

    @Override
    public ArrayList<ProdutoFDB> getProdutos(ProdutoFiltro produtoFiltro)
            throws SQLException, NomeInvalidoException, PrecoInvalidoException {
        if( produtoFiltro == null ) {
            return this.getProdutos();
        }

        String query = "SELECT * " +
                       "FROM produtos ";

        query += this.montaClausulaWhere(produtoFiltro);

        query += ";";

        this.pStatement = conn.prepareStatement(query);

        ResultSet resultSet = pStatement.executeQuery();

        ArrayList<ProdutoFDB> listaProdutos = new ArrayList<ProdutoFDB>();

        while( resultSet.next() ){
            listaProdutos.add(new ProdutoFDB(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)));
        }
        return listaProdutos;
    }

    @Override
    public ProdutoFDB getProdutoPorId(long id)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException {
        String query = "SELECT * " +
                       "FROM produtos " +
                       "WHERE id = ?;";

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setLong(1, id);
        ResultSet resultSet = this.pStatement.executeQuery();

        if( !resultSet.next() )
            throw new ProdutoInexistenteException("O id "+ id + " não está associado a nenhum produto.");

        return new ProdutoFDB( resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("preco"));
    }

    @Override
    public ProdutoFDB putProduto(Produto produtoAtualizado)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException {
        String query = "UPDATE Produtos SET " +
                            "nome = ?, " +
                            "preco = ? " +
                        "WHERE id = ?;";

        ProdutoFDB produtoFBD = this.getProdutoPorId(produtoAtualizado.getId());

        Produto produtoResultante = new Produto();

        produtoResultante.setId(produtoFBD.id);

        String nomeProdutoAtulizado = produtoAtualizado.getNome();

        produtoResultante.setNome( nomeProdutoAtulizado.isBlank() ? produtoFBD.nome : nomeProdutoAtulizado);
        produtoResultante.setPreco( produtoAtualizado.getPreco());

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setString(1, produtoResultante.getNome());
        this.pStatement.setDouble(2, produtoResultante.getPreco());
        this.pStatement.setLong(3, produtoResultante.getId());
        this.pStatement.executeUpdate();

        return new ProdutoFDB( produtoResultante.getId(),
                               produtoResultante.getNome(),
                               produtoResultante.getPreco() );
    }

    @Override
    public ProdutoFDB postProduto(Produto produtoNovo) throws SQLException {
        String query = "INSERT INTO Produtos (nome, preco) values (?, ?);";

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setString(1, produtoNovo.getNome());
        this.pStatement.setDouble(2, produtoNovo.getPreco());
        this.pStatement.executeUpdate();

        return new ProdutoFDB( -1, produtoNovo.getNome(), produtoNovo.getPreco() );
    }

    private String montaClausulaWhere( ProdutoFiltro filtro){
        String query = "";
        long qtdParam = 0;

        if( filtro.nome != null && !filtro.nome.isBlank() && !filtro.nome.isEmpty() ){
            if ( qtdParam == 0 ){
                query += " WHERE ";
            } else {
                query += " AND ";
            }
            query += "unaccent(lower(nome)) like " + "'" + filtro.nome.toLowerCase() + "%' ";
            qtdParam++;
        }
        if( filtro.preco != null && !filtro.preco.toString().isBlank() && !filtro.preco.toString().isEmpty() ){
            if ( qtdParam == 0 ){
                query += " WHERE ";
            } else {
                query += " AND ";
            }
            query += "preco = " + filtro.preco + " ";
            qtdParam++;
        }

        if( filtro.id != null && !filtro.id.isBlank() && !filtro.id.isEmpty() ){
            if ( qtdParam == 0 ){
                query += " WHERE ";
            } else {
                query += " AND ";
            }
            query += "id = " + filtro.id + " ";
            qtdParam++;
        }

        return query;
    }
}
