
CREATE TABLE log(
    ID int(15) NOT NULL AUTO_INCREMENT,
    DATA TIMESTAMP,
    REQUEST VARCHAR(255) NOT NULL,
    IP VARCHAR(255) NOT NULL,
    STATUS VARCHAR(255) NOT NULL,
    USER_AGENT VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
