CREATE TABLE auth_token (
      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
      token TEXT UNIQUE NULL,
      token_type TEXT NULL,
      revoked INTEGER NULL,
      expired INTEGER NULL,
      user_id UUID NULL,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);