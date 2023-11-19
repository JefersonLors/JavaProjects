package dao;

import dao.idao.IDaoAutor;

import java.sql.SQLException;
import java.util.ArrayList;

public class DaoAutor implements IDaoAutor {
    @Override
    public Class<?> postAutor(Class<?> autorNovo) throws SQLException {
        return null;
    }

    @Override
    public Class<?> putAutor(Class<?> autorAtualizado) throws SQLException {
        return null;
    }

    @Override
    public Class<?> deleteAutor(Class<?> autorDeletado) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getAutor(Class<?> autorFiltro) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getAutor() throws SQLException {
        return null;
    }
}
