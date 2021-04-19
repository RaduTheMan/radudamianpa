DROP TABLE movies CASCADE CONSTRAINTS
/
DROP TABLE genres CASCADE CONSTRAINTS
/
DROP TABLE movie_genre_assoc CASCADE CONSTRAINTS
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

INSERT INTO movies VALUES (1, 'Airplanee', TO_DATE('02/07/1980', 'dd/mm/yyyy'), INTERVAL '1:28' HOUR TO MINUTE, 6 );
INSERT INTO movies VALUES (2, 'The Father', TO_DATE('26/02/2021', 'dd/mm/yyyy'), INTERVAL '1:37' HOUR TO MINUTE, 8);
INSERT INTO movies VALUES (3, 'Pulp Fiction', TO_DATE('14/10/1994', 'dd/mm/yyyy'), INTERVAL '2:34' HOUR TO MINUTE, 9);

INSERT INTO genres VALUES (1, 'Drama');
INSERT INTO genres VALUES (2, 'Comedie');
INSERT INTO genres VALUES (3, 'Actiune');

INSERT INTO movie_genre_assoc VALUES (1,2);
INSERT INTO movie_genre_assoc VALUES (2,1);
INSERT INTO movie_genre_assoc VALUES (3,3);

UPDATE
  movies
SET
  title = 'ceva',
  release_date = TO_DATE('2018/12/10', 'yyyy/mm/dd'),
  duration = INTERVAL '1:50' HOUR TO MINUTE,
  score = 2
WHERE
  id_movie = 1;