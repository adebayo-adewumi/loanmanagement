CREATE TABLE customer_employer (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   customer_id UUID NULL,
   name TEXT NULL,
   phone TEXT NULL,
   email TEXT NULL,
   address TEXT NULL,
   city TEXT NULL,
   state TEXT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP
);