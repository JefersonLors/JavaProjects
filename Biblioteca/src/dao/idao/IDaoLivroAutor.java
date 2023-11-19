package dao.idao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoLivroAutor {
    Class<?> postLivroAutor(Class<?> livroAutorNovo) throws SQLException;
    Class<?> putLivroAutor(Class<?> livroAutorAtualizado) throws SQLException;
    Class<?> deleteLivroAutor(Class<?> livroAutorDeletado) throws SQLException;
    ArrayList<?> getLivroAutor(Class<?> livroAutorFiltro) throws SQLException;
    ArrayList<?> getLivroAutor( ) throws SQLException;
}
