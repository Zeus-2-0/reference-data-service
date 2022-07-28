INSERT INTO zeusrefdatadb.external_source(external_source_sk, external_source_code, external_source_name, external_source_desc, created_date, updated_date) VALUES (100001, 'EDI834', 'EDI-834', 'EDI TRANSACTIONS', SYSDATE(), SYSDATE());

-- External List and type for the above external source
INSERT INTO zeusrefdatadb.external_list_type(external_list_type_sk, external_list_type_name, external_list_type_desc, display_name, external_source_sk, created_date, updated_date) VALUES (110001,'Identifier', 'Identifier', 'Identifier', 100001, SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, display_name, created_date, updated_date) VALUES (210001, 110001, '34', 'Social Security Number', 'Social Security Number', SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, display_name, created_date, updated_date) VALUES (210002, 110001, 'FI', 'Federal Tax Identifier', 'Federal Tax Identifier', SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, display_name, created_date, updated_date) VALUES (210003, 110001, '0F', 'Exchange Subscriber Id', 'Exchange Subscriber Id', SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, display_name, created_date, updated_date) VALUES (210004, 110001, '17', 'Exchange Member Id', 'Exchange Member Id', SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.external_list_dtl(external_list_dtl_sk, external_list_type_sk, external_list_code, external_list_desc, display_name, created_date, updated_date) VALUES (210005, 110001, '6O', 'Cross Reference Id','Cross Reference Id', SYSDATE(), SYSDATE());

-- Internal List types and list codes
INSERT INTO zeusrefdatadb.internal_list_type(internal_list_type_sk, internal_list_type_name, internal_list_type_desc, display_name, created_date, updated_date) values(510001, 'Identifier', 'Identifier', 'Identifier', sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) value (610001, 'SSN', 'Social Security Number', 'Social Security Number', 510001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values(610002, 'TIN', 'Tax Identification Number', 'Tax Identification Number', 510001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values(610003, 'EXCHSUBID', 'Exchange Subscriber Id', 'Exchange Subscriber Id', 510001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values(610004, 'EXCHMEMID', 'Exchange Member Id', 'Exchange Member Id', 510001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values(610005, 'HHCASEID', 'House Hold Case Id', 'House Hold Case Id', 510001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values(610006, 'PYMTID', 'Payment Transaction Id', 'Payment Transaction Id', 510001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values(610007, 'STATEID', 'State Id', 'State Id', 510001, sysdate(), sysdate());

INSERT INTO zeusrefdatadb.internal_list_type(internal_list_type_sk, internal_list_type_name, internal_list_type_desc, display_name, created_date, updated_date) values(520001, 'LineOfBusiness', 'Line of business', 'Line of business', sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk,  created_date, updated_date) value (620001, 'HIX', 'Health Information Exchange', 'Health Information Exchange',  520001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) value (620002, 'MDC', 'Medicare', 'Medicare', 520001, sysdate(), sysdate());

INSERT INTO zeusrefdatadb.internal_list_type(internal_list_type_sk, internal_list_type_name, internal_list_type_desc, display_name, created_date, updated_date) values(530001, 'Marketplace', 'Marketplace Type', 'Marketplace Type', sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) value (630001, 'FFM', 'Federally Facilitated Marketplace', 'Federally Facilitated Marketplace', 530001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) value (630002, 'OFFX', 'OFF Exchange', 'OFF Exchange', 530001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values (630003, 'SBE', 'State Based Exchange', 'State Based Exchange', 530001, sysdate(), sysdate());


INSERT INTO zeusrefdatadb.internal_list_type(internal_list_type_sk, internal_list_type_name, internal_list_type_desc, display_name, created_date, updated_date) values(540001, 'State', 'State Code', 'State Code', sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) value (640001, 'AL', 'Alabama','Alabama', 540001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) value (640002, 'AK', 'Alaska','Alaska', 540001, sysdate(), sysdate());
INSERT INTO zeusrefdatadb.internal_list_dtl(internal_list_dtl_sk, internal_list_code, internal_list_code_desc, display_name, internal_list_type_sk, created_date, updated_date) values (640003, 'AZ', 'Arizona', 'Arizona', 540001, sysdate(), sysdate());


-- Internal/External crosswalk
INSERT INTO zeusrefdatadb.intrnl_extrnl_type_xwalk(list_type_xwalk_sk, internal_list_type_sk, external_list_type_sk, created_date, updated_date) VALUES (810001, 510001, 110001, SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (910001,810001,610001,210001, SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (910002,810001,610002,210002, SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (910003,810001,610003,210003, SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (910004,810001,610004,210004, SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (910005,810001,610005,210005, SYSDATE(), SYSDATE());
INSERT INTO zeusrefdatadb.intrnl_extrnl_dtl_xwalk(list_detail_xwalk, list_type_xwalk_sk, internal_list_dtl_sk, external_list_dtl_sk, created_date, updated_date) VALUES (910006,810001,610006,210005, SYSDATE(), SYSDATE());