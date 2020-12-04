DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS "user";

CREATE TABLE "user" (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    is_active BOOLEAN
);

CREATE TABLE role (
    role_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE user_role (
    user_id BIGINT REFERENCES "user" (user_id),
    role_id INT REFERENCES role(role_id),
    PRIMARY KEY (user_id, role_id)
);


CREATE TABLE post (
    post_id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    user_id BIGINT REFERENCES "user"(user_id),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE comment (
    comment_id BIGSERIAL PRIMARY KEY,
    post_id BIGINT REFERENCES post(post_id) ON DELETE CASCADE,
    content TEXT,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE tag (
    tag_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);


CREATE TABLE post_tag (
    post_id bigint REFERENCES post(post_id) ON DELETE CASCADE,
    tag_id bigint REFERENCES tag(tag_id),
    PRIMARY KEY (post_id, tag_id)
);

INSERT INTO role VALUES (1, 'ADMIN');
INSERT INTO role VALUES (2, 'USER');

INSERT INTO "user" (username, password, created_at, is_active) VALUES ('admin', 'admin', now()::TIMESTAMP, TRUE);
INSERT INTO "user" (username, password, created_at, is_active) VALUES ('user1', 'user1', now()::TIMESTAMP, TRUE);

INSERT INTO user_role VALUES (1, 1);
INSERT INTO user_role VALUES (2, 2);

INSERT INTO post (title, content, user_id, created_at, updated_at) VALUES ('Day 1', 'It''s all good!', 2, CURRENT_TIMESTAMP - INTERVAL '2 days', NULL);
INSERT INTO post (title, content, user_id, created_at, updated_at) VALUES ('Day 2', 'It''s all ok!', 2, CURRENT_TIMESTAMP - INTERVAL '1 days', NULL);
INSERT INTO post (title, content, user_id, created_at, updated_at) VALUES ('Day 3', 'It''s all bad!', 2, CURRENT_TIMESTAMP, NULL);

INSERT INTO comment (post_id, content, created_at) VALUES (2, 'Nice!', current_timestamp);
INSERT INTO comment (post_id, content, created_at) VALUES (1, 'Awesome!', current_timestamp);
INSERT INTO comment (post_id, content, created_at) VALUES (1, 'Excellent!', current_timestamp);
INSERT INTO comment (post_id, content, created_at) VALUES (1, 'Wonderful!', current_timestamp);
INSERT INTO comment (post_id, content, created_at) VALUES (3, 'Disgusting!', current_timestamp);
INSERT INTO comment (post_id, content, created_at) VALUES (3, 'Atrocious!', current_timestamp);

INSERT INTO tag (name) VALUES ('news');
INSERT INTO tag (name) VALUES ('life');
INSERT INTO tag (name) VALUES ('day');
INSERT INTO tag (name) VALUES ('mood');
INSERT INTO tag (name) VALUES ('ideas');
INSERT INTO tag (name) VALUES ('thoughts');

insert into post_tag(post_id, tag_id) VALUES (1, 1);
insert into post_tag(post_id, tag_id) VALUES (1, 2);
insert into post_tag(post_id, tag_id) VALUES (2, 3);
insert into post_tag(post_id, tag_id) VALUES (2, 2);
insert into post_tag(post_id, tag_id) VALUES (2, 1);
insert into post_tag(post_id, tag_id) VALUES (2, 5);
insert into post_tag(post_id, tag_id) VALUES (3, 3);
insert into post_tag(post_id, tag_id) VALUES (3, 2);
insert into post_tag(post_id, tag_id) VALUES (3, 6);
