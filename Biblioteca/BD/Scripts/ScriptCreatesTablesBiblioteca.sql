create sequence seq_editora START 1; 


create table editora (
	cod_editora int not null default nextval ('seq_editora'),
	descricao varchar (30) null, 
	endereco varchar (30) null,
	constraint pk_editora primary key (cod_editora)
);

create sequence seq_livro START 1;

create table livro (
	cod_livro int not null default nextval ('seq_livro'),
	isbn varchar (20) null,
	titulo varchar (45) null,
	num_edicao int null,
	preco float null,
	cod_editora int not null,
	constraint pk_livro primary key (cod_livro),
	constraint fk_livro_editora foreign key (cod_editora) references editora (cod_editora)    
);


create sequence seq_autor START 1;

create table autor (
	cod_autor int not null default nextval ('seq_autor'),
	nome varchar (45) null,
	sexo char (1) null,
	data_nascimento date null,
	constraint pk_autor primary key (cod_autor)
);

create table livro_autor (
	cod_livro int not null,
	cod_autor int not null,
	constraint pk_livro_autor primary key (cod_livro, cod_autor),
	constraint fk_livro_autor_livro foreign key (cod_livro)references livro (cod_livro),
	constraint fk_livro_autor_autor foreign key (cod_autor) references autor (cod_autor)      
);


