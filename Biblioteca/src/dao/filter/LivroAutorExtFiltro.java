package dao.filter;

public class LivroAutorExtFiltro {
    public String codLivro;
    public String isbn;
    public String titulo;
    public String numEdicao;
    public String preco;
    public String codEditora;
    public String codAutor;
    public String nomeAutor;
    public String sexoAutor;

    public LivroAutorExtFiltro() {
    }

    public LivroAutorExtFiltro(String codLivro, String isbn, String titulo, String numEdicao, String preco, String codEditora, String codAutor, String nomeAutor, String sexoAutor) {
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
