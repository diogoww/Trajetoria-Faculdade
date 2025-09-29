CREATE DATABASE IF NOT EXISTS DBLojaVinho;
USE DBLojaVinho;

CREATE TABLE Regiao(
	codRegiao bigint auto_increment primary key,
    nomeRegiao varchar(100) not null,
    descricaoRegiao text
);

CREATE TABLE Vinicola(
	codVinicola bigint auto_increment primary key,
    nomeVinicola varchar(100) not null,
    descricaoVinicola text, 
    foneVinicola varchar(15),
    emailVinicola varchar(15),
    codRegiao bigint,
    foreign key (codRegiao) references Regiao(codRegiao)
);

CREATE TABLE Vinho(
	codVinho bigint auto_increment primary key,
    nomeVinho varchar(50) not null,
    tipoVinho varchar(30) not null,
    anoVinho int not null,
    descricaoVinho text,
    codVinicola bigint,
    foreign key (codVinicola) references Vinicola(codVinicola)
);

INSERT INTO Regiao (nomeRegiao, descricaoRegiao) VALUES
('Carlopolis Parana', 'produtores de vinhos em carlopolis pr'),
('Caminho do Vinho', 'Area produtora de vinhos na regiao metropolitana de curitiba'),
('Serra gaucha', 'regiao produtora de vinhos no RS'),
('planalto catarinense', 'regiao produtora de vinho em SC'),
('vale do sao francisco', 'regiao produtora de vinho no nordeste');

INSERT INTO Vinicola (nomeVinicola, descricaoVinicola, foneVinicola, emailVinicola, codRegiao) VALUES
('vinicola oliveira', 'vinicola grande no interior do pr', '43911112222', 'oliveira@com', 1),
('vinicola lionel messi', 'a vinicola do lionel messi', '41911112222', 'messi@com', 2),
('vinicola ronaldinho gaucho', 'a vinicola do ronaldinho gaucho', '54911112222', 'ronaldinho@com', 3),
('vinicola ronaldo fenomeno', 'a vinicola do ronaldo fenomeno', '14911112222', 'ronaldo@com', 4),
('vinicola bebeto e romário', 'a vinicola do bebeto e romario', '21911112222', 'bbt@rmr.com', 5);

INSERT INTO Vinho (nomeVinho, tipoVinho, anoVinho, descricaoVinho, codVinicola) VALUES
('Oliveira Reservado', 'tinto', 1999, 'o melhor vinho do parana', 1),
('Lionel RESERVADO Messi', 'branco', 1987, 'o vinho prefeiro do messi', 2),
('Ronaldinho Bola de Ouro', 'Rose', 2005, 'vinho campeao da bola de ouro', 3),
('Ronaldo Cascao', 'seco', 2002, 'ronaldo fenomeno ganhou a copa e bebeu ele', 4),
('Bebeto 1994 Romario', 'tinto', 1994, 'campeao copa do vinho', 5);

SELECT
	v.nomeVinho,
    v.anoVinho,
    vi.nomeVinicola,
    r.nomeRegiao
FROM Vinho v
JOIN Vinicola vi ON v.codVinicola = vi.codVinicola
JOIN Regiao r ON vi.codRegiao = r.codRegiao;

CREATE USER 'sommelier'@'localhost' IDENTIFIED BY 'sommelier1234';
GRANT SELECT ON DBLojaVinho.Vinho TO 'sommelier'@'localhost';
GRANT SELECT (codVinicola, nomeVinicola) ON DBLojaVinho.Vinicola TO 'sommelier'@'localhost';

ALTER USER 'sommelier'@'localhost'
WITH max_queries_per_hour 40;

FLUSH PRIVILEGES;