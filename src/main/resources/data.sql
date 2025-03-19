-- Insertar jugadores
INSERT INTO jugador (nombre) VALUES ('Juan Pérez');
INSERT INTO jugador (nombre) VALUES ('María López');

-- Insertar apuestas para Juan Pérez (ID = 1)
INSERT INTO apuesta (jugador, numero1, numero2, numero3, numero4, numero5, numero6)
VALUES (1, 5, 12, 23, 34, 41, 49);
INSERT INTO apuesta (jugador, numero1, numero2, numero3, numero4, numero5, numero6)
VALUES (1, 3, 15, 27, 36, 44, 48);

-- Insertar apuestas para María López (ID = 2)
INSERT INTO apuesta (jugador, numero1, numero2, numero3, numero4, numero5, numero6)
VALUES (2, 2, 9, 18, 25, 39, 45);
INSERT INTO apuesta (jugador, numero1, numero2, numero3, numero4, numero5, numero6)
VALUES (2, 7, 14, 20, 33, 37, 42);