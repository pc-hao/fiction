CREATE TABLE IF NOT EXISTS `Book`
(
    `book_id`              integer UNSIGNED AUTO_INCREMENT,
    `book_name`            VARCHAR(100) NOT NULL,
    `category`             VARCHAR(30)  NOT NULL,
    `author_id`            integer,
    `restrict_first_type`  integer,
    `restrict_second_type` integer,
    `finish`               integer,
    `bookAbstract`         varchar(1000),
    `updateTime`           varchar(200),
    `startDate`            varchar(200),
    `picLoad`              varchar(200),
    PRIMARY KEY (book_id)
) DEFAULT CHARSET = utf8;

insert into book
set book_name            = '未来世界',
    category             = '你猜我是什么类别',
    author_id            = 10,
    restrict_first_type  = 2,
    restrict_second_type = 1,
    finish               = 1,
    bookAbstract         = '这是一本未来世界小说，已完结',
    updateTime           = '2022-11-21',
    startDate            = '2022-11-21',
    picLoad              = 'shuxuefenxi';

insert into book
set book_name            = '超级科技',
    category             = '你猜我是什么类别',
    author_id            = 10,
    restrict_first_type  = 2,
    restrict_second_type = 2,
    finish               = 1,
    bookAbstract         = '这是一本超级科技小说，已完结',
    updateTime           = '2022-11-21',
    startDate            = '2022-11-21',
    picLoad              = 'shuxuefenxi';

insert into book
set book_name            = '进化变异',
    category             = '你猜我是什么类别',
    author_id            = 10,
    restrict_first_type  = 2,
    restrict_second_type = 3,
    finish               = 2,
    bookAbstract         = '这是一本进化变异小说，未完结',
    updateTime           = '2022-11-21',
    startDate            = '2022-11-21',
    picLoad              = 'shuxuefenxi';

