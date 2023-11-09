package model;

import exceptions.NomeInvalidoException;
import exceptions.PrecoInvalidoException;

public class Produto {
    private long id;
    private String nome;
    private double preco;

    public Produto( long id, String nome, double preco)
        throws NomeInvalidoException, PrecoInvalidoException
    {
        if( this.validaNomeVazioOuNulo(nome))
            throw new NomeInvalidoException("O nome do produto não pode ser nulo");
        if( this.validaPrecoNegatio(preco))
            throw new PrecoInvalidoException("O preco não pode ser negativo");
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeInvalidoException {
        if( this.validaNomeVazioOuNulo(nome))
            throw new NomeInvalidoException("O nome do produto não pode ser nulo");

        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws PrecoInvalidoException {
        if( this.validaPrecoNegatio(preco))
            throw new PrecoInvalidoException("O preco não pode ser negativo");
        this.preco = preco;
    }

    private static boolean validaNomeVazioOuNulo(String nome){
        if( nome == null || nome.isBlank() || nome.isEmpty() )
            return true;
        return false;
    }
    private static boolean validaPrecoNegatio( double preco ){
        if( preco < 0)
            return true;
        return false;
    }
}
