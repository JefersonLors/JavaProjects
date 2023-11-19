package dao.fromDB;

import java.util.Date;

public class AutorFromDB {
    public int codAutor;
    public String nome;
    public String sexo;
    public Date dataNascimento;

    public AutorFromDB(int codAutor, String nome, String sexo, Date dataNascimento) {
        this.codAutor = codAutor;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public String toString(){
        return "" + this.codAutor + " " + this.nome + " " + sexo + " " + this.dataNascimento.toString();
    }
}
