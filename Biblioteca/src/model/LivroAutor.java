package model;

import exceptions.CodigoAutorInvalidoException;
import exceptions.CodigoLivroInvalidoException;
import utils.Utils;

public class LivroAutor {
    private int codLivro;
    private int codAutor;

    public LivroAutor(int codLivro, int codAutor)
            throws CodigoLivroInvalidoException, CodigoAutorInvalidoException {
        if(!Utils.validaCodigoLivro(codLivro))
            throw new CodigoLivroInvalidoException("Esse código não está associado a nenhum livro.");

        if(!Utils.validaCodigoAutor(codAutor))
            throw new CodigoAutorInvalidoException("Esse código não está associado a nenhum autor.");

        this.codLivro = codLivro;
        this.codAutor = codAutor;
    }

    public int getCodLivro() {
        return codLivro;
    }

    public int getCodAutor() {
        return codAutor;
    }
}
