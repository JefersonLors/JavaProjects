package model;

import model.Musicista;
import java.util.Date;

import model.enums.Sexo;
import model.exceptions.DataNascimentoInvalidaException;
import model.exceptions.NomeInvalidoException;
import model.exceptions.SexoInvalidoException;
import model.utils.Utils;

public class Produtor extends Musicista {
	private String nomeProdutora;
	
	public Produtor(String nome, Sexo sexo, Date nascimento, String nomeProdutora)
			throws NomeInvalidoException, DataNascimentoInvalidaException, SexoInvalidoException {
		super(nome, sexo, nascimento);
		
		if( Utils.validaStringVazia(nomeProdutora))
			throw new NomeInvalidoException("O nome da produtora não pode estar vazio");
		// TODO Auto-generated constructor stub
		
		this.nomeProdutora = nomeProdutora;
	}

	public String getNomeProdutora() {
		return nomeProdutora;
	}

	public void setNomeProdutora(String nomeProdutora) 
			throws NomeInvalidoException{
		if( Utils.validaStringVazia(nomeProdutora))
			throw new NomeInvalidoException("O nome da produtora não pode estar vazio");
		this.nomeProdutora = nomeProdutora;
	}
	@Override
	public String toString() {
		String resultado = this.toString();
		resultado += "Nome produtora: " + this.getNomeProdutora() + "\n";
		
		return resultado;
		
	}

}
