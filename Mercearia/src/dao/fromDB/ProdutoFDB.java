package dao.fromDB;

public class ProdutoFDB {
    public long id;
    public String nome;
    public double preco;

    public ProdutoFDB(long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
}
