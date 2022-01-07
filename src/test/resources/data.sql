INSERT INTO external_source(external_source_sk, external_source_code, external_source_name, external_source_desc, created_date, updated_date) VALUES (100001, 'EDI834', 'EDI-834', 'EDI TRANSACTIONS', SYSDATE(), SYSDATE());

INSERT INTO external_list_type(external_list_type_sk, external_list_type_name, external_list_type_desc, external_source_sk, created_date, updated_date) VALUES (110001,'Identifier', 'Identifier', 100001, SYSDATE(), SYSDATE());

INSERT INTO external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, created_date, updated_date) VALUES (120001, 110001, '34', 'Social Security Number',SYSDATE(), SYSDATE());
INSERT INTO external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, created_date, updated_date) VALUES (120002, 110001, 'FI', 'Federal Tax Identifier',SYSDATE(), SYSDATE());
INSERT INTO external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, created_date, updated_date) VALUES (120003, 110001, '0F', 'Exchange Subscriber Id',SYSDATE(), SYSDATE());
INSERT INTO external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, created_date, updated_date) VALUES (120004, 110001, '17', 'Exchange Member Id',SYSDATE(), SYSDATE());
INSERT INTO external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, created_date, updated_date) VALUES (120005, 110001, '6O', 'Cross Reference Id',SYSDATE(), SYSDATE());

INSERT INTO internal_list_type(internal_list_type_sk, internal_list_type_name, internal_list_type_desc, created_date, updated_date) values(130001, 'Identifier', 'Identifier', sysdate(), sysdate());
INSERT INTO internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, internal_list_type_sk, created_date, updated_date) values(140001, 'SSN', 'Social Security Number', 130001, sysdate(), sysdate());
INSERT INTO internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, internal_list_type_sk, created_date, updated_date) values(140002, 'TIN', 'Tax Identification Number', 130001, sysdate(), sysdate());
INSERT INTO internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, internal_list_type_sk, created_date, updated_date) values(140003, 'EXCHSUBID', 'Exchange Subscriber Id', 130001, sysdate(), sysdate());
INSERT INTO internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, internal_list_type_sk, created_date, updated_date) values(140004, 'EXCHMEMID', 'Exchange Member Id', 130001, sysdate(), sysdate());
INSERT INTO internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, internal_list_type_sk, created_date, updated_date) values(140005, 'HHCASEID', 'House Hold Case Id', 130001, sysdate(), sysdate());
INSERT INTO internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, internal_list_type_sk, created_date, updated_date) values(140006, 'PYMTID', 'Payment Transaction Id', 130001, sysdate(), sysdate());

INSERT INTO intrnl_extrnl_type_xwalk(list_type_xwalk_sk, internal_list_type_sk, external_list_type_sk, created_date, updated_date) VALUES (150001, 130001, 110001, SYSDATE(), SYSDATE());

INSERT INTO intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (160001,150001,140001,120001, SYSDATE(), SYSDATE());
INSERT INTO intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (160002,150001,140002,120002, SYSDATE(), SYSDATE());
INSERT INTO intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (160003,150001,140003,120003, SYSDATE(), SYSDATE());
INSERT INTO intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (160004,150001,140004,120004, SYSDATE(), SYSDATE());
INSERT INTO intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (160005,150001,140005,120005, SYSDATE(), SYSDATE());
INSERT INTO intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (160006,150001,140006,120005, SYSDATE(), SYSDATE());