package dao.Idao;
import exceptions.VendaInexistenteException;
import model.Venda;

import java.util.List;
import java.sql.SQLException;

public interface IDaoVenda {
    List<Venda> getTodasAsVendas() throws SQLException;
    Venda getVendaPorId(long id)
            throws SQLException, VendaInexistenteException;
    Venda potsVenda(Venda novaVenda) throws SQLException;
}
