CREATE TABLE IF NOT EXISTS `transaction` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `description` VARCHAR(255) NOT NULL,
    `amount` DECIMAL(10, 2) NOT NULL,
    `date` DATE NOT NULL,
    `type` ENUM('INCOME', 'EXPENSE') NOT NULL,
    `category` ENUM('FOOD', 'TRANSPORT', 'SALARY', 'ENTERTAINMENT', 'HEALTH', 'OTHER') NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
