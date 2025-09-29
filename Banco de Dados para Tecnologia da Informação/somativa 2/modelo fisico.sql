CREATE DATABASE DBLojaVinho;
USE DBLojaVinho;

CREATE TABLE Vinicola(
	codVinicola bigint auto_increment primary key,
    nomeVinicola varchar(100) not null,
    descricaoVinicola text, 
    foneVinicola varchar(15),
    emailVinicola varchar(15),
    foreign key (codRegiao) references Regiao(codRegiao)
);

CREATE TABLE Regiao(
	codRegiao bigint auto_increment primary key,
    nomeRegiao varchar(100) not null,
    descricaoRegiao text
);

CREATE TABLE Vinho(
	codVinho bigint auto_increment primary key,
    nomeVinho varchar(50) not null,
    tipoVinho varchar(30) not null,
    anoVinho int not null,
    descricaoVinho text,
    foreign key (codVinicola) references Vinicola(codVinicola)
);