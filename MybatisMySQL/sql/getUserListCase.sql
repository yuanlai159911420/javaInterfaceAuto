drop table if exists getUserListCase;

create table if not exists getUserListCase
(
    `id`       int auto_increment primary key not null comment '自增ID',
    `username` varchar(100) comment '用户名',
    age        int comment '年龄',
    sex        char(1) comment '性别',
    expected   varchar(100) comment '预期结果'
);

insert into course.getUserListCase(username, age, sex, expected)
VALUES ('张三', 20, '0', 'true'),
       ('李四', null, null, 'true'),
       (null, 25, null, 'true'),
       (null, null, '1', 'true');

select * from course.getUserListCase;