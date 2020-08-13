USE springsec;

-- DROP TABLE IF EXISTS hibernate_sequence;
-- Table: users
CREATE TABLE users
(
  id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
)
COLLATE='utf8_general_ci',
ENGINE = InnoDB;


-- Table: roles
CREATE TABLE roles (
  id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL
)
ENGINE = InnoDB;


-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT(50) NOT NULL,
  role_id INT(50) NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
ENGINE = InnoDB;


-- Insert data
INSERT INTO users VALUES
(10, 'admin', 'admin'),
(101,'Josh', '12'),
(102,'Ivan', '123');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (10, 2);
INSERT INTO user_roles VALUES (101, 1);
INSERT INTO user_roles VALUES (102, 1);
INSERT INTO user_roles VALUES (102, 2);
