package dao;

import dao.Idao.IDaoProduto;
import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;
import exceptions.ProdutoInexistenteException;
import model.Produto;
import model.filtros.ProdutoFiltro;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto implements IDaoProduto {
    private Connection conn;
    private PreparedStatement pStatement;
    public DaoProduto() throws SQLException {
        this.conn = new PostgreSQLConnection().getConnection();
    }

    @Override
    public ArrayList<Produto> getProdutos()
            throws SQLException, NomeInvalidoException, PrecoInvalidoException {
        String query = "SELECT * " +
                       "FROM produtos;";

        this.pStatement = conn.prepareStatement(query);
        ResultSet resultSet = pStatement.executeQuery();

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        while( resultSet.next() ){
            listaProdutos.add(new Produto(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)));
        }
        return listaProdutos;
    }

    @Override
    public ArrayList<Produto> getProdutos(ProdutoFiltro produtoFiltro)
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

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        while( resultSet.next() ){
            listaProdutos.add(new Produto(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)));
        }
        return listaProdutos;
    }

    @Override
    public Produto getProdutoPorId(long id)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException {
        String query = "SELECT * " +
                       "FROM produtos " +
                       "WHERE id = ?;";

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setLong(1, id);
        ResultSet resultSet = this.pStatement.executeQuery();

        if( !resultSet.next() )
            throw new ProdutoInexistenteException("O id "+ id + " não está associado a nenhum produto.");

        return new Produto( resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("preco"));
    }

    @Override
    public Produto putProdutoPorId(Produto produtoAtualizado)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException {
        String query = "UPDATE Produtos SET " +
                            "nome = ?, " +
                            "preco = ? " +
                        "WHERE id = ?;";

        Produto produtoBD = this.getProdutoPorId(produtoAtualizado.getId());

        Produto produtoResultante = new Produto();

        produtoResultante.setId(produtoBD.getId());

        String nomeProdutoAtulizado = produtoAtualizado.getNome();

        produtoResultante.setNome( nomeProdutoAtulizado.isBlank() ? produtoBD.getNome() : nomeProdutoAtulizado);
        produtoResultante.setPreco( produtoAtualizado.getPreco());

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setString(1, produtoResultante.getNome());
        this.pStatement.setDouble(2, produtoResultante.getPreco());
        this.pStatement.setLong(3, produtoResultante.getId());
        this.pStatement.executeUpdate();

        return produtoResultante;
    }

    @Override
    public Produto postProduto(Produto produtoNovo) throws SQLException {
        String query = "INSERT INTO Produtos (nome, preco) values (?, ?);";

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setString(1, produtoNovo.getNome());
        this.pStatement.setDouble(2, produtoNovo.getPreco());
        this.pStatement.executeUpdate();

        return produtoNovo;
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
            query += "nome like " + "'%" + filtro.nome + "%' ";
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
