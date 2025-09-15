INSERT INTO cliente (nome, telefone, codigo, endreco)
VALUES ('Diogo José Varaschin de Oliveira', '41922223333', 'A001', 'Avenida Sete de Setembro 123');

INSERT INTO sanduiche (nome, preco)
VALUES ('x-tudo', 32.90), ('x-frango', 25.00);

INSERT INTO pedido (idCliente, statusLanche, dataEmissao)
VALUES (1, 0, CURDATE());

INSERT INTO pedidoSanduiche (idPedido, idSanduiche, quantidade)
VALUES (1, 1, 1) (1, 2, 1);

INSERT INTO entregador (nome, telefone)
VALUES ('Joao do grau', '11933334444');

INSERT INTO entregaPedido (idEntregador, idPedido)
VALUES (1, 1)