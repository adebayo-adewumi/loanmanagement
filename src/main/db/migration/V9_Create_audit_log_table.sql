CREATE TABLE auditlog (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   action TEXT NULL,
   entity TEXT NULL,
   entityId UUID NULL,
   performed_by UUID NULL,
   old_value TEXT NULL,
   new_value TEXT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);