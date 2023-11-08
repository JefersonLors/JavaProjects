package dao.Idao;
import model.Venda;

import java.util.List;
import java.sql.SQLException;

public interface IDaoVenda {
    List<Venda> getTodasAsVendas() throws SQLException;
    Venda getVendaPorId(long id) throws SQLException;
    Venda potsVenda(Venda novaVenda) throws SQLException;
}
