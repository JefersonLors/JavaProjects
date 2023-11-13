package dao.entities;

public class VendaJoinProduto {
    public long idVenda;
    public String nomeProduto;
    public Double preco;
    public long quantidade;

    public VendaJoinProduto(long idVenda, String nomeProduto, Double preco, long quantidade) {
        this.idVenda = idVenda;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
