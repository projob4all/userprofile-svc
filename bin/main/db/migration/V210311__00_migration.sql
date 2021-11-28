CREATE TABLE country (
country_code VARCHAR(20) NOT NULL,
description VARCHAR(100),
CONSTRAINT country_pk PRIMARY KEY (country_code)
);

INSERT INTO country(country_code,description)
VALUES('USA','United States of America');

CREATE TABLE candidate (
candidate_id UUID NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone VARCHAR(20) NOT NULL,
address1 VARCHAR(100) NOT NULL,
address2 VARCHAR(100),
address3 VARCHAR(100),
address4 VARCHAR(100),
unit VARCHAR(20),
city VARCHAR(20) NOT NULL,
postal_code VARCHAR(20) NOT NULL,
country_code VARCHAR(20) NOT NULL DEFAULT 'USA',
active BOOLEAN NOT NULL DEFAULT true,
created_on TIMESTAMP,
created_by UUID,
updated_on TIMESTAMP,
updated_by UUID,
CONSTRAINT candidate_pk PRIMARY KEY (candidate_id),
CONSTRAINT country_fk FOREIGN KEY(country_code) REFERENCES country(country_code)
);

CREATE INDEX candidate_email ON candidate USING btree(email);
CREATE INDEX candidate_last_first ON candidate USING btree(last_name,first_name);
