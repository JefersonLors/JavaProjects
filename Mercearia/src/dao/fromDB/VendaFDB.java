package dao.fromDB;
public class VendaFDB {
    public long id;
    public long idProduto;
    public long quantidade;

    public VendaFDB(long id, long idProduto, long quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
}
