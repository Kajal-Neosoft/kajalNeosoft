-- Drop Sequence
DROP SEQUENCE IF EXISTS seq_unit CASCADE;
DROP SEQUENCE IF EXISTS seq_feature_configuration CASCADE ;
DROP SEQUENCE IF EXISTS seq_unit_feature_configuration CASCADE ;

--Drop tables
DROP TABLE IF EXISTS unit_feature_configuration;
DROP TABLE IF EXISTS unit;
DROP TABLE IF EXISTS feature_configuration;