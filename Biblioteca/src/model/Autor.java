package model;

import exceptions.DataNascimentoInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.SexoInvalidoExeception;
import utils.Utils;

import java.util.ArrayList;
import java.util.Date;

public class Autor {
    private int codAutor;
    private String nome;
    private String sexo;
    private Date dataNascimento;

    public Autor ( int codAutor, String nome, String sexo, Date dataNascimento )
            throws NomeInvalidoException, SexoInvalidoExeception, DataNascimentoInvalidoException {
        if(Utils.validaStringVazia(nome))
            throw new NomeInvalidoException("O nome não pode estar vazio.");
        if(!Utils.validaSexo(sexo))
            throw new SexoInvalidoExeception("Sexo inválido. Insira M (masculino) ou F (feminino).");
        if(Utils.validaStringVazia(dataNascimento.toString()))
            throw new DataNascimentoInvalidoException("A data de nascimento é um campo obrigatório.");
        var lista = new ArrayList<Integer> ();

        this.codAutor = codAutor;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }
    public Autor ( String nome, String sexo, Date dataNascimento )
            throws NomeInvalidoException, SexoInvalidoExeception, DataNascimentoInvalidoException {
        this( -1, nome, sexo, dataNascimento);
    }

    public int getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(int codAutor) {
        this.codAutor = codAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeInvalidoException {
        if(Utils.validaStringVazia(nome))
            throw new NomeInvalidoException("O nome não pode estar vazio.");
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) throws SexoInvalidoExeception {
        if( Utils.validaSexo(sexo))
            throw new SexoInvalidoExeception("Sexo inválido. Insira M (masculino) ou F (feminino).");
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) throws DataNascimentoInvalidoException {
        if( Utils.validaStringVazia(dataNascimento.toString()))
            throw new DataNascimentoInvalidoException("A data de nascimento é um campo obrigatório.");

        this.dataNascimento = dataNascimento;
    }
}
