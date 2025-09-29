SELECT
	c.Nome AS Nome_Cliente,
    c.Cidade AS Cidade_Cliente,
    o.id AS Order_ID,
    o.date AS Data_Order
FROM
	Cliente c
INNER JOIN
	Order o
ON
	c.id = o.Cliente_id;