CREATE TABLE product
(
    product_id SERIAL PRIMARY KEY,
    name  TEXT NOT NULL,
    is_active BOOLEAN,
    is_premium BOOLEAN

);
ALTER SEQUENCE product_product_id_seq RESTART 1000000;