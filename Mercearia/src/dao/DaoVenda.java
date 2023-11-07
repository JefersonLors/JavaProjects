package dao;

import dao.Idao.IDaoVenda;
import model.Venda;

import java.sql.SQLException;
import java.util.List;

public class DaoVenda implements IDaoVenda {
    @Override
    public List<Venda> getTodasAsVendas() throws SQLException {
        return null;
    }

    @Override
    public Venda getVendaPorId(long id) throws SQLException {
        return null;
    }

    @Override
    public Venda potsVenda(Venda novaVenda) throws SQLException {
        return null;
    }
}
