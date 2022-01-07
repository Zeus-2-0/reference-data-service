DROP TABLE IF EXISTS `zeusrefdatadb`.`intrnl_extrnl_dtl_xwalk`;
DROP TABLE IF EXISTS `zeusrefdatadb`.`intrnl_extrnl_type_xwalk`;
DROP TABLE IF EXISTS `zeusrefdatadb`.`internal_list_dtl`;
DROP TABLE IF EXISTS `zeusrefdatadb`.`internal_list_type`;
DROP TABLE IF EXISTS `zeusrefdatadb`.`external_list_dtl`;
DROP TABLE IF EXISTS `zeusrefdatadb`.`external_list_type`;
DROP TABLE IF EXISTS `zeusrefdatadb`.`external_source`;

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`hibernate_sequence` (
    next_val BIGINT
) engine=InnoDB;

insert into hibernate_sequence values ( 200001 );

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`external_source` (
                                                                 `external_source_sk` BIGINT NOT NULL,
                                                                 `external_source_code` VARCHAR(100) NOT NULL COMMENT 'The code for the external source',
    `external_source_name` VARCHAR(100) NOT NULL COMMENT 'The name for the external source',
    `external_source_desc` VARCHAR(100) NULL COMMENT 'A short description for the external source',
    `created_date` DATETIME NULL,
    `updated_date` DATETIME NULL,
    PRIMARY KEY (`external_source_sk`),
    UNIQUE INDEX `external_source_code_UNIQUE` (`external_source_code` ASC) VISIBLE,
    UNIQUE INDEX `external_source_name_UNIQUE` (`external_source_name` ASC) VISIBLE)
    ENGINE = InnoDB
    COMMENT = 'Contains the list of all the external sources';

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`external_list_type` (
                                                                    `external_list_type_sk` BIGINT NOT NULL,
                                                                    `external_list_type_name` VARCHAR(100) NOT NULL COMMENT 'The name of the external list',
    `external_list_type_desc` VARCHAR(100) NULL COMMENT 'A short description for the external list',
    `external_source_sk` BIGINT NOT NULL COMMENT 'The external source that the list is associated.',
    `created_date` DATETIME NULL,
    `updated_date` DATETIME NULL,
    PRIMARY KEY (`external_list_type_sk`),
    INDEX `external_source_sk_idx` (`external_source_sk` ASC) VISIBLE,
    UNIQUE INDEX `external_list_type_name_UNIQUE` (`external_list_type_name` ASC) VISIBLE,
    CONSTRAINT `external_source_sk`
    FOREIGN KEY (`external_source_sk`)
    REFERENCES `zeusrefdatadb`.`external_source` (`external_source_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    COMMENT = 'The list of all external reference data codes';

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`external_list_dtl` (
                                                                   `external_list_dtl_sk` BIGINT NOT NULL,
                                                                   `external_list_type_sk` BIGINT NOT NULL,
                                                                   `external_list_code` VARCHAR(100) NOT NULL COMMENT 'The code for the external reference data',
    `external_list_desc` VARCHAR(100) NULL COMMENT 'A short description of the code',
    `created_date` DATETIME NULL,
    `updated_date` DATETIME NULL,
    PRIMARY KEY (`external_list_dtl_sk`),
    INDEX `external_list_type_sk_idx` (`external_list_type_sk` ASC) VISIBLE,
    CONSTRAINT `external_list_type_sk`
    FOREIGN KEY (`external_list_type_sk`)
    REFERENCES `zeusrefdatadb`.`external_list_type` (`external_list_type_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    COMMENT = 'Contains the list of all the external reference data codes';

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`internal_list_type` (
                                                                    `internal_list_type_sk` BIGINT NOT NULL,
                                                                    `internal_list_type_name` VARCHAR(100) NOT NULL COMMENT 'The name of the internal list',
    `internal_list_type_desc` VARCHAR(100) NULL COMMENT 'A short description of the list',
    `created_date` DATETIME NULL,
    `updated_date` DATETIME NULL,
    PRIMARY KEY (`internal_list_type_sk`),
    UNIQUE INDEX `list_type_name_UNIQUE` (`internal_list_type_name` ASC) VISIBLE)
    ENGINE = InnoDB
    COMMENT = 'Contains the names of all the internal list';

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`internal_list_dtl` (
                                                                   `internal_list_dtl_sk` BIGINT NOT NULL,
                                                                   `internal_list_code` VARCHAR(45) NOT NULL COMMENT 'Code for reference data',
    `internal_list_type_sk` BIGINT NOT NULL COMMENT 'The list type to which the code belongs to',
    `internal_list_code_desc` VARCHAR(100) NULL COMMENT 'A short description for the code',
    `created_date` DATETIME NULL,
    `updated_date` DATETIME NULL,
    PRIMARY KEY (`internal_list_dtl_sk`),
    INDEX `internal_list_type_sk_idx` (`internal_list_type_sk` ASC) VISIBLE,
    CONSTRAINT `internal_list_type_sk`
    FOREIGN KEY (`internal_list_type_sk`)
    REFERENCES `zeusrefdatadb`.`internal_list_type` (`internal_list_type_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    COMMENT = 'Contains the list of all internal reference data codes';

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`intrnl_extrnl_type_xwalk` (
                                                                          `list_type_xwalk_sk` BIGINT NOT NULL,
                                                                          `internal_list_type_sk` BIGINT NOT NULL,
                                                                          `external_list_type_sk` BIGINT NOT NULL,
                                                                          `created_date` DATETIME NULL,
                                                                          `updated_date` DATETIME NULL,
                                                                          PRIMARY KEY (`list_type_xwalk_sk`),
    INDEX `internal_list_sk_idx` (`internal_list_type_sk` ASC) VISIBLE,
    INDEX `external_list_type_sk_idx` (`external_list_type_sk` ASC) VISIBLE,
    CONSTRAINT `internal_list_type_sk1`
    FOREIGN KEY (`internal_list_type_sk`)
    REFERENCES `zeusrefdatadb`.`internal_list_type` (`internal_list_type_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `external_list_type_sk1`
    FOREIGN KEY (`external_list_type_sk`)
    REFERENCES `zeusrefdatadb`.`external_list_type` (`external_list_type_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    COMMENT = 'Crosswalk between external and internal type lists';

CREATE TABLE IF NOT EXISTS `zeusrefdatadb`.`intrnl_extrnl_dtl_xwalk` (
                                                                         `list_detail_xwalk` BIGINT NOT NULL,
                                                                         `list_type_xwalk_sk` BIGINT NOT NULL,
                                                                         `internal_list_dtl_sk` BIGINT NOT NULL,
                                                                         `external_list_dtl_sk` BIGINT NOT NULL,
                                                                         `created_date` DATETIME NULL,
                                                                         `updated_date` DATETIME NULL,
                                                                         PRIMARY KEY (`list_detail_xwalk`),
    INDEX `list_type_xwalk_sk_idx` (`list_type_xwalk_sk` ASC) VISIBLE,
    INDEX `internal_list_dtl_sk_idx` (`internal_list_dtl_sk` ASC) VISIBLE,
    INDEX `external_list_dtl_sk_idx` (`external_list_dtl_sk` ASC) VISIBLE,
    CONSTRAINT `list_type_xwalk_sk`
    FOREIGN KEY (`list_type_xwalk_sk`)
    REFERENCES `zeusrefdatadb`.`intrnl_extrnl_type_xwalk` (`list_type_xwalk_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `internal_list_dtl_sk`
    FOREIGN KEY (`internal_list_dtl_sk`)
    REFERENCES `zeusrefdatadb`.`internal_list_dtl` (`internal_list_dtl_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `external_list_dtl_sk`
    FOREIGN KEY (`external_list_dtl_sk`)
    REFERENCES `zeusrefdatadb`.`external_list_dtl` (`external_list_dtl_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    COMMENT = 'Crosswalk between the internal and the external code';