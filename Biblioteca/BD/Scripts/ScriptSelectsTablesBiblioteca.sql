SELECT *
FROM autor
;

SELECT *
FROM editora
;

SELECT *
FROM livro
;

SELECT *
FROM livro_autor
;

SELECT l.cod_livro, l.isbn, titulo, l.num_edicao, l.preco, l.cod_editora, a.cod_autor, a.nome, a.sexo
FROM livro_autor la
	LEFT JOIN livro l ON (la.cod_livro = l.cod_livro)
	LEFT JOIN autor a on (la.cod_autor = a.cod_autor)
ORDER BY isbn
;