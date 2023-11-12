package dao.Idao;
import exceptions.QuantidadeInvalidaException;
import exceptions.VendaInexistenteException;
import model.Venda;

import java.util.ArrayList;
import java.sql.SQLException;

public interface IDaoVenda {
    ArrayList<Venda> getVendas() throws SQLException, QuantidadeInvalidaException;
    Venda getVendaPorId(long id)
            throws SQLException, VendaInexistenteException, QuantidadeInvalidaException;
    Venda postVenda(Venda novaVenda) throws SQLException;
}
