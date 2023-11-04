CREATE SEQUENCE sq_pk_codMusicista START 1;
CREATE SEQUENCE sq_pk_codSexo START 1;
CREATE SEQUENCE sq_pk_codHabilidade START 1;
CREATE SEQUENCE sq_pk_codTipoContato START 1;
CREATE SEQUENCE sq_pk_codProcSelet START 1;

CREATE TABLE SEXO(
	codSexo INT DEFAULT NEXTVAL('sq_pk_codSexo') NOT NULL,
	descricao VARCHAR(255) UNIQUE NOT NULL,
	CONSTRAINT pk_codSexo PRIMARY KEY (codSexo)
);

CREATE TABLE HABILIDADE(
	codHabilidade INT DEFAULT NEXTVAL('sq_pk_codHabilidade') NOT NULL,
	descricao VARCHAR(255) UNIQUE NOT NULL,
	CONSTRAINT pk_codHabilidade PRIMARY KEY (codHabilidade)
);

CREATE TABLE TIPO_CONTATO(
	codTipoContato INT DEFAULT NEXTVAL('sq_pk_codTipoContato') NOT NULL,
	descricao VARCHAR(255) UNIQUE NOT NULL,
	CONSTRAINT pk_codTipoContato PRIMARY KEY (codTipoContato)
);

CREATE TABLE MUSICISTA(
	codMusicista INT DEFAULT NEXTVAL('sq_pk_codMusicista') NOT NULL,
	nome VARCHAR(255) NOT NULL,
	sexo INT NOT NULL,
	nascimento DATE NOT NULL,
	CONSTRAINT pk_codMusicista PRIMARY KEY(codMusicista),
	CONSTRAINT fk_sexo FOREIGN KEY(SEXO) REFERENCES SEXO(codSexo)
);

CREATE TABLE PRODUTOR(
	codProdutor INT NOT NULL,
	produtora VARCHAR(255) NOT NULL,
	CONSTRAINT pk_codProdutor PRIMARY KEY(codProdutor),
	CONSTRAINT fk_codProdutor FOREIGN KEY(codProdutor) REFERENCES MUSICISTA (codMusicista)
);

CREATE TABLE CANDIDATO(
	codCandidato INT NOT NULL,
	textoApresentacao VARCHAR(255) NOT NULL,
	CONSTRAINT pk_codCandidato PRIMARY KEY(codCandidato),
	CONSTRAINT fk_codCandidato FOREIGN KEY(codCandidato) REFERENCES MUSICISTA (codMusicista)
);

CREATE TABLE PROCESSO_SELETIVO(
	codProcSelet INT DEFAULT NEXTVAL('sq_pk_codProcSelet') NOT NULL,
	produtor INT NOT NULL,
	nomeBanda VARCHAR(255) NOT NULL,
	CONSTRAINT fk_codProcSelet PRIMARY KEY(codProcSelet),
	UNIQUE ( produtor, nomeBanda )
);

CREATE TABLE MUSICISTA_HABILIDADE(
	codMusicista INT NOT NULL,
	codHabilidade INT NOT NULL,
	CONSTRAINT pk_musicistaHabilidade_codHabilidade_codMusicista PRIMARY KEY( codMusicista, codHabilidade),
	CONSTRAINT pk_musicistaHabilidade_codMusicista FOREIGN KEY( codMusicista ) REFERENCES MUSICISTA (codMusicista),
	CONSTRAINT pk_musicistaHabilidade_codHabilidade FOREIGN KEY( codHabilidade ) REFERENCES HABILIDADE (codHabilidade)
);

CREATE TABLE MUSICISTA_CONTATO(
	codMusicista INT NOT NULL,
	codTipoContato INT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	CONSTRAINT pk_musicistaContato_codMusicista FOREIGN KEY( codMusicista ) REFERENCES MUSICISTA (codMusicista),
	CONSTRAINT pk_musicistaContato_codTipoContato FOREIGN KEY( codTipoContato ) REFERENCES TIPO_CONTATO (codTipoContato)
); 

CREATE TABLE MUSICISTA_PROCESSO_SELETIVO(
	codMusicista INT NOT NULL,
	codProcSelet INT NOT NULL,
	CONSTRAINT pk_musicistaProcessoSeletivo_codMusicista FOREIGN KEY( codMusicista ) REFERENCES MUSICISTA (codMusicista),
	CONSTRAINT pk_musicistaProcessoSeletivo_codProcSelet FOREIGN KEY( codProcSelet ) REFERENCES PROCESSO_SELETIVO (codProcSelet)
);

-- drops

drop table MUSICISTA_PROCESSO_SELETIVO;
drop table MUISICISTA_CONTATO;
drop table MUSICISTA_HABILIDADE;
drop table PROCESSO_SELETIVO;
drop table CANDIDATO;
drop table musicista;
drop table MUSICISTA;
drop table TIPO_CONTATO;
drop table HABILIDADE;
drop table SEXO;

DROP SEQUENCE sq_pk_codMusicista;
DROP SEQUENCE sq_pk_codSexo; 
DROP SEQUENCE sq_pk_codHabilidade; 
DROP SEQUENCE sq_pk_codTipoContato;
DROP SEQUENCE sq_pk_codProcSeleT;