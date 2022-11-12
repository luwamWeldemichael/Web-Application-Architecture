--- users

INSERT INTO users (id, name, email, password)
VALUES (1,  'user1', 'user1@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, name, email, password)
VALUES (2,  'user2', 'user2@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, name, email, password)
VALUES (3,  'user3', 'user3@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

-- posts

INSERT INTO posts (id, title, content, author, user_id)
VALUES (1, 'title1', 'content1', 'author1', 1);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (4, 'title1', 'content4', 'author4', 1);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (2, 'title2', 'content2', 'author2', 1);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (3, 'title3', 'content3', 'author3', 2);

INSERT INTO comments (id, name, post_id)
VALUES (1,  'comment1', 1);

INSERT INTO comments(id, name, post_id)
VALUES (2,  'comment2', 1);

INSERT INTO comments (id, name, post_id)
VALUES (3,  'comment3', 2);


Insert INTO Roles(id, role)
VALUES (1,  'ADMIN');

Insert INTO Roles(id, role)
VALUES (2,  'USER');

Insert INTO users_roles(user_id, roles_id)
VALUES (1,  1);

Insert INTO users_roles(user_id, roles_id)
VALUES (2,  2);