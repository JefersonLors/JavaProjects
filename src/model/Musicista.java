package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.Habilidade;
import enums.Sexo;
import enums.TipoContato;
import exceptions.ContatoInvalidoException;
import exceptions.DataNascimentoInvalidaException;
import exceptions.FormatoContatoInadequadoException;
import exceptions.NomeInvalidoException;
import exceptions.SexoInvalidoException;
import exceptions.ValorNuloException;

public class Musicista {
	private String nome;
	private Sexo sexo;
	private Date nascimento;
	private byte foto;
	private List<Contato> contatos;
	private List<Habilidade> habilidades;
	private String textoApresent;
	
	public Musicista( String nome, Sexo sexo, Date nascimento) 
		throws NomeInvalidoException, DataNascimentoInvalidaException, SexoInvalidoException
	{ 
		if( !Musicista.validaStringVazia(nome))
			throw new NomeInvalidoException("O nome é obrigatório.");
		
		if( !Musicista.validaNascimento(nascimento))
			throw new DataNascimentoInvalidaException("A data de nascimento não pode ser maior que a data atual.");
		
		if( !Musicista.validaSexo(sexo))
			throw new SexoInvalidoException("O sexo é obrigatório.");
		
		this.nome = nome;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.contatos = new ArrayList<Contato>();
		this.habilidades = new ArrayList<Habilidade>();
	}
	
	//setters
	
	public void setNome(String nome) 
		throws NomeInvalidoException
	{
		if( !Musicista.validaStringVazia(nome))
			throw new NomeInvalidoException("O nome é obrigatório.");
		this.nome = nome;
	}

	public void setSexo(Sexo sexo) 
		throws SexoInvalidoException
	{
		if( !Musicista.validaSexo(sexo))
			throw new SexoInvalidoException("O sexo é obrigatório.");
		this.sexo = sexo;
	}
	
	public void setNascimento(Date nascimento) 
		throws DataNascimentoInvalidaException
	{
		if( !Musicista.validaNascimento(nascimento))
			throw new DataNascimentoInvalidaException("A data de nascimento não pode ser maior que a data atual.");
		this.nascimento = nascimento;
	}
	
	public void adicionaContato( TipoContato tipo, String valor) 
		throws FormatoContatoInadequadoException, ValorNuloException
	{
		this.contatos.add(new Contato(tipo, valor));
	}
	
	public void adicionaHabilidade( Habilidade nova ) { 
		this.habilidades.add(nova);
	}
	
	//getters
	
	public void setTextoApresent(String textoApresent) {
		this.textoApresent = textoApresent;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public String getTextoApresent() {
		return textoApresent;
	}
	
	public List<Contato> getContatos(){
		return new ArrayList<Contato>(this.contatos);
	}
	
	public List<String> getHabilidades(){
		ArrayList<String> resultado = new ArrayList<String>();
		
		for( Habilidade habilidade : this.habilidades ) { 
			resultado.add(habilidade.toString());
		}
		return resultado;
	}
	
	public byte getFoto() {
		return foto;
	}
	
	//utilitárias

	public void setFoto(byte foto) {
		this.foto = foto;
	}

	private static boolean validaSexo(Sexo sexo) {
		return !Musicista.isNull(sexo);
	}
	
	private static boolean validaStringVazia(String nome) {
		if( nome == null || nome.isEmpty() || nome.isBlank() ) { 
			return false;
		}
		return true;
	}
	
	private static boolean validaNascimento( Date nascimento ) { 
		// Verifica se a data nascimento não é maior que a data atual
		return true;
	}
	
	private static boolean isNull( Object obj ) {
		return obj == null ? true : false;
	}
	
	public Contato atualizaContato( TipoContato tipo, String valorAntigo, String valorNovo) 
		throws FormatoContatoInadequadoException, ContatoInvalidoException, ValorNuloException
	{
		for(var contato : this.contatos) {
			if( contato.getTipo().equals(tipo) && contato.getValor().equals(valorAntigo)) {
				contato.setValor(valorNovo);
				return contato;
			}
		}
		throw new ContatoInvalidoException("Este contato não existe");
	}
	
	// outros
	
	@Override
	public String toString() {
		String resultado = "";
		int qtdHabilidades = this.getHabilidades().size();
		int qtdContatos = this.getContatos().size();
		
		resultado += "Nome: " + this.getNome() + "\n" +
				     "Nascimento: " + this.getNascimento() + "\n" +
				     "Sexo: " + this.getSexo() + "\n";
		
		resultado += qtdHabilidades > 1 ? "Habilidades: " : "Habilidade: ";
		
		if( qtdHabilidades == 0 ) {
			resultado += "nenhuma" + "\n";
		}
		else{
			for( var habilidade : this.habilidades ) {
				resultado += "\n     " + habilidade.toString();
			}
		}
		
		resultado += "\n";
		
		resultado += qtdContatos > 1 ? "Contatos: " : "Contato: ";
		
		if( qtdContatos == 0 ) {
			resultado += "nenhum"+ "\n";
		}
		else{
			for( var contato : this.contatos ) {
				resultado += "\n     " + contato.toString();
			}
		}
		
		return resultado;
			   
	}
	
}
