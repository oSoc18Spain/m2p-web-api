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
INSERT INTO machine(change_ultimate, description, line_channel_id) VALUES('2018-07-15 20:00:00','Maquina 01',1);
INSERT INTO machine(change_ultimate, description, line_channel_id) VALUES('2018-07-15 20:00:00','Maquina 01',3);
INSERT INTO machine(change_ultimate, description, line_channel_id) VALUES('2018-07-15 20:00:00','Maquina 02',1);
INSERT INTO machine(change_ultimate, description, line_channel_id) VALUES('2018-07-15 20:00:00','Maquina 01',2);
INSERT INTO machine(change_ultimate, description, line_channel_id) VALUES('2018-07-15 20:00:00','Maquina 02',3);
INSERT INTO machine(change_ultimate, description, line_channel_id) VALUES('2018-07-15 20:00:00','Maquina 02',4);

-- Tarea
INSERT INTO task(code, name, type) VALUES('CLEAN-MACHINE','Limpiar Maquinas','EVENT');

-- Eventos
-- INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','MANTENIMIENTO','pending','MANUAL');
-- INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','LIMPIEZA','pending','MANUAL');
-- INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','LIMPIEZA','in_progress','MANUAL');
-- INSERT INTO event(date, description, state_event, type) VALUES('2018-07-15 20:00:00','LIMPIEZA','done','MANUAL');