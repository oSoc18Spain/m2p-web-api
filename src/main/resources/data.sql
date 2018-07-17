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
INSERT INTO linechannel(line_channel_id, type) VALUES(12,'PRODUCCION');
INSERT INTO linechannel(line_channel_id, type) VALUES(23,'ENVASADO');
INSERT INTO linechannel(line_channel_id, type) VALUES(53,'PRODUCCION');
INSERT INTO linechannel(line_channel_id, type) VALUES(7,'ENVASADO');

-- Maquinas
INSERT INTO machine(change_ultimate, description, line_channel_id, line_channel_type) VALUES('2018-07-15 20:00:00','Maquina 01',12,'PRODUCCION');
INSERT INTO machine(change_ultimate, description, line_channel_id, line_channel_type) VALUES('2018-07-15 20:00:00','Maquina 01',53,'PRODUCCION');
INSERT INTO machine(change_ultimate, description, line_channel_id, line_channel_type) VALUES('2018-07-15 20:00:00','Maquina 02',12,'PRODUCCION');
INSERT INTO machine(change_ultimate, description, line_channel_id, line_channel_type) VALUES('2018-07-15 20:00:00','Maquina 01',23,'ENVASADO');
INSERT INTO machine(change_ultimate, description, line_channel_id, line_channel_type) VALUES('2018-07-15 20:00:00','Maquina 02',53,'PRODUCCION');
INSERT INTO machine(change_ultimate, description, line_channel_id, line_channel_type) VALUES('2018-07-15 20:00:00','Maquina 02',7,'ENVASADO');

-- Eventos
INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','MANTENIMIENTO','pending','MANUAL');
INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','LIMPIEZA','pending','MANUAL');
INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','LIMPIEZA','in_progress','MANUAL');
INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','LIMPIEZA','done','MANUAL');