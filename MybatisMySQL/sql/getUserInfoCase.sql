drop table if exists getUserInfoCase;

create table if not exists getUserInfoCase
(
    `id`     int auto_increment primary key not null comment '自增ID',
    userID   int                            not null comment '用户ID',
    expected varchar(100) comment '期望结果'
);

insert into course.getUserInfoCase(userID, expected)
values ('1', 'true'),
       ('0', 'false');

select * from course.getUserInfoCase;