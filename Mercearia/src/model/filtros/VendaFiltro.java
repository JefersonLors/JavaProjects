package model.filtros;

public class VendaFiltro {
    public String id;
    public String idProduto;
    public String quantidade;

    public VendaFiltro(String id, String idProduto, String quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
    public VendaFiltro(String idProduto, String quantidade) {
        this.id = "";
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
    public VendaFiltro(String quantidade) {
        this.id = "";
        this.idProduto = "";
        this.quantidade = quantidade;
    }
}
