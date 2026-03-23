CREATE TABLE IF NOT EXISTS cart_items (
    product_id BIGINT,
    user_id    BIGINT,
    quantity   INTEGER NOT NULL DEFAULT 0,

    PRIMARY KEY (product_id, user_id),

    CONSTRAINT fk_cart_item_product
    FOREIGN KEY (product_id)
    REFERENCES products (id),

    CONSTRAINT fk_cart_item_user
    FOREIGN KEY (user_id)
    REFERENCES users (id)
);