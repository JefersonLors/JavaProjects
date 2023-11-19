package dao.idao;

import dao.filter.LivroFiltro;
import dao.fromDB.LivroFromDB;
import exceptions.LivroInvalidoException;
import model.Livro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoLivro {
    void postLivro(Livro livroNovo) throws SQLException;
    void putLivro(Livro livroAtualizado) throws SQLException, LivroInvalidoException;
    void deleteLivro(Livro livroDeletado) throws SQLException, LivroInvalidoException;
    ArrayList<LivroFromDB> getLivro(LivroFiltro livroFiltro) throws SQLException;
    ArrayList<LivroFromDB> getLivro( ) throws SQLException;
}
