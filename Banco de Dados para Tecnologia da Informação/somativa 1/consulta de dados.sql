SELECT p.idPedido, c.nome AS cliente, p.dataEmissao, p.statusLanche
FROM pedido p
JOIN cliente c ON p.idCliente = c.idCliente
WHERE p.statusLanche = 0;