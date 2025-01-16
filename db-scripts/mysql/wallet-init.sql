-- Criação da tabela Client
CREATE TABLE IF NOT EXISTS clients (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL
);

-- Criação da tabela Account
CREATE TABLE IF NOT EXISTS accounts (
    id VARCHAR(255) PRIMARY KEY,
    client_id VARCHAR(255),
    balance FLOAT NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

-- Criação da tabela Transaction
CREATE TABLE IF NOT EXISTS transactions (
    id VARCHAR(255) PRIMARY KEY,
    account_from_id VARCHAR(255),
    account_to_id VARCHAR(255),
    amount FLOAT NOT NULL,
    created_at DATETIME NOT NULL,
    FOREIGN KEY (account_from_id) REFERENCES accounts(id),
    FOREIGN KEY (account_to_id) REFERENCES accounts(id)
);

-- Inserindo registros na tabela Client
INSERT INTO clients (id, name, email, created_at, updated_at) VALUES
('client1', 'John Doe', 'john.doe@example.com', NOW(), NOW()),
('client2', 'Jane Smith', 'jane.smith@example.com', NOW(), NOW());

-- Inserindo registros na tabela Account
INSERT INTO accounts (id, client_id, balance, created_at, updated_at) VALUES
('account1', 'client1', 1000.00, NOW(), NOW()),
('account2', 'client2', 2000.00, NOW(), NOW());

-- Inserindo registros na tabela Transaction
INSERT INTO transactions (id, account_from_id, account_to_id, amount, created_at) VALUES
('transaction1', 'account1', 'account2', 150.00, NOW()),
('transaction2', 'account2', 'account1', 50.00, NOW());
