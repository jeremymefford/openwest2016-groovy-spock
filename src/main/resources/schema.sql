-- SELECT CURRENT_DATE AS today, CURRENT_TIME AS now FROM (VALUES(0));

CREATE TABLE customer (
  id         BIGINT,
  first_name VARCHAR(200),
  last_name  VARCHAR(200),
  birth_date DATE
);