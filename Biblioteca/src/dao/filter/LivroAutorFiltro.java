package dao.filter;

public class LivroAutorFiltro {
    public String codLivro;
    public String codAutor;

    public LivroAutorFiltro() {
    }

    public LivroAutorFiltro(String codLivro, String codAutor) {
        this.codLivro = codLivro;
        this.codAutor = codAutor;
    }
}
