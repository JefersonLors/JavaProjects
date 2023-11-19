package utils;
import dao.DaoEditora;
import dao.idao.IDaoEditora;

public class Utils {
    private static IDaoEditora daoEditora;
    public static boolean validaStringVazia( String string ){
        if( string == null || string.isBlank() )
            return true;
        return false;
    }
    public static boolean validaSexo( String sexo ){
        if( Utils.validaStringVazia(sexo) )
            return false;
        if( !sexo.equalsIgnoreCase("M") &&
            !sexo.equalsIgnoreCase( "F") )
            return false;
        return true;
    }
    public static boolean validaPreco( double preco){
        if( preco < 0 )
            return false;
        return true;
    }
    public static boolean validaCodigoEditora( int codEditora ){
        //var editora = daoEditora.postEditora();

        return true;
    }
    public static boolean validaCodigoAutor( int codAutor ){
        return true;
    }
    public static boolean validaCodigoLivro( int codLivro ){
        return true;
    }
}
