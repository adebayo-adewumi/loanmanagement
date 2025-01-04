CREATE TABLE roles (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   name TEXT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP
);