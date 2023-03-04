CREATE TABLE IF NOT EXISTS teacher(
  id SERIAL,
  fullname VARCHAR(100) NOT NULL,
  email VARCHAR(50),
  phone INT,
  PRIMARY KEY(id)
  );
