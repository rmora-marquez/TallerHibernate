DROP DATABASE IF EXISTS orm;
CREATE DATABASE orm;
USE orm;

CREATE TABLE usuarios (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NULL,
  password VARCHAR(200) NULL,
  nombre varchar(50) NOT NULL default '',
  apellidos varchar(200) not null default '', 
  PRIMARY KEY (id),
  UNIQUE KEY (email)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table direcciones(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  direccion VARCHAR(255) NULL,
  colonia VARCHAR(200) NULL,
  ciudad varchar(50) NOT NULL default '',
  pais varchar(200) not null default '', 
  PRIMARY KEY (id),
  CONSTRAINT FK_direcciones_usuarios FOREIGN KEY (id) REFERENCES usuarios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
CREATE TABLE roles (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuario INT(10) UNSIGNED NOT NULL,
  nombreRol VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_user_roles (idUsuario),
CONSTRAINT FK_user_roles FOREIGN KEY (idUsuario) REFERENCES usuarios (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS productos;
CREATE TABLE productos (
  id int(5) unsigned NOT NULL auto_increment,
  nombre varchar(50) NOT NULL default '',
  precio decimal(10,2) default "0",
  cantidad int default "0",
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS pedidos;
CREATE TABLE pedidos (
  id int(5) unsigned NOT NULL auto_increment,
  idProducto int(5) unsigned NOT NULL,
  idCliente int(5) unsigned NOT NULL,
  unidades int(5) unsigned,
  precioventa decimal(10,2) not null default '0',
  total decimal(10,2) default '0',
  PRIMARY KEY  (id),
  foreign key fk_pedidos_productos(idProducto) references productos(id),
  foreign key fk_pedido_clientes(idCliente) references usuarios(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS mercados;
CREATE TABLE mercados (
  id int(5) unsigned NOT NULL auto_increment, 
  ubicacion VARCHAR(200),  
  PRIMARY KEY  (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS mercadoproducto;
CREATE TABLE mercadoproducto (
  idMercado  int(5) unsigned NOT NULL,
  idProducto int(5) unsigned NOT NULL,
  PRIMARY KEY (idProducto, idMercado),
  foreign key fk_mercadoprod_productos(idMercado) references mercados(id),
  foreign key fk_mercadoprod_mercados(idProducto) references productos(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- usuarios
INSERT INTO usuarios VALUES("1", "admin@email.com", "nimda","ADMINISTRADOR","");
INSERT INTO usuarios VALUES("2", "juan@email.com",  "user", "Juan","Perez");
INSERT INTO usuarios VALUES("3", "pepe@email.com",  "user", "Pepe","Sanchez");
INSERT INTO usuarios VALUES("4", "gabi@email.com",  "user", "Gabi","Hernandez");
-- roles
INSERT INTO roles (idUsuario,nombreRol) VALUES ("1", "CLIENTE");
INSERT INTO roles (idUsuario,nombreRol) VALUES ("1", "ADMIN");
INSERT INTO roles (idUsuario,nombreRol) VALUES ("2", "CLIENTE");
INSERT INTO roles (idUsuario,nombreRol) VALUES ("3", "CLIENTE");
INSERT INTO roles (idUsuario,nombreRol) VALUES ("4", "CLIENTE");
-- direcciones
INSERT INTO direcciones VALUES("1", "main server", "", "", "");
INSERT INTO direcciones VALUES("2", "Calle 8",  "El reloj", "CDMX","Mexico");
INSERT INTO direcciones VALUES("3", "25 Sur 335",  "Benito Juarez", "Puebla","Mexico");
INSERT INTO direcciones VALUES("4", "Paloma St 25",  "", "Los Angeles","USA");
-- productos
INSERT INTO productos VALUES("101", "Marco foto plateado","150","20");
INSERT INTO productos VALUES("102", "Figura Marilyn","100","30");
INSERT INTO productos VALUES("103", "Libreta Harry Potter","140","10");
INSERT INTO productos VALUES("104", "Base de madera para teléfono inteligente","135","30");
INSERT INTO productos VALUES("105", "Alcancia en forma de corazón","135","30");
-- pedidos
INSERT INTO pedidos VALUES("1", "101", "2", "5","150", "750");
INSERT INTO pedidos VALUES("2", "104", "2", "1","135", "135");
INSERT INTO pedidos VALUES("3", "102", "3", "2","100", "200");
INSERT INTO pedidos VALUES("4", "103", "4", "4","140", "560");
-- mercados
INSERT INTO mercados VALUES("1","Estados Unidos");
INSERT INTO mercados VALUES("2","Canada");
INSERT INTO mercados VALUES("3","Mexico");
-- mercadoproducto
INSERT INTO mercadoproducto VALUES("1", "101");
INSERT INTO mercadoproducto VALUES("2", "101");
INSERT INTO mercadoproducto VALUES("3", "101");
INSERT INTO mercadoproducto VALUES("1", "102");
INSERT INTO mercadoproducto VALUES("2", "102");
INSERT INTO mercadoproducto VALUES("3", "102");
INSERT INTO mercadoproducto VALUES("1", "103");
INSERT INTO mercadoproducto VALUES("2", "103");
INSERT INTO mercadoproducto VALUES("3", "103");
INSERT INTO mercadoproducto VALUES("1", "104");
INSERT INTO mercadoproducto VALUES("2", "104");
INSERT INTO mercadoproducto VALUES("3", "104");
