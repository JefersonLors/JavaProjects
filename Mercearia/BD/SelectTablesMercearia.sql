SELECT*
FROM PRODUTOS;

SELECT*
FROM VENDAS

SELECT V.id as codigoVenda, p.nome, p.preco, v.quantidade, TRUNC((p.preco*v.quantidade), '2') as total
FROM VENDAS V LEFT JOIN PRODUTOS P
	ON ( V.idProduto = P.id)
;