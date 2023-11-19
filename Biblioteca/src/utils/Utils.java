package utils;
import dao.idao.IDaoEditora;
import dao.idao.IDaoAutor;
import dao.idao.IDaoEditora;
import dao.idao.IDaoLivro;
import dao.idao.IDaoLivroAutor;

public class Utils {
    private static IDaoEditora iDaoEditora;
    private static IDaoLivro iDaoLivro;
    private static IDaoAutor iDaoAutor;
    private static IDaoLivroAutor iDaoLivroAutor;
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
        //var editora = iDaoEditora.postEditora();

        return true;
    }
    public static boolean validaCodigoAutor( int codAutor ){
        return true;
    }
    public static boolean validaCodigoLivro( int codLivro ){
        return true;
    }
}
