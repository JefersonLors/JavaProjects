package model;

import exceptions.QuantidadeInvalidaException;

public class Venda {
    private long id;
    private long idProduto;
    private long quantidade;

    public Venda( long id, long idProduto, long quantidade) throws QuantidadeInvalidaException {
        if( this.validaQuantidadeMenorUm(quantidade))
            throw new QuantidadeInvalidaException("A quantidade de produto vendido não pode ser menor que 1");
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Venda( long idProduto, long quantidade) throws QuantidadeInvalidaException {
        if( this.validaQuantidadeMenorUm(quantidade))
            throw new QuantidadeInvalidaException("A quantidade de produto vendido não pode ser menor que 1");
        this.id = -1;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
    public Venda() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) throws QuantidadeInvalidaException {
        if( this.validaQuantidadeMenorUm(quantidade))
            throw new QuantidadeInvalidaException("A quantidade de produto vendido não pode ser menor que 1");
        this.quantidade = quantidade;
    }

    private static boolean validaQuantidadeMenorUm( long quantidade )
    {
        if( quantidade < 1 ){
            return true;
        }
        return false;
    }

    public String toString(){
        return this.id + " " + this.idProduto + " " + this.quantidade;
    }
}
