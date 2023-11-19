package dao;

import dao.idao.IDaoEditora;

import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEditora implements IDaoEditora {
    @Override
    public Class<?> postEditora(Class<?> editoraNova) throws SQLException {
        return null;
    }

    @Override
    public Class<?> putEditora(Class<?> editoraAtualizada) throws SQLException {
        return null;
    }

    @Override
    public Class<?> deleteEditora(Class<?> editoraDeletada) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getEditora(Class<?> editoraFiltro) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getEditora() throws SQLException {
        return null;
    }
}
