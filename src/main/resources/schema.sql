CREATE TABLE IF NOT EXISTS `apuesta` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `jugador` INT NOT NULL,
    `numero1` NUMERIC(2) NOT NULL,
    `numero2` NUMERIC(2) NOT NULL,
    `numero3` NUMERIC(2) NOT NULL,
    `numero4` NUMERIC(2) NOT NULL,
    `numero5` NUMERIC(2) NOT NULL,
    `numero6` NUMERIC(2) NOT NULL,
    FOREIGN KEY (jugador) REFERENCES jugador(id));

CREATE TABLE IF NOT EXISTS `jugador` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `nombre` NUMERIC(2) NOT NULL,);