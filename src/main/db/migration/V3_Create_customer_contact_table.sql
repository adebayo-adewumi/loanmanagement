CREATE TABLE customer_contact (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   customer_id UUID NULL,
   name TEXT NULL,
   phone TEXT NULL,
   relationship TEXT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP
);