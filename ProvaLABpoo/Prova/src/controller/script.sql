/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */

CREATE TABLE IF NOT EXISTS tb_usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(32)
);



CREATE TABLE IF NOT EXISTS tb_produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    preco DOUBLE PRECISION,
    tipo VARCHAR(50)
);


CREATE TABLE IF NOT EXISTS tb_carrinho (
    id SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL REFERENCES tb_usuario(id),
    id_produto INT NOT NULL REFERENCES tb_produto(id),
    nome_produto VARCHAR(255) NOT NULL,
    preco DOUBLE PRECISION NOT NULL,
    quantidade INT NOT NULL,
    total DOUBLE PRECISION GENERATED ALWAYS AS (preco * quantidade) STORED
   
);


CREATE TABLE IF NOT EXISTS tb_historico (
    id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL REFERENCES tb_usuario(id),
    total DOUBLE PRECISION NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
