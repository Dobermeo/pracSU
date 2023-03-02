CREATE VIEW invoice_view AS
SELECT i.*, c.fullname client
FROM invoice i
       INNER JOIN client c ON i.client_id = c.id;
