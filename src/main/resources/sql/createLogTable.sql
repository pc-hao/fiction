CREATE TABLE IF NOT EXISTS `Log`
(
    `log_id`    integer UNSIGNED AUTO_INCREMENT,
    `user_id`   integer NOT NULL,
    `type`      integer comment '操作类型，包括增删改查, 1-insert, 2-delete, 3-update, 4-select',
    `table`     varchar(100) comment '操作表的名称',
    `parameter` varchar(200),
    `startDate` varchar(200),
    PRIMARY KEY (log_id)
) DEFAULT CHARSET = utf8;