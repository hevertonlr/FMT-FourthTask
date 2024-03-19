CREATE DATABASE IF NOT EXISTS biblioteca;

CREATE TABLE IF NOT EXISTS visitante (
    id bigserial PRIMARY KEY,
    nome varchar(255) NOT NULL,
    telefone varchar(15) NULL
);

CREATE TABLE IF NOT EXISTS membro (
    id bigserial PRIMARY KEY,
    nome varchar(255) NOT NULL,
    endereco varchar(170),
    telefone varchar(15)
);
CREATE TABLE IF NOT EXISTS livro (
    id bigserial PRIMARY KEY,
    ano_publicacao varchar(4),
    autor varchar(255) NOT NULL,
    titulo varchar(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS bibliotecario (
    id bigserial PRIMARY KEY,
    email varchar(100) NOT NULL,
    nome varchar(255) NOT NULL,
    senha varchar(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS emprestimo (
    id bigserial PRIMARY KEY,
    data_devolucao timestamp(6),
    data_emprestimo timestamp(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    id_livro int NOT NULL REFERENCES livro(id),
    id_membro int NOT NULL REFERENCES membro(id)
);

