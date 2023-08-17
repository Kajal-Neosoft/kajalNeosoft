--CREATE SEQUENCE seq_account_order
--    AS BIGINT
--    START WITH 1
--    INCREMENT BY 50
--    MINVALUE 1
--    NO CYCLE
--    CACHE 20;
--
--CREATE TABLE account_order
--(
--    id               INT           NOT NULL DEFAULT nextval('seq_account_order'),
--    currency         VARCHAR(3)    NOT NULL,
--    sort_order       INT           NOT NULL,
--    unit_id         INT            NOT NULL,
--    CONSTRAINT pk_account_order PRIMARY KEY (id)
--);
--
--CREATE TABLE language
--(
--    id   BIGINT       NOT NULL,
--    code VARCHAR(10)  NOT NULL,
--    name VARCHAR(255) NOT NULL,
--    PRIMARY KEY (id)
--);
--
--
--INSERT INTO language(id, code, name) VALUES (1, 'en', 'ENGLISH');
--INSERT INTO language(id, code, name) VALUES (2, 'bh', 'BAHRAIN');
--
--INSERT INTO unit(id, code, unit_name, default_language, currency, currency_decimal_places, created_date) VALUES
--(1, 'neo', 'Neo', 1, 'BHD', 3, '13-07-2023');
--INSERT INTO unit(id, code, unit_name, default_language, currency, currency_decimal_places, created_date) VALUES
--(2, 'ila', 'Ila', 1, 'BHD', 3, '13-07-2023');
--INSERT INTO unit(id, code, unit_name, default_language, currency, currency_decimal_places, created_date) VALUES
--(3, 'jor', 'Jor', 1, 'JOD', 3, '13-07-2023');
--INSERT INTO unit (id, code, unit_name, default_language,currency, currency_decimal_places, created_date) VALUES
--(4,'alburaq','Alburaq',1,'BHD',3, '13-07-2023');
--
--INSERT INTO feature_configuration(id, param, value, type, description, platform) values(1, 'enableMock', 'true', 'boolean', 'enable mock', 'platform' );
--
--INSERT INTO unit_feature_configuration(id, unit_id, feature_configuration_id) values(1, 1, 1);
--INSERT INTO unit_feature_configuration(id, unit_id, feature_configuration_id) values(2, 2, 1);
--INSERT INTO unit_feature_configuration(id, unit_id, feature_configuration_id) values(3, 3, 1);
--INSERT INTO unit_feature_configuration(id, unit_id, feature_configuration_id) values(4, 4, 1);
--
--
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(1, 'BHD', 1, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(2, 'USD', 2, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(3, 'GBP', 3, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(4, 'EUR', 4, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(5, 'AED', 5, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(6, 'SAR', 6, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(7, 'CAD', 7, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(8, 'KWD', 8, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(9, 'AUD', 9, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(10, 'HKD', 10, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(11, 'JPY', 11, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(12, 'JOD', 12, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(13, 'OMR', 13, 1);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(14, 'SGD', 14, 1);
--
--
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(15, 'BHD', 1, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(16, 'USD', 2, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(17, 'GBP', 3, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(18, 'EUR', 4, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(19, 'AED', 5, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(20, 'SAR', 6, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(21, 'CAD', 7, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(22, 'KWD', 8, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(23, 'AUD', 9, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(24, 'HKD', 10, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(25, 'JPY', 11, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(26, 'JOD', 12, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(27, 'OMR', 13, 3);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(28, 'SGD', 14, 3);
--
--
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(29, 'BHD', 1, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(30, 'USD', 2, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(31, 'GBP', 3, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(32, 'EUR', 4, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(33, 'AED', 5, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(34, 'SAR', 6, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(35, 'CAD', 7, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(36, 'KWD', 8, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(37, 'AUD', 9, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(38, 'HKD', 10, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(39, 'JPY', 11, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(40, 'JOD', 12, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(41, 'OMR', 13, 4);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(42, 'SGD', 14, 4);
--
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(43, 'BHD', 1, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(44, 'USD', 2, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(45, 'GBP', 3, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(46, 'EUR', 4, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(47, 'AED', 5, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(48, 'SAR', 6, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(49, 'CAD', 7, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(50, 'KWD', 8, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(51, 'AUD', 9, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(52, 'HKD', 10, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(53, 'JPY', 11, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(54, 'JOD', 12, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(55, 'OMR', 13, 2);
--INSERT INTO account_order(id, currency, sort_order, unit_id) values(56, 'SGD', 14, 2);
--