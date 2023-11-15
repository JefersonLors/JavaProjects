package dao.fromDB;

public class VendaJoinProdutoFDB {
    public long idVenda;
    public String nomeProduto;
    public Double preco;
    public long quantidade;

    public VendaJoinProdutoFDB(long idVenda, String nomeProduto, Double preco, long quantidade) {
        this.idVenda = idVenda;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
