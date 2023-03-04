CREATE TABLE IF NOT EXISTS subject(
  id SERIAL,
  description VARCHAR(500),
  course INT,
  PRIMARY KEY(id),
  teacher_id INT NOT NULL,
  FOREIGN KEY (teacher_id) REFERENCES teacher(id)
  );
