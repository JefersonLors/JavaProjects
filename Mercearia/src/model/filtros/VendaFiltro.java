package model.filtros;

public class VendaFiltro {
    public String idProduto;
    public String quantidade;

    public String preco;

    public VendaFiltro(String idProduto, String quantidade, String preco) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public VendaFiltro(String idProduto, String quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco = "";
    }
    public VendaFiltro(String quantidade) {
        this.idProduto = "";
        this.quantidade = quantidade;
        this.preco = "";
    }
}
