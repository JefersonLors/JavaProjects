package dao.Idao;

import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;
import exceptions.ProdutoInexistenteException;
import model.Produto;

import java.util.List;
import java.sql.SQLException;

public interface IDaoProduto {
    List<Produto> getTodosOsProdutos() throws SQLException, NomeInvalidoException, PrecoInvalidoException;
    Produto getProdutoPorId(long id)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException;
    Produto putProdutoPorId(Produto produtoAtualizado)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException;
    Produto postProduto(Produto produtoNovo) throws SQLException;
}
