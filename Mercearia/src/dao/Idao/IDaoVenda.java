package dao.Idao;
import dao.fromDB.VendaFDB;
import dao.fromDB.VendaJoinProdutoFDB;
import exceptions.QuantidadeInvalidaException;
import exceptions.VendaInexistenteException;
import model.Venda;
import model.filtros.VendaFiltro;

import java.util.ArrayList;
import java.sql.SQLException;

public interface IDaoVenda {
    public ArrayList<VendaJoinProdutoFDB> getVendas() throws SQLException, QuantidadeInvalidaException;
    ArrayList<VendaJoinProdutoFDB> getVendas(VendaFiltro filtro)throws SQLException, QuantidadeInvalidaException;
    VendaFDB getVendaPorId(long id)
            throws SQLException, VendaInexistenteException, QuantidadeInvalidaException;
    VendaFDB postVenda(Venda novaVenda) throws SQLException;
}
