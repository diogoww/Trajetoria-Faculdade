CREATE TABLE cliente (
	idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    telefone VARCHAR(20),
    codigo VARCHAR(20),
    endereco VARCHAR(200)
);

CREATE TABLE sanduiche (
	idSanduiche INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    preco DECIMAL(8,2) NOT NULL
);

CREATE TABLE pedido (
	idPedido INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT,
    status TINYINT NOT NULL,
    dataEmissao DATE,
    FOREIGN KEY (idCliente) REFERENCES cliente(idCliente)
);

CREATE TABLE pedidoSanduiche(
	idPedido INT,
    idSanduiche INT,
    quantidade INT NOT NULL,
    PRIMARY KEY (idPedido, idSanduiche),
    FOREIGN KEY (idPedido) REFERENCES pedido(idPedido),
    FOREIGN KEY (idSanduiche) REFERENCES sanduiche(idSanduiche)
);

CREATE TABLE entregador(
	idEntregador INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    telefone VARCHAR(20)
);

CREATE TABLE entregaPedido(
	idEntregador INT,
    idPedido INT,
    PRIMARY KEY (idEntregador, idPedido),
    FOREIGN KEY (idEntregador) REFERENCES entregador(idEntregador),
    FOREIGN KEY (idPedido) REFERENCES pedido(idPedido)
);