package dao.idao;

import java.sql.SQLException;
import java.util.ArrayList;
public interface IDaoAutor {
    Class<?> postAutor(Class<?> autorNovo) throws SQLException;
    Class<?> putAutor(Class<?> autorAtualizado) throws SQLException;
    Class<?> deleteAutor(Class<?> autorDeletado) throws SQLException;
    ArrayList<?> getAutor(Class<?> autorFiltro) throws SQLException;
    ArrayList<?> getAutor( ) throws SQLException;
}
