/*
Tables were generated from Vertabelo
*/
DROP TABLE categories;
DROP TABLE merchants;
DROP TABLE parts;
DROP TABLE partsmerchants;
DROP TABLE savedparts;
DROP TABLE user;
CREATE TABLE categories (
    id int NOT NULL AUTO_INCREMENT,
    category varchar(150) NOT NULL,
    CONSTRAINT categories_pk PRIMARY KEY (id)
);
CREATE TABLE merchants (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    logoImageFileLocation varchar(255) NOT NULL,
    website varchar(255) NOT NULL,
    CONSTRAINT merchants_pk PRIMARY KEY (id)
);
CREATE TABLE parts (
    id int NOT NULL AUTO_INCREMENT,
    partName varchar(255) NOT NULL,
    partNumber varchar(100) NOT NULL,
    partDescription text NOT NULL,
    partImageFileLocation varchar(255) NULL,
    categories_id int NOT NULL,
    CONSTRAINT parts_pk PRIMARY KEY (id)
);
CREATE TABLE partsmerchants (
    merchants_id int NOT NULL,
    parts_id int NOT NULL,
    linkToPart text NOT NULL,
    price varchar(100) NOT NULL,
    CONSTRAINT partsmerchants_pk PRIMARY KEY (merchants_id,parts_id)
);
CREATE TABLE savedparts (
    user_id int NOT NULL,
    parts_id int NOT NULL,
    CONSTRAINT savedparts_pk PRIMARY KEY (user_id,parts_id)
);
CREATE TABLE user (
    id int NOT NULL AUTO_INCREMENT,
    firstName varchar(100) NOT NULL,
    lastName varchar(100) NOT NULL,
    username varchar(100) NOT NULL,
    email varchar(255) NOT NULL,
    administrator bool NOT NULL DEFAULT true,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

ALTER TABLE partsmerchants ADD CONSTRAINT PartsMerchants_Merchants FOREIGN KEY PartsMerchants_Merchants (merchants_id)
    REFERENCES merchants (id);

ALTER TABLE partsmerchants ADD CONSTRAINT PartsMerchants_Parts FOREIGN KEY PartsMerchants_Parts (parts_id)
    REFERENCES parts (id);

ALTER TABLE parts ADD CONSTRAINT Parts_Categories FOREIGN KEY Parts_Categories (categories_id)
    REFERENCES categories (id);

ALTER TABLE savedparts ADD CONSTRAINT SavedParts_Parts FOREIGN KEY SavedParts_Parts (parts_id)
    REFERENCES parts (id);

ALTER TABLE savedparts ADD CONSTRAINT SavedParts_Users FOREIGN KEY SavedParts_Users (user_id)
    REFERENCES user (id);