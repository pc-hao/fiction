CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   integer UNSIGNED AUTO_INCREMENT,
    `user_name` VARCHAR(100) NOT NULL,
    `password`  VARCHAR(40)  NOT NULL,
    `type`      integer ,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
