DROP TABLE persons
/

CREATE TABLE persons(
  id NUMBER(8) NOT NULL PRIMARY KEY,
  name VARCHAR2(100) NOT NULL UNIQUE
 )
/

DROP SEQUENCE person_seq
/

CREATE SEQUENCE person_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

INSERT INTO PERSONS VALUES(person_seq.NEXTVAL,'gigel');
INSERT INTO PERSONS VALUES(person_seq.NEXTVAL, 'cr7');