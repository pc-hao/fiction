CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   integer UNSIGNED AUTO_INCREMENT,
    `user_name` VARCHAR(100) NOT NULL,
    `password`  VARCHAR(40)  NOT NULL,
    `type`      integer comment '用户种类，0-开发者，1-作者，2-读者',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
