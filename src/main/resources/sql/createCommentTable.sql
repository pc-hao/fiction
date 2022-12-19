CREATE TABLE IF NOT EXISTS `Comment`
(
    `comment_id`   integer UNSIGNED AUTO_INCREMENT,
    `book_id`      integer,
    `user_id`      integer,
    `comment_time` varchar(200),
    `text`         varchar(1000),
    PRIMARY KEY (comment_id)
) DEFAULT CHARSET = utf8;

insert into Comment (book_id, user_id, comment_time, text)
values (1, 1, "2022-11-1", "垃圾学科，狗都不学1 1");
insert into Comment (book_id, user_id, comment_time, text)
values (1, 2, "2022-11-1", "垃圾学科，狗都不学1 2");
insert into Comment (book_id, user_id, comment_time, text)
values (1, 3, "2022-11-1", "垃圾学科，狗都不学1 3");
insert into Comment (book_id, user_id, comment_time, text)
values (2, 1, "2022-11-1", "垃圾学科，狗都不学2 1");
insert into Comment (book_id, user_id, comment_time, text)
values (2, 2, "2022-11-1", "垃圾学科，狗都不学2 2");
insert into Comment (book_id, user_id, comment_time, text)
values (2, 3, "2022-11-1", "垃圾学科，狗都不学2 3");
insert into Comment (book_id, user_id, comment_time, text)
values (3, 2, "2022-11-1", "垃圾学科，狗都不学3 2");