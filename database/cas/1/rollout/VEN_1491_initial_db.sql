-- Create Sequences

CREATE SEQUENCE seq_unit
    START WITH 1
    INCREMENT BY 30
    NO MINVALUE
    NO MAXVALUE
    CACHE 20
    CYCLE;

CREATE SEQUENCE seq_feature_configuration
    START WITH 1
    INCREMENT BY 30
    NO MINVALUE
    NO MAXVALUE
    CACHE 20
    CYCLE;


CREATE SEQUENCE seq_unit_feature_configuration
    START WITH 1
    INCREMENT BY 30
    NO MINVALUE
    NO MAXVALUE
    CACHE 20
    CYCLE;

-- Create Tables

CREATE TABLE unit (
    id bigint DEFAULT nextval('seq_unit') NOT NULL,
    code VARCHAR(50) NOT NULL,
    unit_name VARCHAR(255) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    currency_decimal_places integer NOT NULL,
    default_language bigint NOT NULL,
    created_date timestamp with time zone NOT NULL,
    update_date timestamp with time zone,
    delete_date timestamp with time zone
);

CREATE TABLE feature_configuration (
    id bigint DEFAULT nextval('seq_feature_configuration') NOT NULL,
    segment_name VARCHAR(255),
    param VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    type VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    platform VARCHAR(40) NOT NULL,
    created_date timestamp with time zone,
    update_date timestamp with time zone,
    delete_date timestamp with time zone
);

CREATE TABLE unit_feature_configuration (
    id bigint DEFAULT nextval('seq_unit_feature_configuration') NOT NULL,
    unit_id bigint NOT NULL,
    feature_configuration_id bigint NOT NULL
);


-- Create PRIMARY KEY

ALTER TABLE ONLY feature_configuration
    ADD CONSTRAINT feature_configuration_pkey PRIMARY KEY (id);

ALTER TABLE ONLY unit_feature_configuration
    ADD CONSTRAINT unit_feature_configuration_pkey PRIMARY KEY (id);

ALTER TABLE ONLY unit
    ADD CONSTRAINT unit_pkey PRIMARY KEY (id);

-- Add Constraint

-- Add link between feature_configuration to unit

ALTER TABLE ONLY unit_feature_configuration
    ADD CONSTRAINT fk_link_table_feature_configuration_id FOREIGN KEY (feature_configuration_id) REFERENCES feature_configuration(id);

ALTER TABLE ONLY unit_feature_configuration
    ADD CONSTRAINT fk_link_table_unit_id FOREIGN KEY (unit_id) REFERENCES unit(id) NOT VALID;

