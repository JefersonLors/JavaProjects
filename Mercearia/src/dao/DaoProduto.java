package dao;

import dao.Idao.IDaoProduto;
import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;
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
    public List<Produto> getTodosOsProdutos()
            throws SQLException, NomeInvalidoException, PrecoInvalidoException {
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
}
