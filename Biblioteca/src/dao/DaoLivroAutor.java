package dao;

import dao.idao.IDaoAutor;
import dao.idao.IDaoLivroAutor;

import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLivroAutor implements IDaoLivroAutor {
    @Override
    public Class<?> postLivroAutor(Class<?> livroAutorNovo) throws SQLException {
        return null;
    }

    @Override
    public Class<?> putLivroAutor(Class<?> livroAutorAtualizado) throws SQLException {
        return null;
    }

    @Override
    public Class<?> deleteLivroAutor(Class<?> livroAutorDeletado) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getLivroAutor(Class<?> livroAutorFiltro) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<?> getLivroAutor() throws SQLException {
        return null;
    }
}
