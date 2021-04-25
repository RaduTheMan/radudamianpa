DROP TABLE movies CASCADE CONSTRAINTS
/
DROP TABLE genres CASCADE CONSTRAINTS
/
DROP TABLE movie_genre_assoc CASCADE CONSTRAINTS
/
DROP TABLE actors CASCADE CONSTRAINTS
/
DROP TABLE directors CASCADE CONSTRAINTS
/
DROP TABLE actor_movie_assoc CASCADE CONSTRAINTS
/
DROP TABLE director_movie_assoc CASCADE CONSTRAINTS
/

CREATE TABLE movies(
  id_movie NUMBER(4) NOT NULL PRIMARY KEY,
  title VARCHAR2(15),
  release_date DATE,
  duration INTERVAL DAY TO SECOND,
  score NUMBER(2) CHECK (score BETWEEN 1 and 10)
  )
/


CREATE TABLE genres(
  id_genre NUMBER(4) NOT NULL PRIMARY KEY,
  name VARCHAR2(15)
  )
/

CREATE TABLE movie_genre_assoc(
  id_movie NUMBER(4) NOT NULL,
  id_genre NUMBER(4) NOT NULL,
  CONSTRAINT fk_id_movie FOREIGN KEY (id_movie) REFERENCES movies(id_movie) ON DELETE CASCADE,
  CONSTRAINT fk_id_genre FOREIGN KEY (id_genre) REFERENCES genres(id_genre) ON DELETE CASCADE
  )
/

CREATE TABLE actors(
  id_actor NUMBER(4) NOT NULL PRIMARY KEY,
  name VARCHAR2(30)
)
/

CREATE TABLE directors(
  id_director NUMBER(4) NOT NULL PRIMARY KEY,
  name VARCHAR2(30)
)
/

CREATE TABLE actor_movie_assoc(
  id_actor NUMBER(4) NOT NULL,
  id_movie NUMBER(4) NOT NULL,
  CONSTRAINT fk_id_actor FOREIGN KEY (id_actor) REFERENCES actors(id_actor) ON DELETE CASCADE,
  CONSTRAINT fk_id_movie2 FOREIGN KEY (id_movie) REFERENCES movies(id_movie) ON DELETE CASCADE
)
/

CREATE TABLE director_movie_assoc(
  id_director NUMBER(4) NOT NULL,
  id_movie NUMBER(4) NOT NULL,
  CONSTRAINT fk_id_director FOREIGN KEY (id_director) REFERENCES directors(id_director) ON DELETE CASCADE,
  CONSTRAINT fk_id_movie3 FOREIGN KEY (id_movie) REFERENCES movies(id_movie) ON DELETE CASCADE
)
/

INSERT INTO movies VALUES (1, 'Airplane', TO_DATE('02/07/1980', 'dd/mm/yyyy'), INTERVAL '1:28' HOUR TO MINUTE, 6 );
INSERT INTO movies VALUES (2, 'The Father', TO_DATE('26/02/2021', 'dd/mm/yyyy'), INTERVAL '1:37' HOUR TO MINUTE, 8);
INSERT INTO movies VALUES (3, 'Pulp Fiction', TO_DATE('14/10/1994', 'dd/mm/yyyy'), INTERVAL '2:34' HOUR TO MINUTE, 9);

INSERT INTO genres VALUES (1, 'Drama');
INSERT INTO genres VALUES (2, 'Comedie');
INSERT INTO genres VALUES (3, 'Actiune');

INSERT INTO movie_genre_assoc VALUES (1,2);
INSERT INTO movie_genre_assoc VALUES (2,1);
INSERT INTO movie_genre_assoc VALUES (3,3);

INSERT INTO actors VALUES(1, 'John Travolta');
INSERT INTO actors VALUES(2, 'Leslie Nielsen');
INSERT INTO actors VALUES(3, 'Robert Hays');
INSERT INTO actors VALUES(4, 'Olivia Colman');

INSERT INTO directors VALUES(1, 'David Zucker');
INSERT INTO directors VALUES(2, 'Jim Abrahams');
INSERT INTO directors VALUES(3, 'Florian Zeller');
INSERT INTO directors VALUES(4, 'Quentin Tarantino');

INSERT INTO actor_movie_assoc VALUES(1, 3);
INSERT INTO actor_movie_assoc VALUES(2, 1);
INSERT INTO actor_movie_assoc VALUES(3, 1);
INSERT INTO actor_movie_assoc VALUES(4, 2);

INSERT INTO director_movie_assoc VALUES(1, 1);
INSERT INTO director_movie_assoc VALUES(2, 1);
INSERT INTO director_movie_assoc VALUES(3, 2);
INSERT INTO director_movie_assoc VALUES(4, 3);