package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import model.enums.Habilidade;
import model.enums.Sexo;
import model.enums.TipoContato;
import model.exceptions.*;

import model.utils.Utils;

public class Musicista {
	private static long qtdMusicistas;
	private long codMusicista;
	private String nome;
	private Sexo sexo;
	private Date nascimento;
	private byte foto;
	private List<Contato> contatos;
	private List<Habilidade> habilidades;
	
	public Musicista( String nome, Sexo sexo, Date nascimento)
		throws NomeInvalidoException, DataNascimentoInvalidaException, SexoInvalidoException
	{
		if( !Utils.validaStringVazia(nome) )
			throw new NomeInvalidoException("O nome é obrigatório.");
		
		if( !Utils.validaNascimento(nascimento) )
			throw new DataNascimentoInvalidaException("A data de nascimento não pode ser maior que a data atual.");
		
		if( !Utils.validaSexo(sexo) )
			throw new SexoInvalidoException("O sexo é obrigatório.");
		
		this.nome = nome;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.contatos = new ArrayList<Contato>();
		this.habilidades = new ArrayList<Habilidade>();
		this.codMusicista = this.qtdMusicistas++;
	}
	
	//setters
	
	public void setNome(String nome) 
		throws NomeInvalidoException
	{
		if( !Utils.validaStringVazia(nome))
			throw new NomeInvalidoException("O nome é obrigatório.");
		this.nome = nome;
	}

	public void setSexo(Sexo sexo) 
		throws SexoInvalidoException
	{
		if( !Utils.validaSexo(sexo))
			throw new SexoInvalidoException("O sexo é obrigatório.");
		this.sexo = sexo;
	}
	
	public void setNascimento(Date nascimento) 
		throws DataNascimentoInvalidaException
	{
		if( !Utils.validaNascimento(nascimento))
			throw new DataNascimentoInvalidaException("A data de nascimento não pode ser maior que a data atual.");
		this.nascimento = nascimento;
	}
	
	public void adicionaContato( TipoContato tipo, String valor) 
		throws FormatoContatoInadequadoException, ValorNuloException
	{
		this.contatos.add(new Contato(tipo, valor));
	}
	public void adicionaHabilidade( Habilidade habilidadeNova )
		throws HabilidadeRepetidaException, ValorNuloException
	{
		if( Utils.isNull(habilidadeNova) )
			throw new ValorNuloException("A habilidade não pode ser nula.");

		for( var habilidade : this.habilidades ){
			if( habilidade.equals(habilidadeNova))
				throw new HabilidadeRepetidaException("O musicista já possui essa habilidade.");
		}

		this.habilidades.add(habilidadeNova);
	}
	public void deleteHabilidade( Habilidade habilidadeAntiga )
		throws MusicistaSemHabilidadeException
	{
		if(!this.habilidades.remove(habilidadeAntiga))
			throw new MusicistaSemHabilidadeException("O musicista não possui essa habilidade.");
	}
	public Contato atualizaContato(TipoContato tipo, String valorAntigo, String valorNovo)
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
	public void deletaContato(TipoContato tipo, String valor)
			throws ContatoInvalidoException, ValorNuloException
	{
		Contato contato = this.getContato(tipo, valor);

		if( Utils.isNull(contato) )
			throw new ContatoInvalidoException("Este contato não existe");

		this.contatos.remove(contato);
	}
	//getters
	public long getCodMusicista() { return codMusicista; }
	public String getNome() {
		return nome;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public List<Contato> getContatos(){
		return new ArrayList<Contato>(this.contatos);
	}
	public Contato getContato( TipoContato tipo, String valor )
			throws ContatoInvalidoException, ValorNuloException
	{
		if( Utils.isNull(valor))
			throw new ValorNuloException("O contato não pode ser nulo.");

		for(var contato : this.contatos) {
			if( contato.getTipo().equals(tipo) && contato.getValor().equals(valor)) {
				return contato;
			}
		}

		throw new ContatoInvalidoException("Este contato não existe");
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
	
	// outros
	@Override
	public String toString() {
		String resultado = "";
		int qtdHabilidades = this.getHabilidades().size();
		int qtdContatos = this.getContatos().size();
		
		resultado += "Código: " + this.getCodMusicista() + "\n" +
				     "Nome: " + this.getNome() + "\n" +
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
