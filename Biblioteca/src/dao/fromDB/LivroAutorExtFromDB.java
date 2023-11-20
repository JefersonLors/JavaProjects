package dao.fromDB;

public class LivroAutorExtFromDB {
    public int codLivro;
    public int isbn;
    public String titulo;
    public int numEdicao;
    public double preco;
    public int codEditora;
    public int codAutor;
    public String nomeAutor;
    public String sexoAutor;

    public LivroAutorExtFromDB(int codLivro, int isbn, String titulo, int numEdicao, double preco, int codEditora, int codAutor, String nomeAutor, String sexoAutor) {
        this.codLivro = codLivro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.numEdicao = numEdicao;
        this.preco = preco;
        this.codEditora = codEditora;
        this.codAutor = codAutor;
        this.nomeAutor = nomeAutor;
        this.sexoAutor = sexoAutor;
    }
}
