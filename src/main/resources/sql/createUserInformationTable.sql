CREATE TABLE IF NOT EXISTS `UserInformation`
(
    `user_id`   integer UNSIGNED,
    `user_name` VARCHAR(100) NOT NULL,
    `type`      integer COMMENT '0-读者，1-作者，2-管理员',
    `sex`       varchar(10),
    `email`     varchar(30),
    `national`  varchar(20),
    `signature` varchar(200),
    PRIMARY KEY (user_id)
)
    DEFAULT CHARSET = utf8;

insert into UserInformation
set user_name = 'root',
    type      = 0;