DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  login VARCHAR(250),
  pass VARCHAR(250) NOT NULL,
  role VARCHAR(250) NOT NULL
);

INSERT INTO users(name, login, pass, role) VALUES
("ESSAIDI", "FlyNard", "CiNNaMoN212", "ADMIN,EDIT,USER"),
("SAID", "azerty", "azerty", "EDIT,USER"),
("FARID", "qwerty", "qwerty", "USER");
