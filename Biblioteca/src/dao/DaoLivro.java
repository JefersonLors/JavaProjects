package dao;

import dao.idao.IDaoLivro;

import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLivro implements IDaoLivro {
    @Override
    public Class<?> postLivro(Class<?> livroNovo) throws SQLException {
        return null;
    }

    @Override
    public Class<?> putLivro(Class<?> livroAtualizado) throws SQLException {
        return null;
    }

    @Override
    public Class<?> deleteLivro(Class<?> livroDeletado) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getLivro(Class<?> livroFiltro) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getLivro() throws SQLException {
        return null;
    }
}
