CREATE TABLE IF NOT EXISTS veiculos (
id_Veiculo int not null primary key auto_increment,
id_Fabricante int not null,
Nome_Veiculo varchar(255) not null,
modelo varchar(255) not null,
ano varchar(255) not null,
cilindrada int,
cavalos int,
torque int,
imagem varchar(255)not null
);