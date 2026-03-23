CREATE TABLE IF NOT EXISTS products (
    id          BIGSERIAL PRIMARY KEY,
    seller_id   BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    price       NUMERIC(10, 2) NOT NULL,
    quantity    INTEGER NOT NULL DEFAULT 0,

    CONSTRAINT fk_product_seller
    FOREIGN KEY (seller_id)
    REFERENCES users (id),

    CONSTRAINT fk_product_category
    FOREIGN KEY (category_id)
    REFERENCES categories (id)
    );