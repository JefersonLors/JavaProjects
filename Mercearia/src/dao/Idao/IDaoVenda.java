package dao.Idao;
import exceptions.QuantidadeInvalidaException;
import exceptions.VendaInexistenteException;
import model.Venda;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public interface IDaoVenda {
    ArrayList<Venda> getTodasAsVendas() throws SQLException, QuantidadeInvalidaException;
    Venda getVendaPorId(long id)
            throws SQLException, VendaInexistenteException, QuantidadeInvalidaException;
    Venda potsVenda(Venda novaVenda) throws SQLException;
}
