package model.enums;

public enum Habilidade {
	GUITARRA,
	BATERIA,
	VIOLAO,
	CONTRABAIXO,
	VOCAL,
	COMPOSICAO,
	TECLADO;

	public static Habilidade getHabilidade( String nomeHabilidade){
		if( nomeHabilidade.equalsIgnoreCase(GUITARRA.toString()))
			return GUITARRA;
		if( nomeHabilidade.equalsIgnoreCase(BATERIA.toString()))
			return BATERIA;
		if( nomeHabilidade.equalsIgnoreCase(VIOLAO.toString()))
			return VIOLAO;
		if( nomeHabilidade.equalsIgnoreCase(CONTRABAIXO.toString()))
			return CONTRABAIXO;
		if( nomeHabilidade.equalsIgnoreCase(VOCAL.toString()))
			return VOCAL;
		if( nomeHabilidade.equalsIgnoreCase(COMPOSICAO.toString()))
			return COMPOSICAO;
		if( nomeHabilidade.equalsIgnoreCase(TECLADO.toString()))
			return TECLADO;

		return null;
	}
}
