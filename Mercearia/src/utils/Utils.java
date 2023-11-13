package utils;

public class Utils {
    public static boolean validaPrecoProduto( Double precoProduto ){
        if( precoProduto < 0 ){
            return false;
        }
        return true;
    }
    public static boolean validaCampoTextoVazio( String texto){
        if( texto.isEmpty() || texto.isBlank() ){
            return false;
        }
        return true;
    }
    public static boolean validaQuantidadeProduto( int quantidade ){
        if( quantidade < 1 ){
            return false;
        }
        return true;
    }
    public static boolean validaQuantidadeMenorUm( long quantidade )
    {
        if( quantidade < 1 ){
            return true;
        }
        return false;
    }
    public static boolean validaNomeVazioOuNulo(String nome){
        if( nome.isBlank() || nome.isEmpty() )
            return true;
        return false;
    }
    public static boolean validaPrecoNegatio( double preco ){
        if( preco < 0)
            return true;
        return false;
    }
}
