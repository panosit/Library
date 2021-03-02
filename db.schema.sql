CREATE TABLE `user`(
            `username` varchar(50) NOT NULL,
            `password` varchar(100) NOT NULL,
            `enabled` tinyint(1) NOT NULL,
            PRIMARY KEY (`username`)
);

CREATE TABLE `authorities`(
          `username` varchar(50) NOT NULL,
         `authority` varchar(50) NOT NULL,
        UNIQUE KEY `ix_auth_username` (`username`,`authority`),
        CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE
);

CREATE TABLE `book`(
                `id` int unsigned NOT NULL AUTO_INCREMENT,
                `username` varchar(50) NOT NULL,
                `AUTHOR` varchar(30) NOT NULL,
                `TITLE` varchar(30) NOT NULL,
                `GENRE` varchar(30) NOT NULL,
                `PRICE` float NOT NULL,
                PRIMARY KEY (`id`),
               KEY `username` (`username`),
         CONSTRAINT `book_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
             ON DELETE CASCADE ON UPDATE CASCADE
);