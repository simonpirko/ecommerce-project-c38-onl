CREATE TABLE IF NOT EXISTS favorites (
    product_id BIGINT,
    user_id    BIGINT,

    PRIMARY KEY (product_id, user_id),

    CONSTRAINT fk_favorite_product
    FOREIGN KEY (product_id)
    REFERENCES products (id),

    CONSTRAINT fk_favorite_user
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    );