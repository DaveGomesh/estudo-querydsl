
-- Categorias
INSERT INTO categoria(id_categoria, nome) VALUES(1, 'Terror');
INSERT INTO categoria(id_categoria, nome) VALUES(2, 'Drama');
INSERT INTO categoria(id_categoria, nome) VALUES(3, 'Comédia');

-- Livros (Terror)
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(1, 'It - A coisa', 68.9999999999999999999999999999999999999999, 1, FALSE);
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(2, 'O Exorcista', 44.93, 1, FALSE);
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(3, 'Frankenstein', 47.90, 1, FALSE);

-- Livros (Drama)
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(4, 'O Caçador de Pipas', 35.99, 2, FALSE);
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(5, 'Todas as suas (im)perfeições', 29.89, 2, FALSE);
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(6, 'Como eu era antes de você', 35.00, 2, TRUE);

-- Livros (Comédia)
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(7, 'Como não ser um babaca', 19.90, 3, FALSE);
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(8, 'Ironias do tempo', 34.79, 3, TRUE);
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(9, 'Como ser mulher', 28.30, 3, FALSE);

-- Livro com nome repetido, valor e categoria errada
INSERT INTO livro(id_livro, titulo, valor, fk_categoria, disponivel) VALUES(10, 'Como eu era antes de você', 34.00, 3, TRUE);

-- Cliente
INSERT INTO cliente(id_cliente, nome) VALUES(1, 'Ana');
INSERT INTO cliente(id_cliente, nome) VALUES(2, 'João');
INSERT INTO cliente(id_cliente, nome) VALUES(3, 'Marcos');

-- Emprestimos (id_emprestimo, data_devolucao, data_emprestimo, fk_cliente, fk_livro) 
INSERT INTO emprestimo VALUES(DEFAULT, '2020-03-14', '2020-02-27', 1, 1);
INSERT INTO emprestimo VALUES(DEFAULT, '2020-04-14', '2020-04-11', 1, 1);
INSERT INTO emprestimo VALUES(DEFAULT, '2020-05-02', '2020-04-12', 1, 2);
INSERT INTO emprestimo VALUES(DEFAULT, '2020-05-29', '2020-05-09', 1, 4);
INSERT INTO emprestimo VALUES(DEFAULT, '2020-07-12', '2020-05-30', 1, 5);
INSERT INTO emprestimo VALUES(DEFAULT, '2020-12-25', '2020-06-12', 1, 5);
INSERT INTO emprestimo VALUES(DEFAULT, '2020-12-29', '2020-10-22', 1, 9);

INSERT INTO emprestimo VALUES(DEFAULT, '2021-02-24', '2021-01-13', 2, 3);
INSERT INTO emprestimo VALUES(DEFAULT, '2021-02-16', '2021-02-15', 2, 4);
INSERT INTO emprestimo VALUES(DEFAULT, '2021-06-14', '2021-03-03', 2, 7);
INSERT INTO emprestimo VALUES(DEFAULT, '2021-10-21', '2021-09-07', 2, 9);
INSERT INTO emprestimo VALUES(DEFAULT, '2021-12-07', '2021-12-05', 2, 9);

INSERT INTO emprestimo VALUES(DEFAULT, '2022-01-29', '2022-01-01', 3, 1);
INSERT INTO emprestimo VALUES(DEFAULT, '2022-06-30', '2022-06-15', 3, 7);
INSERT INTO emprestimo VALUES(DEFAULT, '2022-12-31', '2022-12-30', 3, 9);



