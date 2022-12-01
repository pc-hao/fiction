DELIMITER $$
create function `countCommentByBookId`(book_id int) returns int
begin
    declare sum int;
    select count(*) into sum from `comment` where book_id = userCollection.book_id;
    return (sum);
end$$
DELIMITER ;