CREATE TABLE otp (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   otp TEXT NULL,
   phone TEXT NULL,
   expiry_date TIMESTAMP,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP
);