-- selects básicos
SELECT * 
FROM SEXO;

SELECT*
FROM HABILIDADE;

SELECT*
FROM TIPO_CONTATO;

SELECT*
FROM CANDIDATO;

SELECT*
FROM PRODUTOR;

SELECT*
FROM CANDIDATO_HABILIDADE;

SELECT*
FROM PRODUTOR_HABILIDADE;

SELECT*
FROM CANDIDATO_CONTATO;

SELECT*
FROM PRODUTOR_CONTATO;

SELECT*
FROM PROCESSO_SELETIVO;

-- selects compostos

SELECT c.codCandidato, s.descricao as sexo, c.nome, c.nascimento,
	   c.textoapresentacao, h.descricao as habilidade
FROM CANDIDATO c LEFT JOIN SEXO s ON ( c.sexo = s.codSexo ) 
				 LEFT JOIN CANDIDATO_HABILIDADE ch ON (c.codCandidato = ch.codCandidato) 
				 LEFT JOIN HABILIDADE h ON ( ch.codHabilidade = h.codHabilidade);
				 
SELECT c.codProdutor, s.descricao as sexo, c.nome, c.nascimento,
	   c.produtora, h.descricao as habilidade
FROM PRODUTOR c LEFT JOIN SEXO s ON ( c.sexo = s.codSexo ) 
				 LEFT JOIN PRODUTOR_HABILIDADE ch ON (c.codProdutor = ch.codProdutor) 
				 LEFT JOIN HABILIDADE h ON ( ch.codHabilidade = h.codHabilidade);				 
				 