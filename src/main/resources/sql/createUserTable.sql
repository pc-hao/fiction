CREATE TABLE IF NOT EXISTS `UserLogin`
(
    `user_id`   integer UNSIGNED AUTO_INCREMENT,
    `user_name` VARCHAR(100) NOT NULL UNIQUE KEY,
    `password`  VARCHAR(40)  NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

insert into UserLogin
set user_name = 'root',
    password  = '123456';
