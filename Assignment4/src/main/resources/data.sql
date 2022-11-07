-- Users data
INSERT INTO Users (id, name)
VALUES (1234, 'Keven' );

INSERT INTO Users (id, name)
VALUES (1235, 'Prince');

INSERT INTO Users (id, name)
VALUES (1236, 'Mohamed');

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







