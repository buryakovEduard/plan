CREATE DATABASE planb;
CREATE TABLE  `planb`.`clients` (
   `CLIENT ID`    int(11) NOT NULL UNIQUE AUTO_INCREMENT,
   `CLIENT_NAME`  int(11) NOT NULL,
   `PURCHASES`    int(11) DEFAULT 0,
   PRIMARY KEY (`CLIENT_ID`),
);
  CREATE TABLE  `planb`.`products` (
  `PRODUCT_ID`      int(11) NOT NULL UNIQUE AUTO_INCREMENT,
  `PRODUCT_NAME`    int(11) NOT NULL,
  `PRICE`           int(11) NOT NULL,
  `COUNT`           int(11) DEFAULT 0,
   PRIMARY KEY (`PRODUCT_ID`)
);
 CREATE TABLE  `planb`.`orders` (
   `ORDER_ID`           int(11) NOT NULL UNIQUE AUTO_INCREMENT,
   `CLIENT_ID`          int(11) NOT NULL,
   `PRODUCT_ID`         int(11) NOT NULL,
   `PRODUCTCOUNT`       int(11) NOT NULL,
   `ORDERDATE`          int(11) NOT NULL,
   `DATE`               long    NOT NULL,
   PRIMARY KEY (`ORDER_ID`),
   FOREIGN KEY (PRODUCT_ID) REFERENCES products(PRODUCT_ID),
   FOREIGN KEY (CLIENT_ID) REFERENCES clients(CLIENT_ID)
)
