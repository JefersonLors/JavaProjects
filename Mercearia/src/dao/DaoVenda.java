package dao;

import dao.Idao.IDaoVenda;
import dao.entities.VendaJoinProduto;
import exceptions.QuantidadeInvalidaException;
import exceptions.VendaInexistenteException;
import model.Venda;
import model.filtros.VendaFiltro;

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
    public ArrayList<VendaJoinProduto> getVendas() throws SQLException, QuantidadeInvalidaException {
        String query = "SELECT V.id as codigoVenda, p.nome, p.preco, v.quantidade\n" +
                "FROM VENDAS V LEFT JOIN PRODUTOS P\n" +
                "\tON ( V.idProduto = P.id)\n ";

        ArrayList<VendaJoinProduto> listaVendas = new ArrayList<VendaJoinProduto>();

        this.pStatement = this.conn.prepareStatement(query);
        ResultSet resultSet = this.pStatement.executeQuery();

        while( resultSet.next() ){
            listaVendas.add(new VendaJoinProduto(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getDouble(3),
                resultSet.getLong(3)
            ));
        }

        return listaVendas;
    }
    public ArrayList<VendaJoinProduto> getVendas(VendaFiltro filtro) throws SQLException, QuantidadeInvalidaException {
        if( filtro == null ){
            return getVendas();
        }
        String query = "SELECT V.id as codigoVenda, p.nome, p.preco, V.quantidade " +
                "FROM VENDAS V LEFT JOIN PRODUTOS P " +
                "ON ( V.idProduto = P.id) ";

        boolean parametro = false;

        if( filtro.idProduto != null && !filtro.idProduto.isBlank() && !filtro.idProduto.isEmpty() ){
            if( parametro ){
                query += " AND ";
            }else{
                query += " WHERE ";
            }

            query += " v.idProduto = " + filtro.idProduto;
            parametro = !parametro ? !parametro : parametro;
        }
        if( filtro.quantidade != null && !filtro.quantidade.isBlank() && !filtro.quantidade.isEmpty() ){
            if( parametro ){
                query += " AND ";
            }else{
                query += " WHERE ";
            }

            query += " v.quantidade = " + filtro.quantidade;
            parametro = !parametro ? !parametro : parametro;
        }
        if( filtro.preco != null && !filtro.preco.isBlank() && !filtro.preco.isEmpty() ){
            if( parametro ){
                query += " AND ";
            }else{
                query += " WHERE ";
            }

            query += " p.preco = " + filtro.preco;
            parametro = !parametro ? !parametro : parametro;
        }

        query += " ORDER BY codigovenda DESC;";

        this.pStatement = this.conn.prepareStatement(query);
        ResultSet resultSet = this.pStatement.executeQuery();

        ArrayList<VendaJoinProduto> listaVendas = new ArrayList<VendaJoinProduto>();

        while( resultSet.next() ){
            listaVendas.add(new VendaJoinProduto(
                    resultSet.getLong("codigoVenda"),
                    resultSet.getString("nome"),
                    resultSet.getDouble("preco"),
                    resultSet.getInt("quantidade")
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
    public Venda postVenda(Venda novaVenda)
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
