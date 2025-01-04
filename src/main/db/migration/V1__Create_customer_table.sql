CREATE TABLE customer (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   firstname TEXT NULL,
   lastname TEXT NULL,
   phone TEXT NULL,
   email TEXT NULL,
   gender TEXT NULL,
   picture TEXT NULL,
   address TEXT NULL,
   city TEXT NULL,
   state TEXT NULL,
   bvn TEXT NULL,
   password TEXT NULL,
   dob TEXT NULL,
   education TEXT NULL,
   marital_status TEXT NULL,
   children TEXT NULL,
   religion TEXT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP
);