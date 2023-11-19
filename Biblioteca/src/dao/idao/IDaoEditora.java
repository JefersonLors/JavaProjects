package dao.idao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoEditora {
    Class<?> postEditora(Class<?> editoraNova) throws SQLException;
    Class<?> putEditora(Class<?> editoraAtualizada) throws SQLException;
    Class<?> deleteEditora( Class<?> editoraDeletada) throws SQLException;
    ArrayList<?> getEditora(Class<?> editoraFiltro) throws SQLException;
    ArrayList<?> getEditora( ) throws SQLException;
}
