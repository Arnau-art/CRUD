-- ROLES
INSERT INTO Roles (id, nombre) VALUES (1, 'TANQUE');
INSERT INTO Roles (id, nombre) VALUES (2, 'HEALER');
INSERT INTO Roles (id, nombre) VALUES (3, 'DPS');

-- CLASES
INSERT INTO Clases (id, name) VALUES (1, 'Warrior');
INSERT INTO Clases (id, name) VALUES (2, 'Priest');
INSERT INTO Clases (id, name) VALUES (3, 'Rogue');

-- ESPECIALIZACIONES
INSERT INTO Especializaciones (id, name, descripcion, rol_tipo, clase_id, rol_id) VALUES (1, 'Protection', 'Tanque con escudo', 'TANQUE', 1, 1);
INSERT INTO Especializaciones (id, name, descripcion, rol_tipo, clase_id, rol_id) VALUES (2, 'Holy', 'Sanador de luz', 'HEALER', 2, 2);
INSERT INTO Especializaciones (id, name, descripcion, rol_tipo, clase_id, rol_id) VALUES (3, 'Assassination', 'Daño con venenos', 'DPS', 3, 3);