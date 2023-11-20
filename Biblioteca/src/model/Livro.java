package model;

import exceptions.CodigoEditoraInvalidoException;
import exceptions.PrecoInvalidoException;
import exceptions.TituloInvalidoException;
import utils.Utils;

public class Livro {
    private int codLivro;
    private String isbn;
    private String titulo;
    private int numEdicao;
    private double preco;
    private int codEditora;

    public Livro(int codLivro, String isbn, String titulo, int numEdicao, double preco, int codEditora)
            throws TituloInvalidoException, PrecoInvalidoException, CodigoEditoraInvalidoException {
        if(Utils.validaStringVazia(titulo))
            throw new TituloInvalidoException("O título é um campo obrigatório.");

        if(!Utils.validaCodigoEditora(codEditora))
            throw new CodigoEditoraInvalidoException("Esse código de editora não está associado à nenhuma editora.");

        if(!Utils.validaPreco(preco))
            throw new PrecoInvalidoException("O preço do livro não pode ser negativo.");

        this.codLivro = codLivro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.numEdicao = numEdicao;
        this.preco = preco;
        this.codEditora = codEditora;
    }
    public Livro(String isbn, String titulo, int numEdicao, double preco, int codEditora)
            throws TituloInvalidoException, PrecoInvalidoException, CodigoEditoraInvalidoException {
        this(-1, isbn, titulo, numEdicao, preco, codEditora);
    }

    public int getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(int codLivro) {
        this.codLivro = codLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws TituloInvalidoException {
        if(Utils.validaStringVazia(titulo))
            throw new TituloInvalidoException("O título é um campo obrigatório.");
        this.titulo = titulo;
    }

    public int getNumEdicao() {
        return numEdicao;
    }

    public void setNumEdicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws PrecoInvalidoException {
        if(!Utils.validaPreco(preco))
            throw new PrecoInvalidoException("O preço do livro não pode ser negativo.");
        this.preco = preco;
    }

    public int getCodEditora() {
        return codEditora;
    }

    public void setCodEditora(int codEditora) throws CodigoEditoraInvalidoException {
        if(!Utils.validaCodigoEditora(codEditora))
            throw new CodigoEditoraInvalidoException("Esse código de editora não está associado à nenhuma editora.");
        this.codEditora = codEditora;
    }
}
