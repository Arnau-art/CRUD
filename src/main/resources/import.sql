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
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (1, 'Armas', 'Un maestro del combate con armas de dos manos.','Maestro táctico que domina las armas de dos manos. Usa Golpe mortal y Desgarrar para desangrar a sus rivales. Su Tormenta de espadas es devastadora en área.', 1, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (2, 'Furia', 'Un berserker que empuña dos armas a la vez.','Guerrero salvaje que lucha con dos armas y desata una lluvia de golpes brutales. Su furia crece en combate y lo vuelve imparable.', 1, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (3, 'Protección', 'Un protector incondicional que usa un escudo.','Defensor firme que absorbe daño con escudo y armadura pesada. Controla el campo de batalla y protege a sus aliados con disciplina.', 1, 1);

-- PALADÍN
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (4, 'Sagrado', 'Sana a sus aliados con el poder de la Luz.','Sanador guiado por la Luz que mantiene vivos a sus aliados con curas poderosas y bendiciones protectoras en momentos críticos.', 2, 3);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (5, 'Protección_paladin', 'Usa la magia sagrada para protegerse y tanquear.','Guardia sagrado que combina escudo, armadura y magia de la Luz para resistir ataques y mantener la atención de sus enemigos.', 2, 1);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (6, 'Reprensión', 'Un cruzado que juzga y castiga con armas a dos manos.','Justiciero de combate cuerpo a cuerpo que golpea con fuerza sagrada. Castiga a sus enemigos con armas pesadas y poder divino.', 2, 2);

-- CAZADOR
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (7, 'Bestias', 'Domina a las bestias salvajes para luchar a su lado.','Maestro de la fauna que combate junto a sus mascotas. Potencia a sus bestias para desgarrar a los enemigos con ferocidad.', 3, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (8, 'Puntería', 'Un arquero experto que abate enemigos desde lejos.','Francotirador preciso que elimina objetivos a distancia con disparos certeros, gran daño sostenido y control del terreno.', 3, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (9, 'Supervivencia', 'Un rastreador que usa trampas y explosivos.','Cazador astuto que combina trampas, armas y movilidad para hostigar al rival y sobrevivir en cualquier situación.', 3, 2);

-- PÍCARO
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (10, 'Asesinato', 'Maestro de venenos y ataques mortales.','Asesino preciso que aplica venenos y heridas mortales. Aprovecha cada abertura para rematar a sus enemigos con rapidez.', 4, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (11, 'Forajido', 'Un duelista que usa agilidad y astucia en combate.','Luchador oportunista que combina velocidad, trucos y presión constante. Domina el duelo con un estilo agresivo y flexible.', 4, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (12, 'Sutileza', 'Un acosador oscuro que ataca desde las sombras.','Depredador sigiloso que se mueve entre sombras para sorprender a su presa. Acaba con sus rivales antes de que puedan reaccionar.', 4, 2);

-- SACERDOTE
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (13, 'Disciplina', 'Usa la magia sagrada para proteger con escudos.','Sanador defensivo que absorbe daño con barreras y poderes sagrados. Equilibra protección y curación con gran precisión.', 5, 3);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (14, 'Sagrado_sacerdote', 'Un sanador versátil que remedia cualquier mal.','Sanador puro que repara heridas con luz divina. Ofrece curación potente, apoyo constante y respuestas para casi cualquier emergencia.', 5, 3);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (15, 'Sombra', 'Usa la magia del Vacío para destruir mentes.','Adepto del Vacío que corrompe la mente y desgasta al enemigo. Inflige daño oscuro mientras domina con presión psicológica.', 5, 2);

-- CABALLERO DE LA MUERTE
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (16, 'Sangre', 'Un guardián oscuro que manipula la energía vital.','Tanque implacable que roba vida y la convierte en resistencia. Absorbe castigo y se mantiene en pie con poder necrótico.', 6, 1);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (17, 'Escarcha_Caballero', 'Un heraldo de la perdición gélido y veloz.','Guerrero del frío que golpea con brutalidad helada. Combina velocidad, fuerza y poder de escarcha para destruir a sus rivales.', 6, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (18, 'Profano', 'Un maestro de la peste y las sombras.','Especialista en plagas y poder oscuro que convierte la corrupción en arma. Desgasta al enemigo con enfermedades y no-muertos.', 6, 2);

-- CHAMÁN
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (19, 'Elemental', 'Un canalizador de las fuerzas de la naturaleza.','Invocador de relámpagos y tormentas que lanza hechizos devastadores. Canaliza la naturaleza para golpear a distancia con potencia.', 7, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (20, 'Mejora', 'Un guerrero que imbuye sus armas con elementos.','Combatiente cuerpo a cuerpo que refuerza sus armas con poder elemental. Ataca con ritmo feroz y golpes cargados de energía.', 7, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (21, 'Restauración', 'Utiliza las aguas purificadoras para sanar.','Sanador espiritual que usa el agua y la naturaleza para mantener con vida a su grupo. Repara heridas con eficacia y constancia.', 7, 3);

-- MAGO
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (22, 'Arcano', 'Manipula las energías puras del universo.','Mago de poder concentrado que controla la magia arcana con precisión. Desata ráfagas intensas de energía contra un solo objetivo.', 8, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (23, 'Fuego', 'Incinera a los enemigos con bolas de fuego.','Hechicero ofensivo que consume a sus rivales con llamas explosivas. Provoca grandes picos de daño con fuego constante.', 8, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (24, 'Escarcha', 'Congela a los enemigos y los hace añicos.','Mago defensivo y ofensivo que controla el campo con hielo. Detiene a sus enemigos y los rompe con precisión glacial.', 8, 2);

-- BRUJO
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (25, 'Aflicción', 'Un maestro de las sombras y maldiciones.','Drenador de vidas que debilita poco a poco a sus enemigos. Usa maldiciones y daño prolongado para dominar el combate.', 9, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (26, 'Demonología', 'Invoca demonios para que luchen por él.','Invocador oscuro que fortalece a sus demonios para aplastar enemigos. Su poder crece al coordinar magia y criaturas infernales.', 9, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (27, 'Destrucción', 'Llama al fuego del caos para desintegrar rivales.','Brujo explosivo que desata caos y fuego vil sobre sus objetivos. Sus hechizos queman con fuerza brutal y directa.', 9, 2);

-- MONJE
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (28, 'Maestro_Cervecero', 'Un tanque que usa el aplazamiento y brebajes.','Protector ágil que convierte el daño recibido en una carga manejable. Se mantiene firme con esquivas, brebajes y control.', 10, 1);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (29, 'Tejedor_de_Niebla', 'Sana a los aliados con nieblas espirituales.','Sanador marcial que canaliza nieblas místicas para curar con fluidez. Alterna movimiento, apoyo y curación con gran ritmo.', 10, 3);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (30, 'Viajero del Viento', 'Un artista marcial de agilidad incomparable.','Luchador veloz que encadena golpes con precisión y movilidad. Aprovecha su ritmo para castigar al rival sin dar respiro.', 10, 2);

-- DRUIDA
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (31, 'Equilibrio', 'Adopta la forma de lechúcico para lanzar hechizos.','Hechicero natural que alterna energías lunares y solares. Ataca a distancia con magia y cambia de ritmo según la pelea.', 11, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (32, 'Feral', 'Adopta la forma de un felino para desgarrar.','Depredador salvaje que se oculta entre sombras y golpea con garras. Usa velocidad y ferocidad para abatir a su presa.', 11, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (33, 'Guardián', 'Un oso inmenso que protege a sus aliados.','Tanque de la naturaleza que adopta una forma poderosa para resistir daño. Protege al grupo con fuerza, vida y control.', 11, 1);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (34, 'Restauración_Druida', 'Usa la magia de la naturaleza para sanar.','Sanador de la naturaleza que mantiene vivo al grupo con efectos continuos. Sus hechizos restauran vida de forma constante y flexible.', 11, 3);

-- CAZADOR DE DEMONIOS
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (35, 'Devastación_dh', 'Usa la metamorfosis y ataques caóticos.','Guerrero demoníaco que vuela, salta y despedaza con energía vil. Su metamorfosis potencia golpes rápidos y agresivos.', 12, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (36, 'Venganza', 'Utiliza el fuego interior para tanquear.','Tanque demoníaco que convierte su furia en supervivencia. Absorbe daño, se regenera y castiga a quien se acerque.', 12, 1);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (37, 'Devorador', 'Aprovecha el poder del vacío a su favor', 'Acechador del vacío que convierte su poder oscuro en daño directo. Castiga al enemigo con energía extraña y presión constante.', 12, 2);

-- EVOCADOR
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (38, 'Devastación', 'Canaliza el poder de los vuelos rojo y azul.','Destructor dracónico que combina fuego, magia y ataques a distancia. Libera ráfagas poderosas para arrasar a sus enemigos.', 13, 2);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (39, 'Preservación', 'Usa los vuelos verde y bronce para rebobinar daño.','Sanador dracónico que protege y recupera a sus aliados con magia temporal. Repara heridas y corrige el curso de la batalla.', 13, 3);
INSERT INTO especializaciones (id, name, descripcion, descripcion2, clase_id, rol_id) VALUES (40, 'Aumento', 'Refuerza a sus aliados con la magia negra.','Apoyo ofensivo que potencia a sus compañeros con magia dracónica. Mejora el rendimiento del grupo y acelera su impacto.', 13, 2);