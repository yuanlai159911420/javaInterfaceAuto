drop table if exists loginCase;

create table if not exists loginCase
(
    `id`       int auto_increment primary key not null comment '自增ID',
    `username` varchar(100) comment '用户名',
    `password` varchar(100) comment '密码',
    expected   varchar(10) check (expected in ('true', 'false')) comment '预期结果， true：成功 false：失败'
);

insert into course.loginCase(username, password, expected)
values('张三', '123456', 'true'),
      ('李四', '123', 'false');

select * from course.loginCase;