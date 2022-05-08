drop table if exists course.user;

CREATE table if not exists course.`user`
(
    `id`       INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '自增ID',
    username     varchar(100)                   not null comment '姓名',
    `password` varchar(100)                   not null comment '密码',
    age        int check (age >= 0 and age <= 100) comment '年龄',
    sex        char(1) check (sex in ('0', '1')) comment '性别，0:男 1:女',
    permission char(1) check (permission in ('0', '1')) comment '权限，0:管理员 1:普通用户',
    isDelete   char(1) check (isDelete in ('0', '1')) comment '用户是否被删除，0:正常   1:删除'
);

insert into course.user(`username`, `password`, age, sex, permission, isDelete)
values ('张三', 123456, 20, 0, 0, 0),
       ('李四', 123456, 25, 0, 1, 0),
       ('王五', 123456, 26, 1, 1, 0),
       ('赵六', 123456, 27, 0, 1, 0);

select * from course.user;