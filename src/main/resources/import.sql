-- 1. INSERTAR ROLES
INSERT INTO roles (id, nombre) VALUES (1, 'TANQUE');
INSERT INTO roles (id, nombre) VALUES (2, 'DPS');
INSERT INTO roles (id, nombre) VALUES (3, 'HEALER');

-- 2. INSERTAR CLASES (Nombres para las imágenes: guerrero.png, pícaro.png, etc.)
INSERT INTO clases (id, name) VALUES (1, 'Guerrero');
INSERT INTO clases (id, name) VALUES (2, 'Paladín');
INSERT INTO clases (id, name) VALUES (3, 'Cazador');
INSERT INTO clases (id, name) VALUES (4, 'Pícaro');
INSERT INTO clases (id, name) VALUES (5, 'Sacerdote');
INSERT INTO clases (id, name) VALUES (6, 'Caballero de la Muerte');
INSERT INTO clases (id, name) VALUES (7, 'Chamán');
INSERT INTO clases (id, name) VALUES (8, 'Mago');
INSERT INTO clases (id, name) VALUES (9, 'Brujo');
INSERT INTO clases (id, name) VALUES (10, 'Monje');
INSERT INTO clases (id, name) VALUES (11, 'Druida');
INSERT INTO clases (id, name) VALUES (12, 'Cazador de Demonios');
INSERT INTO clases (id, name) VALUES (13, 'Evocador');

-- 3. INSERTAR ESPECIALIZACIONES

-- GUERRERO
INSERT INTO especializaciones (id, name, descripcion,descripcion2, clase_id, rol_id) VALUES (1, 'Armas', 'Un maestro del combate con armas de dos manos.','Maestro táctico que domina las armas de dos manos. Utiliza Golpe mortal y Desgarrar para desangrar a sus rivales. Su Tormenta de espadas es devastadora en área, permitiéndole ejecutar a enemigos heridos con una precisión letal y disciplina heroica.', 1, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (2, 'Furia', 'Un berserker que empuña dos armas a la vez.', 1, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (3, 'Protección', 'Un protector incondicional que usa un escudo.', 1, 1);

-- PALADÍN
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (4, 'Sagrado', 'Sana a sus aliados con el poder de la Luz.', 2, 3);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (5, 'Protección_paladin', 'Usa la magia sagrada para protegerse y tanquear.', 2, 1);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (6, 'Reprensión', 'Un cruzado que juzga y castiga con armas a dos manos.', 2, 2);

-- CAZADOR
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (7, 'Bestias', 'Domina a las bestias salvajes para luchar a su lado.', 3, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (8, 'Puntería', 'Un arquero experto que abate enemigos desde lejos.', 3, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (9, 'Supervivencia', 'Un rastreador que usa trampas y explosivos.', 3, 2);

-- PÍCARO
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (10, 'Asesinato', 'Maestro de venenos y ataques mortales.', 4, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (11, 'Forajido', 'Un duelista que usa agilidad y astucia en combate.', 4, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (12, 'Sutileza', 'Un acosador oscuro que ataca desde las sombras.', 4, 2);

-- SACERDOTE
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (13, 'Disciplina', 'Usa la magia sagrada para proteger con escudos.', 5, 3);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (14, 'Sagrado_sacerdote', 'Un sanador versátil que remedia cualquier mal.', 5, 3);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (15, 'Sombra', 'Usa la magia del Vacío para destruir mentes.', 5, 2);

-- CABALLERO DE LA MUERTE
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (16, 'Sangre', 'Un guardián oscuro que manipula la energía vital.', 6, 1);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (17, 'Escarcha_Caballero', 'Un heraldo de la perdición gélido y veloz.', 6, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (18, 'Profano', 'Un maestro de la peste y las sombras.', 6, 2);

-- CHAMÁN
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (19, 'Elemental', 'Un canalizador de las fuerzas de la naturaleza.', 7, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (20, 'Mejora', 'Un guerrero que imbuye sus armas con elementos.', 7, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (21, 'Restauración', 'Utiliza las aguas purificadoras para sanar.', 7, 3);

-- MAGO
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (22, 'Arcano', 'Manipula las energías puras del universo.', 8, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (23, 'Fuego', 'Incinera a los enemigos con bolas de fuego.', 8, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (24, 'Escarcha', 'Congela a los enemigos y los hace añicos.', 8, 2);

-- BRUJO
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (25, 'Aflicción', 'Un maestro de las sombras y maldiciones.', 9, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (26, 'Demonología', 'Invoca demonios para que luchen por él.', 9, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (27, 'Destrucción', 'Llama al fuego del caos para desintegrar rivales.', 9, 2);

-- MONJE
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (28, 'Maestro Cervecero', 'Un tanque que usa el aplazamiento y brebajes.', 10, 1);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (29, 'Tejedor de Niebla', 'Sana a los aliados con nieblas espirituales.', 10, 3);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (30, 'Viajero del Viento', 'Un artista marcial de agilidad incomparable.', 10, 2);

-- DRUIDA
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (31, 'Equilibrio', 'Adopta la forma de lechúcico para lanzar hechizos.', 11, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (32, 'Feral', 'Adopta la forma de un felino para desgarrar.', 11, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (33, 'Guardián', 'Un oso inmenso que protege a sus aliados.', 11, 1);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (34, 'Restauración_Druida', 'Usa la magia de la naturaleza para sanar.', 11, 3);

-- CAZADOR DE DEMONIOS
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (35, 'Devastación_dh', 'Usa la metamorfosis y ataques caóticos.', 12, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (36, 'Venganza', 'Utiliza el fuego interior para tanquear.', 12, 1);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (37, 'Devorador', 'Aprovecha el poder del vacío a su favor', 12, 2);

-- EVOCADOR
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (38, 'Devastación', 'Canaliza el poder de los vuelos rojo y azul.', 13, 2);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (39, 'Preservación', 'Usa los vuelos verde y bronce para rebobinar daño.', 13, 3);
INSERT INTO especializaciones (id, name, descripcion, clase_id, rol_id) VALUES (40, 'Aumento', 'Refuerza a sus aliados con la magia negra.', 13, 2);