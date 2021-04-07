INSERT INTO TITULOS (ID, DESCRICAO, NOMECLATURA, TIPO) VALUES(SEQUENCE_TITULOS.NEXTVAL,'Sistemas para Internet', 'SSI', 'GRADUACAO');
INSERT INTO TITULOS (ID, DESCRICAO, NOMECLATURA, TIPO) VALUES(SEQUENCE_TITULOS.NEXTVAL, 'Analise Desenvolvimento de Sistemas', 'ADS', 'GRADUACAO');
INSERT INTO TITULOS (ID, DESCRICAO, NOMECLATURA, TIPO) VALUES(SEQUENCE_TITULOS.NEXTVAL, 'Ciencia da Computacao', 'CC', 'GRADUACAO');
INSERT INTO TITULOS (ID, DESCRICAO, NOMECLATURA, TIPO) VALUES(SEQUENCE_TITULOS.NEXTVAL, 'Artificial Intelligence', 'AI', 'ESPECIALIZACAO');
INSERT INTO TITULOS (ID, DESCRICAO, NOMECLATURA, TIPO) VALUES(SEQUENCE_TITULOS.NEXTVAL, 'Data Science', 'DC', 'MESTRADO');
INSERT INTO TITULOS (ID, DESCRICAO, NOMECLATURA, TIPO) VALUES(SEQUENCE_TITULOS.NEXTVAL, 'Data Base Oracle', 'DATABASE', 'DOUTORADO');

INSERT INTO ALUNOS VALUES(NEXTVAL('SEQUENCE_ALUNO'), '25657584058', 'aluno1@gmail.com', '2019001001', 'Aluno1', '51111111111', null);
INSERT INTO ALUNOS VALUES(NEXTVAL('SEQUENCE_ALUNO'), '35657584059', 'aluno2@gmail.com', '2019001002', 'Aluno2', '51222222222', null);
INSERT INTO ALUNOS VALUES(NEXTVAL('SEQUENCE_ALUNO'), '45657584060', 'aluno3@gmail.com', '2019001003', 'Aluno3', '51333333333', null);

INSERT INTO PROFESSORES VALUES(NEXTVAL('SEQUENCE_PROFESSOR'), '25657584058', 'professor1@gmail.com', '2019002001', 'Professor1', '51111111111', 1);
INSERT INTO PROFESSORES VALUES(NEXTVAL('SEQUENCE_PROFESSOR'), '35657584059', 'professor2@gmail.com', '2019002002', 'Professor2', '51111111112', 3);
INSERT INTO PROFESSORES VALUES(NEXTVAL('SEQUENCE_PROFESSOR'), '45657584060', 'professor3@gmail.com', '2019002003', 'Professor3', '51111111113', 6);

SELECT * FROM ALUNOS;
SELECT * FROM PROFESSORES;
SELECT * FROM PROPOSTAS;
SELECT * FROM TITULOS;
SELECT * FROM USUARIO;

INSERT INTO USUARIO VALUES(NEXTVAL('SEQUENCE_USUARIO'), 'ADMIN', '$2a$10$cP.HC3OH3VXsGs1TB9YXxOU6kYB7TshuhPVjIxJAFr1JNEao4y2E.', 'admin');
