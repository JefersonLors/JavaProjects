package model;

import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;
import utils.Utils;

public class Produto {
    private long id;
    private String nome;
    private double preco;

    public Produto( long id, String nome, double preco)
        throws NomeInvalidoException, PrecoInvalidoException
    {
        if( Utils.validaNomeVazioOuNulo(nome))
            throw new NomeInvalidoException("O nome do produto não pode ser nulo");
        if( Utils.validaPrecoNegatio(preco))
            throw new PrecoInvalidoException("O preco não pode ser negativo");
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    public Produto( String nome, double preco)
            throws NomeInvalidoException, PrecoInvalidoException
    {
        if( Utils.validaNomeVazioOuNulo(nome))
            throw new NomeInvalidoException("O nome do produto não pode ser nulo");
        if( Utils.validaPrecoNegatio(preco))
            throw new PrecoInvalidoException("O preco não pode ser negativo");
        this.id = -1;
        this.nome = nome;
        this.preco = preco;
    }
    public Produto( ) { }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(long id, String nome ) throws NomeInvalidoException {
        if( Utils.validaNomeVazioOuNulo(nome) )
            throw new NomeInvalidoException("O nome do produto não pode ser nulo");
        this.id = id;
        this.nome = nome;
    }
    public void setId(long id, String nome, Double preco )
            throws NomeInvalidoException, PrecoInvalidoException {
        if( Utils.validaNomeVazioOuNulo(nome) )
            throw new NomeInvalidoException("O nome do produto não pode ser nulo");

        if( Utils.validaPrecoNegatio(preco))
            throw new PrecoInvalidoException("O preco não pode ser negativo");

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeInvalidoException {
        if( Utils.validaNomeVazioOuNulo(nome))
            throw new NomeInvalidoException("O nome do produto não pode ser nulo");

        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws PrecoInvalidoException {
        if( Utils.validaPrecoNegatio(preco))
            throw new PrecoInvalidoException("O preco não pode ser negativo");
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "[" + this.id + "] - " + this.nome + " - R$" + this.preco;
    }
}
