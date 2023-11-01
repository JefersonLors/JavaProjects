package model;

import java.util.Date;

import model.enums.Sexo;
import model.exceptions.DataNascimentoInvalidaException;
import model.exceptions.NomeInvalidoException;
import model.exceptions.SexoInvalidoException;

public class Candidato extends Musicista {
	private String textoApresent;
	
	public Candidato(String nome, Sexo sexo, Date nascimento)
			throws NomeInvalidoException, DataNascimentoInvalidaException, SexoInvalidoException {
		super(nome, sexo, nascimento);
		// TODO Auto-generated constructor stub
	}
	
	public void setTextoApresent(String textoApresent) {
		this.textoApresent = textoApresent;
	}
	
	public String getTextoApresent() {
		return textoApresent;
	}
	
}
