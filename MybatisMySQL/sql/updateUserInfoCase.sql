drop table if exists updateUserInfoCase;

create table if not exists updateUserInfoCase
(
    `id`       int auto_increment primary key not null comment '自增ID',
    userID     int comment '用户ID',
    `username` varchar(100) comment '用户名',
    sex        char(1) comment '性别',
    age        int comment '年龄',
    permission char(1) comment '权限，0：管理员 1：普通用户',
    isDelete   char(1) comment '是否删除，0：正常 1：删除',
    expected   varchar(100) comment '期望结果'
);

insert into course.updateUserInfoCase(userID, username, sex, age, permission, isDelete, expected)
values ('1', '哈哈哈', null, null, null, null, 'true'),
       ('2', null, null, null, null, '0', 'true');

select * from course.updateUserInfoCase;