CREATE TABLE IF NOT EXISTS banks
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(250) NOT NULL,
    bic          VARCHAR(9)   NOT NULL
);

CREATE TABLE IF NOT EXISTS clients
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(250) NOT NULL,
    short_name   VARCHAR(250) NOT NULL,
    address      VARCHAR(400) NOT NULL,
    legal_form   VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS deposits
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    client_id    INT,
    FOREIGN KEY (client_id) REFERENCES clients (id),
    bank_id      INT,
    FOREIGN KEY (bank_id) REFERENCES banks (id),
    opening_date TIMESTAMP NOT NULL,
    percent      INT       NOT NULL,
    period       INT       NOT NULL
);
