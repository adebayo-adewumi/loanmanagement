CREATE TABLE customer_loan (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   customer_id UUID NULL,
   amount DECIMAL(10, 2) NULL,
   status TEXT NULL,
   repayment_date TIMESTAMP NULL,
   repayment_amount DECIMAL(10, 2) NULL,
   tenure INTEGER NULL,
   processed_by UUID NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP NULL
);