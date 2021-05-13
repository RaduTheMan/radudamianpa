DROP TABLE persons CASCADE CONSTRAINTS
/

DROP TABLE relationships CASCADE CONSTRAINTS
/

CREATE TABLE persons(
  id NUMBER(8) NOT NULL PRIMARY KEY,
  name VARCHAR2(100) NOT NULL UNIQUE
 )
/

CREATE TABLE relationships(
  id NUMBER(8) NOT NULL PRIMARY KEY,
  id_person1 NUMBER(8) NOT NULL,
  id_person2 NUMBER(8) NOT NULL,
  CONSTRAINT fk_id_person1 FOREIGN KEY (id_person1) REFERENCES persons(id),
  CONSTRAINT fk_id_person2 FOREIGN KEY (id_person2) REFERENCES persons(id),
  CONSTRAINT no_duplicates2 UNIQUE (id_person1, id_person2),
  CONSTRAINT no_same_person CHECK (id_person1 < id_person2)
 )
/

DROP SEQUENCE person_seq
/

DROP SEQUENCE relationship_seq
/

CREATE SEQUENCE person_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
CREATE SEQUENCE relationship_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  

INSERT INTO PERSONS VALUES(person_seq.NEXTVAL,'gigel');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'cr7');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'TheMan');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'frij');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'boss');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'hakuna');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'javaworld');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'kramer');

INSERT INTO RELATIONSHIPS VALUES(relationship_seq.nextval, 1, 2);
INSERT INTO RELATIONSHIPS VALUES(relationship_seq.nextval, 2, 5);
INSERT INTO RELATIONSHIPS VALUES(relationship_seq.nextval, 1, 4);
INSERT INTO RELATIONSHIPS VALUES(relationship_seq.nextval, 5, 7);
INSERT INTO RELATIONSHIPS VALUES(relationship_seq.nextval, 3, 5);
INSERT INTO RELATIONSHIPS VALUES(relationship_seq.nextval, 7, 8);