CREATE TABLE `address` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `Country` varchar(30) NOT NULL,
 `City` varchar(30) NOT NULL,
 `Street` varchar(100) NOT NULL,
 `Floor` int(11) NOT NULL,
 `Flat` int(11) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1