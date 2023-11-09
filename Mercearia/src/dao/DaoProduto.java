package dao;

import dao.Idao.IDaoProduto;
import exceptions.ProdutoInexistenteException;
import model.Produto;

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
    public List<Produto> getTodosOsProdutos() throws SQLException {
        String query = "SELECT * " +
                       "FROM produtos;";

        this.pStatement = conn.prepareStatement(query);
        ResultSet resultSet = pStatement.executeQuery();

        List<Produto> listaProdutos = new ArrayList<Produto>();

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
            throws SQLException, ProdutoInexistenteException {
        String query = "SELECT *" +
                       "FROM produtos " +
                       "WHERE id = ?;";

        this.pStatement = conn.prepareStatement(query);
        ResultSet resultSet = this.pStatement.executeQuery();

        if( resultSet == null )
            throw new ProdutoInexistenteException("O id "+ id + " não está associado a nenhum produto.");

        return new Produto( resultSet.getLong(1), resultSet.getString(2), resultSet.getDouble(3));
    }

    @Override
    public Produto putProdutoPorId(Produto produtoAtualizado, long id)
            throws SQLException, ProdutoInexistenteException {
        String query = "UPDATE Produtos SET" +
                            "nome = ?" +
                            "preco = ?;";

        Produto produtoBD = this.getProdutoPorId(id);

        if ( produtoBD != null ){
            this.pStatement = conn.prepareStatement(query);
            this.pStatement.setString(1, produtoAtualizado.getNome());
            this.pStatement.setDouble(2, produtoAtualizado.getPreco());
            this.pStatement.executeQuery();
            return produtoAtualizado;
        }

        return null;
    }

    @Override
    public Produto postProduto(Produto produtoNovo) throws SQLException {
        String query = "INSERT INTO Produtos (nome, preco) values (?, ?);";

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setString(1, produtoNovo.getNome());
        this.pStatement.setDouble(2, produtoNovo.getPreco());
        this.pStatement.executeQuery();

        return produtoNovo;
    }
}
