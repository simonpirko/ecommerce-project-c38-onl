CREATE TABLE IF NOT EXISTS reviews (
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT,
    product_id BIGINT,
    comment    TEXT,
    rating     INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT rating_range_check CHECK (rating >= 1 AND rating <= 10),

    CONSTRAINT fk_review_user
    FOREIGN KEY (user_id)
    REFERENCES users (id),

    CONSTRAINT fk_review_product
    FOREIGN KEY (product_id)
    REFERENCES products (id)
);
