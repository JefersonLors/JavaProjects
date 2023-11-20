package dao.fromDB;

public class LivroAutorExtFromDB {
    public int codLivro;
    public String isbn;
    public String titulo;
    public int numEdicao;
    public double preco;
    public int codEditora;
    public String descricao;
    public int codAutor;
    public String nomeAutor;
    public String sexoAutor;

    public LivroAutorExtFromDB(int codLivro, String isbn, String titulo, int numEdicao, double preco, int codEditora, String descricao, int codAutor, String nomeAutor, String sexoAutor) {
        this.codLivro = codLivro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.numEdicao = numEdicao;
        this.preco = preco;
        this.codEditora = codEditora;
        this.descricao = descricao;
        this.codAutor = codAutor;
        this.nomeAutor = nomeAutor;
        this.sexoAutor = sexoAutor;
    }

    public String toString(){
        return this.codLivro + " " + this.isbn + " " + this.titulo + " " + this.numEdicao + " " + this.preco + " " +
                this.codEditora + " " +  this.descricao + " " + this.codAutor + " " + this.nomeAutor + " " + this.sexoAutor;
    }
}
