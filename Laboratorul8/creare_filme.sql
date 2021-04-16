DROP TABLE movies
/
DROP TABLE genres
/
DROP TABLE movie_genre_assoc
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
  CONSTRAINT fk_id_movie FOREIGN KEY (id_movie) REFERENCES movies(id_movie),
  CONSTRAINT fk_id_genre FOREIGN KEY (id_genre) REFERENCES genres(id_genre)
  )
/

INSERT INTO movies VALUES (1, 'Airplane', TO_DATE('02/07/1980', 'dd/mm/yyyy'), INTERVAL '0 1:28:00' DAY TO SECOND, 6 );
INSERT INTO movies VALUES (2, 'The Father', TO_DATE('26/02/2021', 'dd/mm/yyyy'), INTERVAL '0 1:37:00' DAY TO SECOND, 8);
INSERT INTO movies VALUES (3, 'Pulp Fiction', TO_DATE('14/10/1994', 'dd/mm/yyyy'), INTERVAL '0 2:34:00' DAY TO SECOND, 9);

INSERT INTO genres VALUES (1, 'Drama');
INSERT INTO genres VALUES (2, 'Comedie');
INSERT INTO genres VALUES (3, 'Actiune');

INSERT INTO movie_genre_assoc VALUES (1,2);
INSERT INTO movie_genre_assoc VALUES (2,1);
INSERT INTO movie_genre_assoc VALUES (3,3);