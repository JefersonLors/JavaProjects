package model;

import model.enums.Habilidade;
import model.enums.Sexo;
import model.exceptions.*;
import model.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessoSeletivo {
    private static long qtdProcessos;
    private long codProcesso;
    private String nomeBanda;
    private Musicista produtor;
    private List<Musicista> candidatos;

    public ProcessoSeletivo( String nomeBanda )
        throws NomeInvalidoException
    {
        if(!Utils.validaStringVazia(nomeBanda))
            throw new NomeInvalidoException("O nome da banda não pode ser nulo");

        this.nomeBanda = nomeBanda;
        this.candidatos = new ArrayList<Musicista>();
        this.codProcesso = this.qtdProcessos++;
    }

    //Setters
    public void setProdutor( Musicista novoProdutor )
        throws ValorNuloException
    {
        if( Utils.isNull(novoProdutor) )
            throw new ValorNuloException("O produtor não pode ser nulo");
        this.produtor = novoProdutor;
    }

    public void cadastraCanditado( Musicista novoCandidato )
        throws ValorNuloException
    {
        if( novoCandidato == null){
            throw new ValorNuloException("O candidato não pode ser nulo.");
        }
        this.candidatos.add(novoCandidato);
    }
    public Musicista atualizaCandidato( long codMusicista, Musicista musicistaAtu )
            throws NomeInvalidoException, DataNascimentoInvalidaException, SexoInvalidoException,
            CandidatoInvalidoException, ValorNuloException, ContatoInvalidoException,
            FormatoContatoInadequadoException, MusicistaSemHabilidadeException, HabilidadeRepetidaException {
        Musicista musicistaDesatu = this.getMusicistaPorCodigo(codMusicista);

        if( Utils.isNull(musicistaDesatu))
            throw new CandidatoInvalidoException("O musicista de código " + codMusicista + " não está cadastrados");

        musicistaDesatu.setNome(musicistaAtu.getNome());
        musicistaDesatu.setFoto(musicistaAtu.getFoto());
        musicistaDesatu.setNascimento(musicistaAtu.getNascimento());
        musicistaDesatu.setSexo(musicistaAtu.getSexo());
        musicistaDesatu.setTextoApresent(musicistaAtu.getTextoApresent());

        for( var contato : musicistaDesatu.getContatos()){
            musicistaDesatu.deletaContato(contato.getTipo(), contato.getValor());
        }

        for( var contato : musicistaAtu.getContatos()){
            musicistaDesatu.adicionaContato(contato.getTipo(), contato.getValor());
        }

        for( var habilidade : musicistaDesatu.getHabilidades()){
            musicistaDesatu.deleteHabilidade(Habilidade.getHabilidade(habilidade));
        }

        for( var habilidade : musicistaAtu.getHabilidades()){
            musicistaDesatu.adicionaHabilidade(Habilidade.getHabilidade(habilidade));
        }
        return musicistaDesatu;
    }
    //Getters
    public long getCodProcesso() { return this.codProcesso;}
    public String getNomeBanda(){
        return this.nomeBanda;
    }
    public Musicista getProdutor(){
        return this.produtor;
    }
    public int getQtdCandidatos(){
        return this.candidatos.size();
    }
    public List<Musicista> getAllCandidatos(){
        return new ArrayList<Musicista>(this.candidatos);
    }
    public Musicista getMusicistaPorCodigo( long codMusicista ){
        for( Musicista musicita : this.candidatos ){
            if( musicita.getCodMusicista() == codMusicista )
                return musicita;
        }
        return null;
    }
    public List<Musicista> getMusicistaPorNome( String nome ){
        ArrayList<Musicista> resultado = new ArrayList<Musicista>();

        for( Musicista musicita : this.candidatos ){
            if( musicita.getNome().contains(nome))
                resultado.add((musicita));
        }
        return resultado;
    }
    public List<Musicista> getMusicistaPorHabilidade(Habilidade habilidade){
        ArrayList<Musicista> resultado = new ArrayList<Musicista>();

        for( Musicista musicita : this.candidatos ){
            for( String hab: musicita.getHabilidades() ){
                if( hab.equals(habilidade.toString()) )
                    resultado.add((musicita));
            }

        }
        return resultado;
    }

    public String toString(){
        String resultado = "";
            resultado += "Banda: " + this.getNomeBanda() + "\n" +
                         "Produtor: " + ( !Utils.isNull(this.produtor) ? ( "\n[" + "\n" + this.getProdutor() + "\n]" ) : "sem produtor" )+ "\n" +
                         "Quantidade candidatos: " + this.getQtdCandidatos() + "\n";

        return resultado;
    }

}
