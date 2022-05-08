drop table if exists course.addUserCase;

create table if not exists course.addUserCase
(
    `id`       int auto_increment primary key not null comment '自增ID',
    `username` varchar(100) comment '用户名',
    `password` varchar(100) comment '密码',
    sex        char(1) check (sex in ('0', '1')) comment '性别，0：男 1：女',
    age        int check (age >= 0 and age <= 100) comment '年龄',
    permission char(1) check (permission in ('0', '1')) comment '权限，0：管理员 1：普通用户',
    isDelete   char(1) check (isDelete in ('0', '1')) comment '是否删除，0：正常 1：删除',
    expected   varchar(10) check (expected in ('true', 'false')) comment '期望结果，true：成功 false：失败'
);

insert into course.addUserCase(username, password, sex, age, permission, isDelete, expected)
values ('芍药', '123456', '1', 23, '1', '0', 'true'),
       (null, '123456', '1', 25, '1', '0', 'false');

select * from course.addUserCase;