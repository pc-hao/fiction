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

insert into book (book_name, category, author_id, bookAbstract, updateTime, startDate)
values ('工科数学分析', '数学', 6, '这么简单的题都不会，你也配学数分？', '2022-11-1', '2022-2-31');
insert into book (book_name, category, author_id, bookAbstract, updateTime, startDate)
values ('基础物理实验', '物理', 7, '基础物理实验是国家精品课程', '2022-10-9', '2021-2-30');
insert into book (book_name, category, author_id, bookAbstract, updateTime, startDate)
values ('数据库设计', '计算机科学与技术', 8, '不要偷懒，不要偷懒，不要偷懒', '2021-11-11', '2222-2-2');

