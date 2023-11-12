package dao;

import dao.Idao.IDaoVenda;
import exceptions.QuantidadeInvalidaException;
import exceptions.VendaInexistenteException;
import model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoVenda implements IDaoVenda {
    private Connection conn;
    private PreparedStatement pStatement;

    public DaoVenda() throws SQLException {
        this.conn = new PostgreSQLConnection().getConnection();
    }
    @Override
    public ArrayList<Venda> getVendas() throws SQLException, QuantidadeInvalidaException {
        String query = "SELECT * " +
                       "FROM VENDAS;";

        ArrayList<Venda> listaVendas = new ArrayList<Venda>();

        this.pStatement = this.conn.prepareStatement(query);
        ResultSet resultSet = this.pStatement.executeQuery();

        while( resultSet.next() ){
            listaVendas.add(new Venda(
                resultSet.getLong(1),
                    resultSet.getLong(2),
                    resultSet.getLong(3)
            ));
        }

        return listaVendas;
    }

    @Override
    public Venda getVendaPorId(long id)
            throws SQLException, VendaInexistenteException, QuantidadeInvalidaException {
        String query = "SELECT * " +
                       "FROM VENDAS " +
                       "WHERE id = ?;";

        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setLong(1, id);
        ResultSet resultSet = this.pStatement.executeQuery();

        if( !resultSet.next() )
            throw new VendaInexistenteException("O id " + id + " não está associado a nenhuma venda.");

        return new Venda(
                resultSet.getLong(1),
                resultSet.getLong(2),
                resultSet.getLong(3));
    }

    @Override
    public Venda potsVenda(Venda novaVenda)
            throws SQLException {
        String query = "INSERT INTO VENDAS (idProduto, quantidade) " +
                       "values (?, ?);";
        this.pStatement = conn.prepareStatement(query);
        this.pStatement.setLong(1,  novaVenda.getIdProduto());
        this.pStatement.setLong(2,  novaVenda.getQuantidade());
        this.pStatement.executeUpdate();
        return novaVenda;
    }
}
