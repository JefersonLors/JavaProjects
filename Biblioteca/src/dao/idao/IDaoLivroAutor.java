package dao.idao;

import dao.filter.AutorFiltro;
import dao.filter.LivroAutorFiltro;
import dao.fromDB.AutorFromDB;
import dao.fromDB.LivroAutorFromDB;
import model.Autor;
import model.LivroAutor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoLivroAutor {
    void postLivroAutor(LivroAutor livroAutorNovo) throws SQLException;
    void putLivroAutor(LivroAutor livroAutorAtualizado) throws SQLException;
    void deleteLivroAutor(LivroAutor livroAutorDeletado) throws SQLException;
    ArrayList<LivroAutorFromDB> getLivroAutor(LivroAutorFiltro livroAutorFiltro) throws SQLException;
    ArrayList<LivroAutorFromDB> getLivroAutor( ) throws SQLException;
}
