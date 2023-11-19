package dao.idao;

import dao.filter.AutorFiltro;
import dao.fromDB.AutorFromDB;
import exceptions.AutorInvalidoException;
import model.Autor;

import java.sql.SQLException;
import java.util.ArrayList;
public interface IDaoAutor {
    void postAutor(Autor autorNovo) throws SQLException;
    void putAutor(Autor autorAtualizado) throws SQLException, AutorInvalidoException;
    void deleteAutor(Autor autorDeletado) throws SQLException, AutorInvalidoException;
    ArrayList<AutorFromDB> getAutor(AutorFiltro autorFiltro) throws SQLException;
    ArrayList<AutorFromDB> getAutor( ) throws SQLException;
}
