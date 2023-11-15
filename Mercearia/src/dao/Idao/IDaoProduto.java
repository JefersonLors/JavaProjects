package dao.Idao;

import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;
import exceptions.ProdutoInexistenteException;
import model.Produto;
import model.filtros.ProdutoFiltro;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import dao.fromDB.ProdutoFDB;

public interface IDaoProduto {
    ArrayList<ProdutoFDB> getProdutos()
            throws SQLException, NomeInvalidoException, PrecoInvalidoException;
    ArrayList<ProdutoFDB> getProdutos(ProdutoFiltro produtoFiltro)
            throws SQLException, NomeInvalidoException, PrecoInvalidoException;
    ProdutoFDB getProdutoPorId(long id)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException;

    ProdutoFDB putProduto(Produto produtoAtualizado)
            throws SQLException, ProdutoInexistenteException, NomeInvalidoException, PrecoInvalidoException;

    ProdutoFDB postProduto(Produto produtoNovo) throws SQLException;
}
