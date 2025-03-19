CREATE TABLE IF NOT EXISTS `jugador` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR(50) NOT NULL);

CREATE TABLE IF NOT EXISTS `apuesta` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `jugador` INT,
    `numero1` TINYINT NOT NULL,
    `numero2` TINYINT NOT NULL,
    `numero3` TINYINT NOT NULL,
    `numero4` TINYINT NOT NULL,
    `numero5` TINYINT NOT NULL,
    `numero6` TINYINT NOT NULL,
    FOREIGN KEY (jugador) REFERENCES jugador(id));

