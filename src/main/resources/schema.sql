DROP TABLE posts IF EXISTS;
CREATE TABLE posts(
    id INTEGER AUTO_INCREMENT Primary Key,
    author VARCHAR(60) DEFAULT 'anonymous',
    body VARCHAR(5000) NOT NULL,
    title VARCHAR(255),
    created DATETIME DEFAULT CURRENT_TIMESTAMP
    );