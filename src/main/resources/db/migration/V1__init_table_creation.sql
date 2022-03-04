drop table if exists `filemgmtdb`.`file_detail`;
CREATE TABLE IF NOT EXISTS `filemgmtdb`.`file_detail` (
    `file_detail_sk` VARCHAR(36) NOT NULL COMMENT 'Primary key that identifies the file within the table',
    `file_id` VARCHAR(45) NOT NULL COMMENT 'A unique file id that is assigned to the file and is exposed to the users',
    `file_name` VARCHAR(100) NOT NULL COMMENT 'The name of the file',
    `file_received_date` DATETIME NOT NULL COMMENT 'The date when the file was received',
    `created_date` DATETIME NULL,
    `updated_date` DATETIME NULL,
    PRIMARY KEY (`file_detail_sk`),
    UNIQUE INDEX `file_id_UNIQUE` (`file_id` ASC) VISIBLE)
    ENGINE = InnoDB
    COMMENT = 'Contains the details of the file that was received.'