package dao.Idao;

import model.Produto;

import java.util.List;
import java.sql.SQLException;

public interface IDaoProduto {
    List<Produto> getTodosOsProdutos() throws SQLException;
    Produto getProdutoPorId(long id) throws SQLException;
    Produto putProdutoPorId(Produto produtoAtualizado, long id) throws SQLException;
    Produto postProduto(Produto produtoNovo) throws SQLException;
}
