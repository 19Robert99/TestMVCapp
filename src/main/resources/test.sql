CREATE USER robert IDENTIFIED BY p1234;

GRANT CONNECT, RESOURCE TO robert;

CONNECT robert/p1234;

CREATE TABLE Users (
  id_user NUMERIC PRIMARY KEY,
  first_name VARCHAR(45) NOT NULL,
  age NUMERIC NOT NULL);

COMMIT;

INSERT INTO	Users (id_user, first_name, age) VALUES	(1, 'Robert',19);
INSERT INTO	Users (id_user, first_name, age) VALUES	(2, 'Nick', 23);
INSERT INTO	Users (id_user, first_name, age) VALUES	(3, 'Vlad', 21);

COMMIT ;