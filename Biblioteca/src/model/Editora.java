package model;

import exceptions.DescricaoInvalidaException;
import utils.Utils;

public class Editora {
    private int codEditora;
    private String descricao;
    private String endereco;

    public Editora( int codEditora, String descricao, String endereco )
            throws DescricaoInvalidaException {
        if(Utils.validaStringVazia(descricao))
            throw new DescricaoInvalidaException("A descrição da editora é um campo obrigatório.");

        this.codEditora = codEditora;
        this.descricao = descricao;
        this.endereco = endereco;
    }
    public Editora( String descricao, String endereco )
            throws DescricaoInvalidaException{
        this( -1, descricao, endereco);
    }

    public int getCodEditora() {
        return codEditora;
    }

    public void setCodEditora(int codEditora) {
        this.codEditora = codEditora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws DescricaoInvalidaException {
        if(Utils.validaStringVazia(descricao))
            throw new DescricaoInvalidaException("A descrição da editora é um campo obrigatório.");
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
