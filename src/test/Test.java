package test;
import model.Contato;
import model.Musicista;
import java.text.SimpleDateFormat;
import java.util.Date;

import enums.Habilidade;
import enums.Sexo;
import enums.TipoContato;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			Contato novoContato = new Contato( null, "@jefersonlors");
//			System.out.println(novoContato);
//			novoContato.setValor("@gigabyte");
//			System.out.println(novoContato);
//			System.out.println(novoContato.getTipo());
//			System.out.println(novoContato.getValor());
			
			var formatoData = new SimpleDateFormat("dd/mm/yyy");
				
			Musicista novoMusicista = new Musicista("Jeferson Lors", Sexo.MASCULINO, formatoData.parse("03/01/2001") );
			
			novoMusicista.adicionaHabilidade(Habilidade.GUITARRA);
			novoMusicista.adicionaHabilidade(Habilidade.VOCAL);
			
			novoMusicista.adicionaContato(TipoContato.EMAIL, "lors.jeferson@gmail.com");
			novoMusicista.adicionaContato(TipoContato.INSTAGRAM, "jefersonLors");
			
			novoMusicista.atualizaContato(TipoContato.INSTAGRAM, "jefersonLors", "@photofocando");
			
			System.out.println(novoMusicista);
			
		}catch( Exception ex) {
			ex.printStackTrace();
		}

		
		
		
	}

}
