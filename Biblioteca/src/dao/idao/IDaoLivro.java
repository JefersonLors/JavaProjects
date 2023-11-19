package dao.idao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoLivro {
    Class<?> postLivro(Class<?> livroNovo) throws SQLException;
    Class<?> putLivro(Class<?> livroAtualizado) throws SQLException;
    Class<?> deleteLivro( Class<?> livroDeletado) throws SQLException;
    ArrayList<?> getLivro(Class<?> livroFiltro) throws SQLException;
    ArrayList<?> getLivro( ) throws SQLException;
}
