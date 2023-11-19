package dao;

import dao.filter.LivroAutorFiltro;
import dao.fromDB.AutorFromDB;
import dao.fromDB.LivroAutorFromDB;
import dao.idao.IDaoAutor;
import dao.idao.IDaoLivroAutor;
import model.LivroAutor;

import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLivroAutor implements IDaoLivroAutor {

    @Override
    public void postLivroAutor(LivroAutor livroAutorNovo) throws SQLException {
    }

    @Override
    public void putLivroAutor(LivroAutor livroAutorAtualizado) throws SQLException {

    }

    @Override
    public void deleteLivroAutor(LivroAutor livroAutorDeletado) throws SQLException {

    }

    @Override
    public ArrayList<LivroAutorFromDB> getLivroAutor(LivroAutorFiltro livroAutorFiltro) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<LivroAutorFromDB> getLivroAutor() throws SQLException {
        return null;
    }
}
