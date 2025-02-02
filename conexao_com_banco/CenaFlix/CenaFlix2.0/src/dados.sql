create database cenaflix2;

use cenaflix2;

create table usuario(

id int auto_increment primary key,
login varchar(100),
senha text,
tipo varchar(30)
);

insert into usuario(login, senha, tipo) value('bruno', md5(123), 'admin'),
											 ('sheila', md5(123), 'operador'),
											 ('daniel', md5(123), 'usuario');
                                             
select * from filmes;

create table podcast(

id int auto_increment primary key,
produtor varchar(45),
nomeEpisodio varchar(45),
numeroEpisodio varchar(45),
duracao varchar(45),
url varchar(45) 
);

select * from podcast;
