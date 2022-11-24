create database banco_de_usuarios;

use banco_de_usuarios;

create table usuario(
 id integer auto_increment primary key,
 nome varchar(200) not null,
 email varchar(50) not null,
 senha text not null,
 telefone varchar(15) not null
);

#ALTER TABLE usuario MODIFY COLUMN email varchar(50) not null;

insert into usuario values (null, 'eni','eni@hotmail.com', '123456', '119330204565');

select * from usuario;

SELECT * FROM banco_de_usuarios.usuario;