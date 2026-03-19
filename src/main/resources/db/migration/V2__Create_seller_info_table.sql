CREATE TABLE seller_info (
 user_id BIGINT PRIMARY KEY,
 details TEXT,
 contacts VARCHAR(255),
 CONSTRAINT fk_seller_info_user
 FOREIGN KEY (user_id)
 REFERENCES "users" (id)
);