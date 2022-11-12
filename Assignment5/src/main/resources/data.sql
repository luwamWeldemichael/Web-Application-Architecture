-- Users data
INSERT INTO Users (id, name, email, password)
VALUES (1234, 'Keven', 'keven@gmail.com', 'keven');

INSERT INTO Users (id, name, email, password)
VALUES (1235, 'Prince', 'prince@gmail.com', 'prince');

INSERT INTO Users (id, name, email, password)
VALUES (1236, 'Mohamed', 'mohmed@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

-- Posts data
INSERT into POST (id, title, content, author, USER_ID)
VALUES (1, 'first post','Life is structured in layers','Joe', 1234);

INSERT into POST (id, title, content, author, USER_ID)
VALUES (2, 'second post','React is a good SPA library','John', 1234);

INSERT into POST (id, title, content, author, USER_ID)
VALUES (3, 'third','Spring is awesome','Luwam',1235);

INSERT into POST (id, title, content, author, USER_ID)
VALUES (4, 'fourth post','This is a module that works over spring modules','Ahmed',1236);


-- Comments data
INSERT into COMMENT (id, name , POST_ID)
VALUES (1, 'first comment', 1);

INSERT into COMMENT (id, name, POST_ID)
VALUES (2, 'second comment', 1);

INSERT into COMMENT (id, name, POST_ID)
VALUES (3, 'third comment', 2);

INSERT into COMMENT (id, name, POST_ID)
VALUES (4, 'fourth comment', 3);

INSERT into COMMENT (id, name, POST_ID)
VALUES (5, 'fifth comment', 4);

--ROLES data
INSERT INTO ROLE (role)
VALUES('ADMIN');

INSERT INTO ROLE (role)
VALUES('USER');

--USER_ROLE data
-- Insert INTO USER_ROLE(USER_ID, ROLES_ID)
-- VALUES (1,  1);
--
-- Insert INTO USER_ROLE(USER_ID, ROLES_ID)
-- VALUES (2,  2);






