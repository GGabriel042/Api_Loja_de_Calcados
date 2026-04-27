CREATE TABLE calcados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(255) NOT NULL UNIQUE,
    nome VARCHAR(255) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    descricao TEXT,
    material VARCHAR(255) NOT NULL,
    tamanho VARCHAR(50) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    cor VARCHAR(100) NOT NULL,
    peso_medio DECIMAL(10, 2) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL DEFAULT 0
);