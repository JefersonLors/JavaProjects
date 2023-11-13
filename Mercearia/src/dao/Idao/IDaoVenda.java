package dao.Idao;
import dao.entities.VendaJoinProduto;
import exceptions.QuantidadeInvalidaException;
import exceptions.VendaInexistenteException;
import model.Venda;
import model.filtros.VendaFiltro;

import java.util.ArrayList;
import java.sql.SQLException;

public interface IDaoVenda {
    public ArrayList<VendaJoinProduto> getVendas() throws SQLException, QuantidadeInvalidaException;
    ArrayList<VendaJoinProduto> getVendas(VendaFiltro filtro)throws SQLException, QuantidadeInvalidaException;
    Venda getVendaPorId(long id)
            throws SQLException, VendaInexistenteException, QuantidadeInvalidaException;
    Venda postVenda(Venda novaVenda) throws SQLException;
}
