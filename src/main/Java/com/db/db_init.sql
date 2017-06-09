CREATE TABLE stock
(
    id VARCHAR(20) PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    price VARCHAR(255),
    upStaying VARCHAR(255),
    fallStaying VARCHAR(255),
    `change` VARCHAR(255),
    changeP VARCHAR(255),
    close VARCHAR(255),
    open VARCHAR(255),
    high VARCHAR(255),
    low VARCHAR(255),
    tradeVol VARCHAR(255),
    tradeAmount VARCHAR(255),
    totalValue VARCHAR(255),
    freeValue VARCHAR(255),
    tr VARCHAR(255),
    pb VARCHAR(255),
    pe VARCHAR(255),
    qr VARCHAR(255),
    datetime VARCHAR(255),
    netAsset VARCHAR(255),
    netMarginq VARCHAR(255),
    gpr VARCHAR(255),
    npr VARCHAR(255),
    roe VARCHAR(255),
    rank_totalValue VARCHAR(255),
    rank_netAsset VARCHAR(255),
    rank_netMargin VARCHAR(255),
    rank_pe VARCHAR(255),
    rank_pb VARCHAR(255),
    rank_gpr VARCHAR(255),
    rank_npr VARCHAR(255),
    rank_roe VARCHAR(255)
);
CREATE UNIQUE INDEX Stock_id_uindex ON stock (id);
CREATE TABLE bank
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    date VARCHAR(255),
    amount VARCHAR(255),
    up VARCHAR(255),
    down VARCHAR(255),
    fristName VARCHAR(255),
    fristChange VARCHAR(255),
    fristChangeP VARCHAR(255),
    avg_totalValue VARCHAR(255),
    avg_netAsset VARCHAR(255),
    avg_netMargin VARCHAR(255),
    avg_pe VARCHAR(255),
    avg_pb VARCHAR(255),
    avg_gpr VARCHAR(255),
    avg_npr VARCHAR(255),
    avg_roe VARCHAR(255)
);
CREATE UNIQUE INDEX Bank_id_uindex ON bank (id);
CREATE TABLE report
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    date VARCHAR(255),
    rateType VARCHAR(255),
    rateChange VARCHAR(255),
    org VARCHAR(255),
    reportUrl VARCHAR(255)
);
CREATE UNIQUE INDEX Report_id_uindex ON report (id);