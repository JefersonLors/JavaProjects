package dao.Idao;

import exceptions.ProdutoInexistenteException;
import model.Produto;

import java.util.List;
import java.sql.SQLException;

public interface IDaoProduto {
    List<Produto> getTodosOsProdutos() throws SQLException;
    Produto getProdutoPorId(long id)
            throws SQLException, ProdutoInexistenteException;
    Produto putProdutoPorId(Produto produtoAtualizado, long id)
            throws SQLException, ProdutoInexistenteException;
    Produto postProduto(Produto produtoNovo) throws SQLException;
}
