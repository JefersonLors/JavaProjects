-- create sequences
CREATE SEQUENCE sq_pk_codCandidato START 1;
CREATE SEQUENCE sq_pk_codProdutor START 1;
CREATE SEQUENCE sq_pk_codSexo START 1;
CREATE SEQUENCE sq_pk_codHabilidade START 1;
CREATE SEQUENCE sq_pk_codTipoContato START 1;
CREATE SEQUENCE sq_pk_codProcSelet START 1;

-- create tables

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

CREATE TABLE CANDIDATO(
	codCandidato INT DEFAULT NEXTVAL('sq_pk_codCandidato') NOT NULL,
	nome VARCHAR(255) NOT NULL,
	sexo INT NOT NULL,
	nascimento DATE NOT NULL,
	textoApresentacao VARCHAR(255) NOT NULL,
	CONSTRAINT pk_codCandidato PRIMARY KEY(codCandidato),
	CONSTRAINT fk_candidato_sexo FOREIGN KEY (sexo) REFERENCES SEXO (codSexo )
);

CREATE TABLE PRODUTOR(
	codProdutor INT DEFAULT NEXTVAL('sq_pk_codProdutor') NOT NULL,
	nome VARCHAR(255) NOT NULL,
	sexo INT NOT NULL,
	nascimento DATE NOT NULL,
	produtora VARCHAR(255) NOT NULL,
	CONSTRAINT pk_codProdutor PRIMARY KEY(codProdutor),
	CONSTRAINT fk_produtor_sexo FOREIGN KEY (sexo) REFERENCES SEXO (codSexo )
);

CREATE TABLE CANDIDATO_HABILIDADE(
	codCandidato INT NOT NULL,
	codHabilidade INT NOT NULL,
	CONSTRAINT pk_candidatoHabilidade_codHabilidade_codcandidato PRIMARY KEY( codCandidato, codHabilidade),
	CONSTRAINT fk_candidatoHabilidade_codHabilidade FOREIGN KEY( codHabilidade ) REFERENCES HABILIDADE (codHabilidade),
	CONSTRAINT fk_candidatoHabilidade_codCandidato FOREIGN KEY( codCandidato ) REFERENCES CANDIDATO (codCandidato)
);

CREATE TABLE PRODUTOR_HABILIDADE(
	codProdutor INT NOT NULL,
	codHabilidade INT NOT NULL,
	CONSTRAINT pk_produtorHabilidade_codHabilidade_codProdutor PRIMARY KEY( codProdutor, codHabilidade),
	CONSTRAINT fk_produtorHabilidade_codHabilidade FOREIGN KEY( codHabilidade ) REFERENCES HABILIDADE (codHabilidade),
	CONSTRAINT fk_produtorHabilidade_codProdutor FOREIGN KEY( codProdutor ) REFERENCES PRODUTOR (codProdutor)
);

CREATE TABLE CANDIDATO_CONTATO(
	codCandidato INT NOT NULL,
	codTipoContato INT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	CONSTRAINT pk_candidatoContato_codCandidato_codTipoContato_descricao PRIMARY KEY ( codCandidato, codTipoContato, descricao ),
	CONSTRAINT fk_candidatoContato_codCandidato FOREIGN KEY( codCandidato ) REFERENCES CANDIDATO (codCandidato),
	CONSTRAINT fk_candidatoTipoContato_codTipoContato FOREIGN KEY( codTipoContato ) REFERENCES TIPO_CONTATO (codTipoContato)
); 

CREATE TABLE PRODUTOR_CONTATO(
	codProdutor INT NOT NULL,
	codTipoContato INT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	CONSTRAINT pk_produtorContato_codProdutor_codTipoContato_descricao PRIMARY KEY ( codProdutor, codTipoContato, descricao ),
	CONSTRAINT fk_produtorContato_codProdutor FOREIGN KEY( codProdutor ) REFERENCES PRODUTOR (codProdutor),
	CONSTRAINT pk_produtorTipoContato_codTipoContato FOREIGN KEY( codTipoContato ) REFERENCES TIPO_CONTATO (codTipoContato)
); 

CREATE TABLE PROCESSO_SELETIVO(
	codProcSelet INT DEFAULT NEXTVAL('sq_pk_codProcSelet') NOT NULL,
	produtor INT NOT NULL,
	nomeBanda VARCHAR(255) NOT NULL,
	CONSTRAINT fk_codProcSelet PRIMARY KEY(codProcSelet),
	UNIQUE ( produtor, nomeBanda )
);

CREATE TABLE CANDIDATO_PROCESSO_SELETIVO(
	codCandidato INT NOT NULL,
	codProcSelet INT NOT NULL,
	CONSTRAINT pk_candidatoProcessoSeletivo_codCandidato_codProcessoSeletivo PRIMARY KEY(codCandidato, codProcSelet),
	CONSTRAINT fk_candidatoProcessoSeletivo_codCandidato FOREIGN KEY( codCandidato ) REFERENCES CANDIDATO (codCandidato),
	CONSTRAINT pk_musicistaProcessoSeletivo_codProcSelet FOREIGN KEY( codProcSelet ) REFERENCES PROCESSO_SELETIVO (codProcSelet)
);

-- drop tables

drop table CANDIDATO_PROCESSO_SELETIVO;
drop table PRODUTOR_CONTATO;
drop table CANDIDATO_CONTATO;
drop table PRODUTOR_HABILIDADE;
drop table CANDIDATO_HABILIDADE;
drop table PROCESSO_SELETIVO;
drop table CANDIDATO;
drop table PRODUTOR;
drop table TIPO_CONTATO;
drop table HABILIDADE;
drop table SEXO;

-- drop sequences

drop sequence sq_pk_codCandidato;
drop sequence sq_pk_codProdutor;
drop sequence sq_pk_codSexo;
drop sequence sq_pk_codHabilidade;
drop sequence sq_pk_codTipoContato;
drop sequence sq_pk_codProcSelet;