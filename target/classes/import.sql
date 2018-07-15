-- Roles
INSERT INTO role(name) VALUES('Operador');
INSERT INTO role(name) VALUES('Mecanico');
INSERT INTO role(name) VALUES('Supervisor');

-- Usuarios
INSERT INTO user(password, role_id) VALUES('12345',1);
INSERT INTO user(password, role_id) VALUES('abc12345',1);
INSERT INTO user(password, role_id) VALUES('123',1);
INSERT INTO user(password, role_id) VALUES('123',2);

-- Lineas
INSERT INTO linechanel(name, type) VALUES('Línea 01','PROD');
INSERT INTO linechanel(name, type) VALUES('Línea 02','PROD');
INSERT INTO linechanel(name, type) VALUES('Línea 03','PROD');

-- Maquinas
INSERT INTO machine(change_ultimate, description, linechanel_id) VALUES('2018-07-15 20:00:00','Maquina 01',1);
INSERT INTO machine(change_ultimate, description, linechanel_id) VALUES('2018-07-15 20:00:00','Maquina 02',1);
INSERT INTO machine(change_ultimate, description, linechanel_id) VALUES('2018-07-15 20:00:00','Maquina 03',1);

INSERT INTO machine(change_ultimate, description, linechanel_id) VALUES('2018-07-15 20:00:00','Maquina 04',2);
INSERT INTO machine(change_ultimate, description, linechanel_id) VALUES('2018-07-15 20:00:00','Maquina 05',2);

INSERT INTO machine(change_ultimate, description, linechanel_id) VALUES('2018-07-15 20:00:00','Maquina 06',3);
