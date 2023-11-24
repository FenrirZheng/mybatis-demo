-- auto-generated definition
create table user_list
(
    id               bigint unsigned auto_increment
        primary key,
    uid              varchar(50)    default ''                not null comment '用户名',
    pwd              varchar(50)    default ''                not null comment '密码',
    mobile           varchar(20)    default ''                null comment '手机号',
    amount           decimal(20, 2) default 0.00              not null comment '剩余金额',
    register_time    datetime       default CURRENT_TIMESTAMP not null comment '注册时间',
    description      varchar(500)   default ''                null comment '备注',
    status           smallint       default 0                 not null comment '状态: 0未审核 1正常账号 2拒绝申请 3封闭账号',
    last_login_time  datetime       default CURRENT_TIMESTAMP null comment '最后登录时间',
    last_login_ip    varchar(20)    default ''                null comment '最后登录IP',
    robot_process_id varchar(20)    default ''                null comment '机器人程序ID, 此用户的机器人都在此程序上运行',
    invitation_code  varchar(10)    default ''                null comment '注册邀请码',
    register_channel smallint       default 0                 null comment '注册途径: 0自己注册 1管理员注册',
    promote_code     varchar(10)    default ''                null comment '推广邀请码',
    code_expire      datetime       default CURRENT_TIMESTAMP null comment '邀请码到期时间'
);