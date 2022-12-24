DELIMITER $$
create function `countCommentByBookId`(book_id int) returns int
begin
    declare sum int;
    select count(*) into sum from `comment` where book_id = `commnet`.book_id;
    return (sum);
end$$
DELIMITER ;