package dao.filter;

public class LivroFiltro {
    public String codLivro;
    public String isbn;
    public String titulo;
    public String numEdicao;
    public String preco;
    public String codEditora;

    public LivroFiltro() {
    }

    public LivroFiltro(String codLivro, String isbn, String titulo, String numEdicao, String preco, String codEditora) {
        this.codLivro = codLivro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.numEdicao = numEdicao;
        this.preco = preco;
        this.codEditora = codEditora;
    }
}
