package dao;

import dao.Idao.IDaoProduto;
import model.Produto;

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
                       "FROM PRODUTOS";

        this.pStatement = conn.prepareStatement(query);
        ResultSet result = pStatement.executeQuery();

        List<Produto> listaProdutos = new ArrayList<Produto>();

        //preencher a lista

        return listaProdutos;
    }

    @Override
    public Produto getProdutoPorId(long id) throws SQLException {
        return null;
    }

    @Override
    public Produto putProdutoPorId(Produto produtoAtualizado, long id) throws SQLException {
        return null;
    }

    @Override
    public Produto postProduto(Produto produtoNovo) throws SQLException {
        return null;
    }
}
