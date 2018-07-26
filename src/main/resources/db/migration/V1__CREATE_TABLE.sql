CREATE TABLE `klass` (
    `id` INT    NOT NULL    AUTO_INCREMENT PRIMARY KEY,
    `name`  VARCHAR(20)     NOT NULL,
    `leader_id` INT,
    `created_date`  TIMESTAMP   DEFAULT NOW()
);
CREATE TABLE `leader` (
    `id`    INT     NOT NULL    AUTO_INCREMENT  PRIMARY KEY,
    `name`  VARCHAR(20)     NOT NULL,
    `klass_id`  INT,
    `created_date`  TIMESTAMP   DEFAULT NOW()
);