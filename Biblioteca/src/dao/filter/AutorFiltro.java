package dao.filter;

import java.util.Date;

public class AutorFiltro {
    public String codAutor;
    public String nome;
    public String sexo;
    public String dataNascimento;

    public AutorFiltro() {
    }
    public AutorFiltro(String codAutor, String nome, String sexo, String dataNascimento) {
        this.codAutor = codAutor;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }
}
