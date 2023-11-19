package dao.filter;

public class EditoraFiltro {
    public String codEditora;
    public String descricao;
    public String endereco;

    public EditoraFiltro(String codEditora, String descricao, String endereco) {
        this.codEditora = codEditora;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public EditoraFiltro() {
    }
}
