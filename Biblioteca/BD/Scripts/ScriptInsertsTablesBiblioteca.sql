insert into editora 
         (descricao, endereco)
  values 
         ('campus', 'rua do timbó'),
         ('abril', null), 
         ('editora teste', null);

insert into livro
    (isbn, titulo, num_edicao, preco, cod_editora)
 values
    ('12345', 'banco de dados', 3, 70.00, 1),
    ('35790', 'sgbd', 1, 85.00, 2),
    ('98765', 'redes de computadores', 2, 80.00,2);

insert into autor 
   (nome, sexo, data_nascimento)
 values
   ('João', 'M', '1970/01/01'),
   ('Maria', 'F', '1974/05/17'),
   ('José', 'M', '1977/10/10'),
   ('Carla', 'F', '1964/12/08');

insert into livro_autor 
    (cod_livro, cod_autor)
 values 
 	(1, 1), (1,2), (2, 2), (2,4), (3,3);