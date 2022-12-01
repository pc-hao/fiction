delimiter $$
create procedure fuzzyQueryBookByName(
	in `name` varchar(200)
)
begin
	select * from book where locate(`name`, book_name) > 0;
end$$