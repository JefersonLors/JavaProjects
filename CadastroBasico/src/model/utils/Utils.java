package model.utils;

import jdk.jshell.execution.Util;
import model.Contato;
import model.Musicista;
import model.enums.Sexo;
import model.enums.TipoContato;
import model.exceptions.ContatoInvalidoException;
import model.exceptions.FormatoContatoInadequadoException;
import model.exceptions.ValorNuloException;

import java.util.Date;

public class Utils {
    public static boolean validaSexo(Sexo sexo) {
        return !Utils.isNull(sexo);
    }

    public static boolean validaStringVazia(String nome) {
        if( nome == null || nome.isEmpty() || nome.isBlank() ) {
            return false;
        }
        return true;
    }
    public static boolean validaNascimento( Date nascimento ) {
        // Verifica se a data nascimento não é maior que a data atual
        return true;
    }
    public static boolean isNull( Object obj ) {
        return obj == null ? true : false;
    }


}
