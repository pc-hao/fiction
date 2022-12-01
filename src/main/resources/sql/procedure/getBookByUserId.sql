delimiter $$
create procedure GetBookByUid(
    in userId integer
)
begin
    select * from book where author_id = userId;
end$$