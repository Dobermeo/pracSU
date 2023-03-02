CREATE TABLE IF NOT EXISTS invoice(
  id SERIAL,
  fecha DATE,
  total DECIMAL,
  PRIMARY KEY(id),
  client_id INT NOT NULL,
  FOREIGN KEY (client_id) REFERENCES client(id)
  );
