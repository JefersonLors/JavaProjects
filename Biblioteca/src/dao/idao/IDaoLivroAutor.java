package dao.idao;

import dao.filter.AutorFiltro;
import dao.filter.LivroAutorExtFiltro;
import dao.filter.LivroAutorFiltro;
import dao.fromDB.AutorFromDB;
import dao.fromDB.LivroAutorExtFromDB;
import dao.fromDB.LivroAutorFromDB;
import exceptions.AutorInvalidoException;
import exceptions.LivroAutorInvalidoException;
import exceptions.LivroInvalidoException;
import model.Autor;
import model.LivroAutor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoLivroAutor {
    void postLivroAutor(LivroAutor livroAutorNovo) throws SQLException, AutorInvalidoException, LivroInvalidoException;
    void deleteLivroAutor(LivroAutor livroAutorDeletado) throws SQLException, LivroAutorInvalidoException;
    ArrayList<LivroAutorFromDB> getLivroAutor(LivroAutorFiltro livroAutorFiltro) throws SQLException;
    ArrayList<LivroAutorFromDB> getLivroAutor( ) throws SQLException;
    ArrayList<LivroAutorExtFromDB> getLivroAutorExt(LivroAutorExtFiltro livroAutorExtFiltro) throws SQLException;
    ArrayList<LivroAutorExtFromDB> getLivroAutorExt( ) throws SQLException;
}
