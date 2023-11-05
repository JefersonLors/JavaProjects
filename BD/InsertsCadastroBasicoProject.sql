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

INSERT INTO CANDIDATO ( nome, sexo, nascimento, textoapresentacao ) values
	('Carlos DeLucca', 1, current_date, 'Musico de igreja'),
	('Paulo Cezar', 1, current_date, 'Ex musico do Metalica'),
	('Maria Lucia', 2, current_date, '3 shows internacionais'),
	('Ana Kniss', 2, current_date, 'Multi instrumentista'),
	('Antonio Monte Negro', 1, current_date, 'Aprendiz de Kiko Loureiro'),
	('Lucio Pepino', 1, current_date, 'Rockeiro brabo demais'),
	('Larissa Barbosa', 2, current_date, 'O melhor de todos'),
	('Jane Quadro', 3, current_date, 'Pegada de pagodeiro'),
	('Gustavo Rock', 1, current_date, 'Outro musica de igreja')
;

INSERT INTO PRODUTOR ( nome, sexo, nascimento, produtora ) values 
	('Marcela Green Cardi', 2, current_date, 'A4Songs'),
	('Julio Horsey', 1, current_date, 'Som do Brasil')
;

INSERT INTO CANDIDATO_HABILIDADE (codCandidato, codHabilidade) values
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
;

INSERT INTO PRODUTOR_HABILIDADE (codProdutor, codHabilidade) values
	(1, 4),
	(2, 2)
;

INSERT INTO CANDIDATO_CONTATO (codCandidato, codTipoContato, descricao) values
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
	(9, 4, '(84) 98734-1215')
;

INSERT INTO PRODUTOR_CONTATO (codProdutor, codTipoContato, descricao) values
	(1, 5, 'Marcela.GreenCardi@gmail.com'),
	(1, 3, 'Marcela Green Cardi'),
	(2, 1, '@Julio.Horsey'),
	(2, 2, 'JulioHorsey')
;

INSERT INTO PROCESSO_SELETIVO ( produtor, nomeBanda) values
	(1, 'Canguru Bombado'),
	(1, 'Mamona Supapimbas')
;
	
	

	
