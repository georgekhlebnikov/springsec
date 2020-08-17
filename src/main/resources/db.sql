
USE spsec;

-- Table: users
CREATE TABLE users
(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
COLLATE='utf8_general_ci',
ENGINE = InnoDB;


-- Table: roles
CREATE TABLE roles (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR(255) NOT NULL
)
ENGINE = InnoDB;


-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
ENGINE = InnoDB;


-- Insert data
INSERT INTO users VALUES
(10, 'admin', 'admin'),
(101,'John', '12'),
(102,'Ivan', '123');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (10, 2);
INSERT INTO user_roles VALUES (101, 1);
INSERT INTO user_roles VALUES (102, 1);
INSERT INTO user_roles VALUES (102, 2);

