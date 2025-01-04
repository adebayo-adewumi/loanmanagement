CREATE TABLE admin (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  name TEXT NULL,
  phone TEXT NULL,
  email TEXT NULL,
  password TEXT NULL,
  roleId UUID NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP
);