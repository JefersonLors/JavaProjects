package dao.idao;

import dao.filter.EditoraFiltro;
import dao.fromDB.EditoraFromDB;
import exceptions.EditoraInvalidaException;
import model.Editora;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoEditora {
    void postEditora(Editora editoraNova) throws SQLException;
    void putEditora(Editora editoraAtualizada) throws SQLException, EditoraInvalidaException;
    void deleteEditora( Editora editoraDeletada) throws SQLException, EditoraInvalidaException;
    ArrayList<EditoraFromDB> getEditora(EditoraFiltro editoraFiltro) throws SQLException;
    ArrayList<EditoraFromDB> getEditora( ) throws SQLException;
}
