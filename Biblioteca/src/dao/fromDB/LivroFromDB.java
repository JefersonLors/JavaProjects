package dao.fromDB;

public class LivroFromDB {
    public int codLivro;
    public String isbn;
    public String titulo;
    public int numEdicao;
    public double preco;
    public int codEditora;
    public LivroFromDB() {
    }
    public LivroFromDB(int codLivro, String isbn, String titulo, int numEdicao, double preco, int codEditora) {
        this.codLivro = codLivro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.numEdicao = numEdicao;
        this.preco = preco;
        this.codEditora = codEditora;
    }

    public String toString(){
        return this.codLivro + " "
                + this.isbn + " "
                + this.titulo + " "
                + this.numEdicao + " "
                + this.preco + " "
                + this.codEditora + " " ;
    }

}
