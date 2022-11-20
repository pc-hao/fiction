CREATE TABLE IF NOT EXISTS `userCollection`
(
    `user_id` integer,
    `book_id` integer,
    PRIMARY KEY (user_id ,book_id)
)
DEFAULT CHARSET = utf8;

insert into userCollection (user_id, book_id)
values (1 , 1);
insert into userCollection (user_id, book_id)
values (1 , 2);
insert into userCollection (user_id, book_id)
values (1 , 3);
insert into userCollection (user_id, book_id)
values (3 , 3);
insert into userCollection (user_id, book_id)
values (2 , 2);
insert into userCollection (user_id, book_id)
values (2 , 3);
select * from userCollection;