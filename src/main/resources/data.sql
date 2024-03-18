INSERT INTO bibliotecario (email, nome, senha)
VALUES ('alice.silva@gmail.com', 'Alice Silva', 'senha123'),
       ('bruno.oliveira@yahoo.com.br', 'Bruno Oliveira', 'acesso456'),
       ('carla.rodrigues@hotmail.com', 'Carla Rodrigues', 'seguranca789'),
       ('daniel.santos@outlook.com', 'Daniel Santos', 'biblioteca2024'),
       ('elaine.almeida@globo.com', 'Elaine Almeida', 'livros123'),
       ('felipe.costa@uol.com.br', 'Felipe Costa', 'acervo567'),
       ('gabriela.pereira@terra.com', 'Gabriela Pereira', 'leitura890'),
       ('henrique.campos@bol.com.br', 'Henrique Campos', 'admin123'),
       ('isadora.martins@ig.com.br', 'Isadora Martins', 'livrosdigitais'),
       ('joao.rocha@r7.com', 'João Rocha', 'bibliotecario456');


INSERT INTO livro (ano_publicacao, autor, titulo)
VALUES ('2019', 'Haruki Murakami', 'Kafka à Beira-Mar'),
       ('2007', 'J.K. Rowling', 'Harry Potter e as Relíquias da Morte'),
       ('1960', 'Harper Lee', 'O Sol é para Todos'),
       ('1984', 'George Orwell', '1984'),
       ('2003', 'Dan Brown', 'O Código Da Vinci'),
       ('1949', 'George Orwell', 'A Revolução dos Bichos'),
       ('1997', 'J.K. Rowling', 'Harry Potter e a Pedra Filosofal'),
       ('2010', 'Stieg Larsson', 'Os Homens que Não Amavam as Mulheres'),
       ('1865', 'Lewis Carroll', 'Alice no País das Maravilhas'),
       ('2005', 'Khaled Hosseini', 'O Caçador de Pipas');

INSERT INTO membro (endereco, nome, telefone)
VALUES ('Rua das Flores, 123', 'Miguel Silva', '(11) 91234-5678'),
       ('Avenida dos Coqueiros, 456', 'Helena Santos', '(21) 98765-4321'),
       ('Travessa das Palmeiras, 789', 'Arthur Souza', '(31) 92345-6789'),
       ('Praça das Acácias, 101', 'Laura Oliveira', '(41) 5555-1234'),
       ('Alameda dos Ipês, 202', 'Gabriel Pereira', '(51) 99988-7777'),
       ('Viela das Mangueiras, 303', 'Sophia Costa', '(61) 44455-6666'),
       ('Estrada das Palmas, 404', 'Davi Almeida', '(71) 77788-9999'),
       ('Rodovia dos Pinheiros, 505', 'Valentina Ribeiro', '(81) 55556-78'),
       ('Avenida das Oliveiras, 606', 'Bernardo Barbosa', '(85) 12345-6789'),
       ('Rua dos Jacarandás, 707', 'Isabela Castro', '(91) 98765-4321');

INSERT INTO visitante (nome, telefone)
VALUES ('Miguel Silva', '(11) 91234-5678'),
       ('Helena Santos', '(21) 98765-4321'),
       ('Arthur Souza', '(31) 92345-6789'),
       ('Laura Oliveira', '(41) 5555-1234'),
       ('Gabriel Pereira', '(51) 99988-7777'),
       ('Sophia Costa', '(61) 44455-6666'),
       ('Davi Almeida', '(71) 77788-9999'),
       ('Valentina Ribeiro', '(81) 55556-78'),
       ('Bernardo Barbosa', '(85) 12345-6789'),
       ('Isabela Castro', '(91) 98765-4321');

INSERT INTO emprestimo (data_devolucao, data_emprestimo, id_livro, id_membro)
VALUES ('2024-03-20 14:00:00', '2024-03-15 10:30:00', 1, 1),
       (NULL, '2024-03-16 09:15:00', 2, 2),
       ('2024-03-22 16:45:00', '2024-03-18 11:20:00', 3, 3),
       ('2024-03-25 12:30:00', '2024-03-20 14:45:00', 4, 4),
       ('2024-03-28 18:30:00', '2024-03-23 13:10:00', 5, 5),
       ('2024-03-30 10:00:00', '2024-03-25 08:30:00', 6, 6),
       ('2024-04-02 14:30:00', '2024-03-28 11:15:00', 7, 7),
       ('2024-04-05 16:00:00', '2024-03-30 13:45:00', 8, 8),
       ('2024-04-08 11:45:00', '2024-04-03 09:30:00', 9, 9),
       ('2024-04-10 09:30:00', '2024-04-05 07:15:00', 10, 10);
