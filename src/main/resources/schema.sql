CREATE TABLE IF NOT EXISTS tasks (
  id SERIAL PRIMARY KEY,
  userId INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  completed BOOLEAN DEFAULT false
)