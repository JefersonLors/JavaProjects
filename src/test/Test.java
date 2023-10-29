package test;
import model.Contato;
import model.Musicista;
import java.text.SimpleDateFormat;
import java.util.List;

import model.ProcessoSeletivo;
import model.enums.Habilidade;
import model.enums.Sexo;
import model.enums.TipoContato;

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

			Musicista produtor = new Musicista("Jeferson Lors", Sexo.MASCULINO, formatoData.parse("03/01/2001") );

			produtor.adicionaHabilidade(Habilidade.GUITARRA);
			produtor.adicionaHabilidade(Habilidade.VOCAL);

			produtor.adicionaContato(TipoContato.EMAIL, "lors.jeferson@gmail.com");
			produtor.adicionaContato(TipoContato.INSTAGRAM, "@jefersonLors");

			produtor.atualizaContato(TipoContato.INSTAGRAM, "@jefersonLors", "@photofocando");

			Musicista musicistaA = new Musicista("Daniela Stone", Sexo.FEMININO, formatoData.parse("14/10/1997") );

			musicistaA.adicionaHabilidade(Habilidade.COMPOSICAO);
			musicistaA.adicionaHabilidade(Habilidade.CONTRABAIXO);
			musicistaA.adicionaHabilidade(Habilidade.BATERIA);

			musicistaA.adicionaContato(TipoContato.INSTAGRAM, "@danilastoneoficial");

//			System.out.println(novoMusicista);

			ProcessoSeletivo novoProcesso = new ProcessoSeletivo("John Mayer");

			novoProcesso.setProdutor(produtor);
			novoProcesso.cadastraCanditado(musicistaA);

			System.out.println(novoProcesso);

			var musicista = novoProcesso.getMusicistaPorCodigo(1);

			var contatos = musicista.getContatos();

			contatos.add(new Contato(TipoContato.FACEBOOK, "contato teste"));

			novoProcesso.atualizaCandidato(1, produtor);

			System.out.println("Candidatos Cadastrados no processo " + novoProcesso.getCodProcesso() + ": ");

			for( var candidato : novoProcesso.getAllCandidatos()){
				System.out.println(candidato);
			}

			System.out.println(novoProcesso.getMusicistaPorHabilidade(Habilidade.GUITARRA));

		}catch( Exception ex) {
			ex.printStackTrace();
		}

	}

}
