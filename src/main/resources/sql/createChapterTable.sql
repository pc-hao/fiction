CREATE TABLE IF NOT EXISTS `Chapter`
(
    `book_id`      integer,
    `chapter_id`    integer,
    `chapter_name` varchar(200),
    `update_time`   varchar(200),
    `chapter_txt` varchar(1000),
    PRIMARY KEY (book_id, chapter_id)
) DEFAULT CHARSET = utf8;

insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (1, 2, "第二章 傅里叶级数", "2021-5-1",
        "法国数学家傅里叶认为，任何周期函数都可以用正弦函数和余弦函数构成的无穷级数来表示（选择正弦函数与余弦函数作为基函数是因为它们是正交的）。\n后世称傅里叶级数为一种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (1, 1, "第一章 jw带带", "2021-5-2",
        "法国数学家hjw认为，他无所不能。\n后世称hjw级数为一种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (1, 3, "第三章 pc带带", "2021-5-3",
        "法国数学家pc认为，他无所不能。\n后世称hjw级数为一种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (1, 4, "第四章 小立菜菜", "2021-5-4",
        "呜呜，菜菜，带带。\n后世称hjw级数为一种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (2, 2, "第二章 傅数", "2021-5-1",
        "法国数学家的无穷级数来表示（选择正弦函数与余弦函数作为基函数是因为它们是正交的）。\n后世称傅里叶级数为一种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (2, 1, "第一章 j带", "2021-5-2",
        "法国数学家hjw认为，w级数为一种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (2, 3, "第三章 p带", "2021-5-3",
        "法国数学家pjw级数为一种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
insert into chapter (book_id, chapter_id, chapter_name, update_time, chapter_txt)
values (2, 4, "第四章 小菜", "2021-5-4",
        "呜呜，种特殊的三角级数，根据欧拉公式，三角函数又能化成指数形式，也称傅立叶级数为一种指数级数。傅里叶级数好好好好！！！");
