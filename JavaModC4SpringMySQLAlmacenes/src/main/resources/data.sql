DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS maquinas_registradoras;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS cajeros;


CREATE TABLE IF NOT EXISTS cajeros (
						codigo INT AUTO_INCREMENT,
						nomApels VARCHAR(255) DEFAULT NULL,
						PRIMARY KEY(codigo)
						);
					
CREATE TABLE IF NOT EXISTS productos (
						codigo INT AUTO_INCREMENT,
						nombre VARCHAR(100) DEFAULT NULL,
						precio INT DEFAULT NULL,
						PRIMARY KEY(codigo)
						);
					
CREATE TABLE IF NOT EXISTS maquinas_registradoras (
						codigo INT AUTO_INCREMENT,
						piso INT DEFAULT NULL,
						PRIMARY KEY(codigo)
						);
					
					
CREATE TABLE IF NOT EXISTS ventas (
                        id INT AUTO_INCREMENT,
						cajero INT,
						maquina INT,
						producto INT,
                        PRIMARY KEY(id),
						KEY(cajero, maquina, producto),
                        CONSTRAINT cajero_fk FOREIGN KEY (cajero) REFERENCES cajeros (codigo)
                        ON DELETE CASCADE ON UPDATE CASCADE,
                        CONSTRAINT maquina_fk FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (codigo)
                        ON DELETE CASCADE ON UPDATE CASCADE,
                        CONSTRAINT producto_fk FOREIGN KEY (producto) REFERENCES productos (codigo)
                        ON DELETE CASCADE ON UPDATE CASCADE
						);
						

INSERT INTO cajeros(nomApels) VALUES 	('Juan Antonio Rodriguez Parra'), 
										('Aitor Iglesias Pubill'), 
										('Camila Garcia Perez'), 
										('Javier Perez'), 
										('Francisco Parra'),
										('Josep Maria Valles'),
										('Gustavo Cruz'),
										('Antonio Iglesias Espada'),
										('Pablo Escobar Plata'),
										('Pablo Escobar Plomo');
									
INSERT INTO productos(nombre, precio) VALUES 	('Nevera', 700), 
										('Aire Acondicionad', 500), 
										('Lavadora', 800), 
										('PS5', 750), 
										('Sofa-Cama', 1200),
										('Canasta Basquet', 250),
										('Portatil', 900),
										('Coche',30000),
										('Bicicleta', 550),
										('Carro Compra', 150);
									
INSERT INTO maquinas_registradoras(piso) VALUES (1),(2),(0),(0),(1),(2),(1),(0),(2),(2);

INSERT INTO venta VALUES (1,2,1), (2,2,2),(3,2,3),(4,2,4),(5,2,5),(6,5,6),(7,5,7),(8,5,8),(9,5,9),(10,5,10);