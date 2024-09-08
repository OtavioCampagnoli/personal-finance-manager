CREATE TABLE IF NOT EXISTS transaction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,  -- Descrição da transação
    amount DECIMAL(10, 2) NOT NULL,     -- Valor da transação
    transaction_date DATE NOT NULL,     -- Data da transação
    type ENUM('income', 'expense') NOT NULL,  -- Tipo da transação: 'income' (entrada) ou 'expense' (saída)
    category ENUM('salary', 'rent', 'food', 'entertainment', 'utilities', 'investment', 'other') DEFAULT 'other', -- Categoria da transação
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Data de criação
);