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
DROP TABLE charts CASCADE CONSTRAINTS
/
DROP TABLE chart_movie_assoc CASCADE CONSTRAINTS
/
DROP SEQUENCE movie_seq
/
DROP SEQUENCE actor_seq
/
DROP SEQUENCE director_seq
/
DROP SEQUENCE genre_seq
/
DROP SEQUENCE chart_seq
/


CREATE TABLE movies(
  id_movie NUMBER(5) NOT NULL PRIMARY KEY,
  title VARCHAR2(200),
  release_date DATE,
  duration INTERVAL DAY TO SECOND,
  score NUMBER(2) CHECK (score BETWEEN 1 and 10)
  )
/


CREATE TABLE genres(
  id_genre NUMBER(5) NOT NULL PRIMARY KEY,
  name VARCHAR2(15)
  )
/

CREATE TABLE movie_genre_assoc(
  id_movie NUMBER(5) NOT NULL,
  id_genre NUMBER(5) NOT NULL,
  CONSTRAINT fk_id_movie FOREIGN KEY (id_movie) REFERENCES movies(id_movie) ON DELETE CASCADE,
  CONSTRAINT fk_id_genre FOREIGN KEY (id_genre) REFERENCES genres(id_genre) ON DELETE CASCADE
  )
/

CREATE TABLE actors(
  id_actor NUMBER(5) NOT NULL PRIMARY KEY,
  name VARCHAR2(100)
)
/

CREATE TABLE directors(
  id_director NUMBER(5) NOT NULL PRIMARY KEY,
  name VARCHAR2(100)
)
/

CREATE TABLE charts(
  id_chart NUMBER(5) NOT NULL PRIMARY KEY,
  name VARCHAR2(30),
  creation_date DATE
)
/

CREATE TABLE chart_movie_assoc(
  id_chart NUMBER(5) NOT NULL, 
  id_movie NUMBER(5) NOT NULL,
  CONSTRAINT fk_id_chart FOREIGN KEY (id_chart) REFERENCES charts(id_chart) ON DELETE CASCADE,
  CONSTRAINT fk_id_movie4 FOREIGN KEY (id_movie) REFERENCES movies(id_movie) ON DELETE CASCADE
  )
/

CREATE TABLE actor_movie_assoc(
  id_actor NUMBER(5) NOT NULL,
  id_movie NUMBER(5) NOT NULL,
  CONSTRAINT fk_id_actor FOREIGN KEY (id_actor) REFERENCES actors(id_actor) ON DELETE CASCADE,
  CONSTRAINT fk_id_movie2 FOREIGN KEY (id_movie) REFERENCES movies(id_movie) ON DELETE CASCADE
)
/

CREATE TABLE director_movie_assoc(
  id_director NUMBER(5) NOT NULL,
  id_movie NUMBER(5) NOT NULL,
  CONSTRAINT fk_id_director FOREIGN KEY (id_director) REFERENCES directors(id_director) ON DELETE CASCADE,
  CONSTRAINT fk_id_movie3 FOREIGN KEY (id_movie) REFERENCES movies(id_movie) ON DELETE CASCADE
)
/

CREATE SEQUENCE movie_seq START WITH 1;
CREATE SEQUENCE genre_seq START WITH 1;
CREATE SEQUENCE actor_seq START WITH 1;
CREATE SEQUENCE director_seq START WITH 1;
CREATE SEQUENCE chart_seq START WITH 1;

INSERT INTO movies VALUES (movie_seq.NEXTVAL, 'Airplane', TO_DATE('02/07/1980', 'dd/mm/yyyy'), INTERVAL '1:28' HOUR TO MINUTE, 6 );
INSERT INTO movies VALUES (movie_seq.NEXTVAL, 'The Father', TO_DATE('26/02/2021', 'dd/mm/yyyy'), INTERVAL '1:37' HOUR TO MINUTE, 8);
INSERT INTO movies VALUES (movie_seq.NEXTVAL, 'Pulp Fiction', TO_DATE('14/10/1994', 'dd/mm/yyyy'), INTERVAL '2:34' HOUR TO MINUTE, 9);

INSERT INTO charts VALUES (chart_seq.NEXTVAL, 'Best movies', TO_DATE('02/07/2013', 'dd/mm/yyyy'));
INSERT INTO charts VALUES (chart_seq.NEXTVAL, 'Boring movies', TO_DATE('03/05/2017', 'dd/mm/yyyy'));

INSERT INTO chart_movie_assoc VALUES(1,2);
INSERT INTO chart_movie_assoc VALUES(2,1);
INSERT INTO chart_movie_assoc VALUES(1,1);
INSERT INTO chart_movie_assoc VALUES(1,3);
INSERT INTO chart_movie_assoc VALUES(2,3);

INSERT INTO genres VALUES (genre_seq.NEXTVAL, 'Drama');
INSERT INTO genres VALUES (genre_seq.NEXTVAL, 'Comedy');
INSERT INTO genres VALUES (genre_seq.NEXTVAL, 'Action');

INSERT INTO movie_genre_assoc VALUES (1,2);
INSERT INTO movie_genre_assoc VALUES (2,1);
INSERT INTO movie_genre_assoc VALUES (3,3);

INSERT INTO actors VALUES(actor_seq.NEXTVAL, 'John Travolta');
INSERT INTO actors VALUES(actor_seq.NEXTVAL, 'Leslie Nielsen');
INSERT INTO actors VALUES(actor_seq.NEXTVAL, 'Robert Hays');
INSERT INTO actors VALUES(actor_seq.NEXTVAL, 'Olivia Colman');

INSERT INTO directors VALUES(director_seq.NEXTVAL, 'David Zucker');
INSERT INTO directors VALUES(director_seq.NEXTVAL, 'Jim Abrahams');
INSERT INTO directors VALUES(director_seq.NEXTVAL, 'Florian Zeller');
INSERT INTO directors VALUES(director_seq.NEXTVAL, 'Quentin Tarantino');

INSERT INTO actor_movie_assoc VALUES(1, 3);
INSERT INTO actor_movie_assoc VALUES(2, 1);
INSERT INTO actor_movie_assoc VALUES(3, 1);
INSERT INTO actor_movie_assoc VALUES(4, 2);

INSERT INTO director_movie_assoc VALUES(1, 1);
INSERT INTO director_movie_assoc VALUES(2, 1);
INSERT INTO director_movie_assoc VALUES(3, 2);
INSERT INTO director_movie_assoc VALUES(4, 3);