drop table user;
CREATE TABLE user (
    id int NOT NULL AUTO_INCREMENT,
    firstName varchar(100) NOT NULL,
    lastName varchar(100) NOT NULL,
    username varchar(100) NOT NULL,
    email varchar(255) NOT NULL,
    administrator bool NOT NULL DEFAULT true,
    PRIMARY KEY (id)
)