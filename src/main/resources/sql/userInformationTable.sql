CREATE TABLE IF NOT EXISTS `UserInformation`
(
    `user_id`   integer UNSIGNED AUTO_INCREMENT,
    `user_name` VARCHAR(100) NOT NULL,
    `password`  VARCHAR(40)  NOT NULL,
    `type`      integer,
    `sex` varchar(10),
    `email` varchar(30),
    `national` varchar(20),
    `signature` varchar(200),
    PRIMARY KEY (user_id)
)
DEFAULT CHARSET = utf8;

insert into userInformation values(1,'小立','1234567',1,'男','20373496@buaa.edu.cn','中国','金威哥哥带带');
insert into userInformation values(2,'小姝','12345678',3,'女','无','china','1+2=3');
insert into userInformation values(3,'xiaoli','1234567',1,'男','20373496@buaa.edu.cn','中国','金威哥哥带带');
insert into userInformation values(4,'xiaoshu','12345678',3,'女','无','china','1+2=3');
insert into userInformation (user_name,password,type,sex,email,national,signature)
values('杨小远','yangxiaoyuan',1,'女','098765','china','我是666');
insert into userInformation (user_name,password,type,sex,email,national,signature)
values('王文玲','wangwenlin',1,'女','098765','china','我是小蜗牛');
insert into userInformation (user_name,password,type,sex,email,national,signature)
values('刘瑞','liurui',1,'男','098765','china','lr yyds');