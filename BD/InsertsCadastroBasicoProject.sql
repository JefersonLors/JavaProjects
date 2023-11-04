INSERT INTO SEXO( descricao ) values
	('MASCULINO'), 
	('FEMININO'), 
	('OUTRO')
;
	
INSERT INTO HABILIDADE( descricao ) values
	('GUITARRA'),
	('BATERIA'),
	('VIOLAO'),
	('CONTRA-BAIXO'),
	('VOCAL'),
	('COMPOSICAO'),
	('TECLADO')
;

INSERT INTO TIPO_CONTATO (descricao) values
	('INSTAGRAM'),
	('LINKEDIN'),
	('FACEBOOK'),
	('WHTASAPP'),
	('EMAIL')
;

INSERT INTO MUSICISTA ( nome, sexo, nascimento ) values
	('Carlos DeLucca', 1, current_date),
	('Paulo Cezar', 1, current_date),
	('Maria Lucia', 2, current_date),
	('Ana Kniss', 2, current_date),
	('Antonio Monte Negro', 1, current_date),
	('Lucio Pepino', 1, current_date),
	('Larissa Barbosa', 2, current_date),
	('Jane Quadro', 3, current_date),
	('Gustavo Rock', 1, current_date),
	('Marcela Green Cardi', 2, current_date),
	('Julio Horsey', 1, current_date)
;

INSERT INTO CANDIDATO ( codcandidato, textoapresentacao) values 
	(1, 'Musico de igreja'),
	(2, 'Ex musico do Metalica'),
	(3, '3 shows internacionais'),
	(4, 'Multi instrumentista'),
	(5, 'Aprendiz de Kiko Loureiro'),
	(6, 'Rockeiro brabo demais'),
	(7, 'O melhor de todos'),
	(8, 'Pegada de pagodeiro'),
	(9, 'Outro musica de igreja')
;

INSERT INTO PRODUTOR (codprodutor, produtora) values 
	(10, 'A4Songs'),
	(11, 'Som do Brasil')
;

INSERT INTO PROCESSO_SELETIVO ( produtor, nomeBanda) values
	(10, 'Canguru Bombado'),
	(11, 'Mamona Supapimbas')
;

INSERT INTO MUSICISTA_HABILIDADE (codmusicista, codhabilidade) values
	(1, 1),
	(1, 2),
	(3, 1),
	(3, 2),
	(7, 4),
	(5, 3),
	(6, 6),
	(6, 1),
	(4, 4),
	(4, 2),
	(2, 2),
	(2, 6),
	(5, 1),
	(9, 5),
	(8, 3),
	(10, 4),
	(11, 2)
;

INSERT INTO MUSICISTA_CONTATO (codMusicista, codTipoContato, descricao) values
	(1, 1, '@Carlos_DeLucca'),
	(1, 5, 'Carlos.DeLucca@gmail.com'),
	(2, 4,'(41) 99237-0239'),
	(2, 5,'PauloCezar1023@gmail.com'),
	(3, 3, 'MaLu'),
	(3, 2, 'MariaLucia'),
	(4, 4, '(84) 98273-8254'),
	(4, 1, '@AKniss'),
	(5, 3, 'Antonio Monte Negro'),
	(5, 1, '@AntonioMonteNegro'),
	(6, 4, '(92) 99932-8531'),
	(6, 5, 'LucioPepino181@outlook.com'),
	(7, 5, '_LarissaBarbosa@outlook.com'),
	(7, 2, 'Larissa Barbosa'),
	(8, 1, '@JaneQuadro'),
	(8, 2, 'JaneQuadro'),
	(9, 3, 'Gustavo Rock'),
	(9, 4, '(84) 98734-1215'),
	(10, 5, 'Marcela.GreenCardi@gmail.com'),
	(10, 3, 'Marcela Green Cardi'),
	(11, 1, '@Julio.Horsey'),
	(11, 2, 'JulioHorsey')
;
	
	

	
