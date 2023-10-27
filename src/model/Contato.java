package model;

import enums.TipoContato;
import exceptions.FormatoContatoInadequadoException;
import exceptions.ValorNuloException;

public class Contato {
	private TipoContato tipo;
	private String valor;
	
	public Contato( TipoContato tipo, String valor) 
		throws FormatoContatoInadequadoException, ValorNuloException
	{
		if( !Contato.validaFormato(tipo, valor))
			throw new FormatoContatoInadequadoException( "O formato do contato passado não corresponde ao tipo selecionado" );
		
		if( !Contato.validaTipo(tipo))
			throw new ValorNuloException("O tipo é obrigatório");
		
		this.tipo = tipo;
		this.valor = valor;
	}
	
	private static boolean validaTipo(TipoContato tipo) {
		if( tipo == null )
			return false;
		return true;
	}

	private static boolean validaFormato( TipoContato tipo, String valor ) 
		throws ValorNuloException
	{ 
		if( valor == null || valor.isBlank() || valor.isEmpty())
			throw new ValorNuloException("O contato não pode ser nulo.");
		//Adicionar validação para cada tipo de formato com base em regex
		return true;
	}
	
	public TipoContato getTipo() {
		return tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) 
		throws FormatoContatoInadequadoException, ValorNuloException
	{
		if( !Contato.validaFormato(this.tipo, valor))
			throw new FormatoContatoInadequadoException( "O formato do contato passado não corresponde ao tipo selecionado" );
		this.valor = valor;
	}

	public String toString() {
		return this.tipo + ": " + this.valor;
	}
}
