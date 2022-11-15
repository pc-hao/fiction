CREATE TABLE IF NOT EXISTS `userFocus`
(
    `user_id` integer,
    `author_id`  integer,
    PRIMARY KEY (user_id ,author_id)
)
DEFAULT CHARSET = utf8;

insert into userFocus (user_id, author_id)
values (1 , 3);
insert into userFocus (user_id, author_id)
values (1 , 6);
insert into userFocus (user_id, author_id)
values (1 , 7);
insert into userFocus (user_id, author_id)
values (2 , 8);



