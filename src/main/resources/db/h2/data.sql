INSERT INTO ALUNOS VALUES(NEXTVAL('SEQUENCE_ALUNO'), '256.575.840-58', 'aluno1@gmail.com', '2019001001', 'Aluno1', '51111111111', null);
INSERT INTO ALUNOS VALUES(NEXTVAL('SEQUENCE_ALUNO'), '256.575.840-58', 'aluno2@gmail.com', '2019001002', 'Aluno2', '51222222222', null);

INSERT INTO PROFESSORES VALUES(NEXTVAL('SEQUENCE_PROFESSOR'), '256.575.840-58', 'professor1@gmail.com', '2019002001', 'Professor1', '51111111111', null);

SELECT * FROM ALUNOS;
SELECT * FROM PAPEL ;
SELECT * FROM PROFESSORES ;
SELECT * FROM PROPOSTAS ;
SELECT * FROM TITULOS ;
SELECT * FROM TITULOS_PROFESSOR ;
SELECT * FROM USUARIO ;
SELECT * FROM USUARIO_PAPEIS ;

INSERT INTO PAPEL VALUES(NEXTVAL('SEQUENCE_PAPEL'), 'ALUNO');
INSERT INTO PAPEL VALUES(NEXTVAL('SEQUENCE_PAPEL'), 'PROFESSOR');
INSERT INTO PAPEL VALUES(NEXTVAL('SEQUENCE_PAPEL'), 'ADMIN');

INSERT INTO USUARIO VALUES(NEXTVAL('SEQUENCE_USUARIO'), '$2a$10$cP.HC3OH3VXsGs1TB9YXxOU6kYB7TshuhPVjIxJAFr1JNEao4y2E.', 'admin');

INSERT INTO USUARIO_PAPEIS VALUES(1, 3);