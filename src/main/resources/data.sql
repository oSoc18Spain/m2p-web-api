-- Roles
INSERT INTO role(name) VALUES('Operador');
INSERT INTO role(name) VALUES('Mecanico');
INSERT INTO role(name) VALUES('QA');

-- Usuarios
INSERT INTO user(id, password, role_id) VALUES('Y987654', 'abc987654', 1);
INSERT INTO user(id, password, role_id) VALUES('Y987653', 'abc987653', 2);
INSERT INTO user(id, password, role_id) VALUES('Y987652', 'abc987652', 3);
INSERT INTO user(id, password, role_id) VALUES('Y987651', 'abc987651', 1);

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