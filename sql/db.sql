use api;
-- auto-generated definition
create table interface_info
(
    id             bigint auto_increment comment '主键'
        primary key,
    name           varchar(256)                       not null comment '名称',
    description    varchar(256)                       null comment '描述',
    url            varchar(512)                       not null comment '接口地址',
    requestParams  text                               not null comment'请求参数',
    requestHeader  text                               not null comment '请求头',
    responseHeader text                               not null comment '响应头',
    status         int      default 0                 not null comment '接口状态(0-关闭，1-开启)',
    method         varchar(256)                       not null comment '请求类型',

    userId         bigint                             not null comment '创建人',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除(0-关闭，1-开启)'
)
    comment '接口信息';

insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (0, '赖博文', '黄黎昕', 'www.wilfredo-ratke.name', '田立诚', '杜天翊', 0, '郭浩然', 16, '2022-07-31 12:10:49', '2022-01-24 14:00:25', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (3, '田擎宇', '洪语堂', 'www.sydney-mertz.info', '顾炎彬', '孙浩', 0, '于修杰', 842, '2022-01-08 17:52:25', '2022-04-17 17:17:21', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (4, '张健雄', '刘烨华', 'www.dominick-lang.net', '毛航', '吴瑞霖', 0, '丁擎苍', 47352208, '2022-05-30 15:35:42', '2022-06-22 17:32:01', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (5, '吕文博', '郝明哲', 'www.micah-dibbert.co', '万鹏', '吴越彬', 0, '白琪', 4, '2022-06-02 00:12:26', '2022-08-08 16:09:55', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (6, '蔡熠彤', '邵昊焱', 'www.salley-greenholt.io', '唐煜祺', '钟擎宇', 0, '于荣轩', 853, '2022-05-17 01:02:10', '2022-10-21 00:58:30', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (7, '莫鹤轩', '孙子涵', 'www.sanford-lang.org', '卢智宸', '叶熠彤', 0, '毛博涛', 184171, '2022-03-27 17:45:30', '2022-07-17 08:20:10', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (8, '王雨泽', '韦果', 'www.candice-toy.info', '丁晟睿', '张思', 0, '余志强', 4143300992, '2022-08-18 20:23:13', '2022-03-28 22:26:29', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (9, '邱烨霖', '吕晓博', 'www.aubrey-gutmann.net', '龚雨泽', '韩越泽', 0, '龚晋鹏', 807406, '2022-04-05 21:14:50', '2022-06-13 17:51:56', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (10, '杨越彬', '邱天磊', 'www.manie-wisoky.name', '赖熠彤', '曹语堂', 0, '陶博文', 3668696899, '2022-08-09 20:56:12', '2022-09-29 23:21:19', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (11, '郑嘉懿', '蔡文博', 'www.rima-dooley.net', '叶弘文', '田思源', 0, '白昊天', 49273976, '2022-01-01 05:01:11', '2022-08-30 08:58:57', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (12, '金文轩', '任瑞霖', 'www.sherrell-vandervort.info', '陈懿轩', '沈文', 0, '潘立果', 27973317, '2022-07-08 12:28:42', '2022-10-17 13:21:13', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (13, '龙明哲', '林致远', 'www.kristi-auer.co', '许弘文', '杨哲瀚', 0, '朱哲瀚', 126313986, '2022-08-03 14:36:56', '2022-04-18 07:39:17', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (14, '秦思', '江伟泽', 'www.onie-daniel.io', '谭思源', '武志泽', 0, '孟昊焱', 735945, '2022-08-04 07:03:59', '2022-09-17 17:16:34', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (15, '王风华', '傅越泽', 'www.santo-schroeder.biz', '朱炫明', '梁煜祺', 0, '秦天翊', 68, '2022-09-23 18:31:48', '2022-09-05 14:13:27', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (16, '李鸿涛', '姚子默', 'www.jeana-langosh.io', '尹雨泽', '黄雪松', 0, '林炎彬', 226, '2022-12-25 08:04:22', '2022-09-12 22:48:29', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (17, '邵烨霖', '顾锦程', 'www.laura-mitchell.info', '龚鸿涛', '吴果', 0, '傅驰', 56210, '2022-10-03 09:50:57', '2022-05-31 06:04:43', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (18, '杨鑫鹏', '唐炫明', 'www.marco-lehner.info', '程熠彤', '邱绍辉', 0, '任伟诚', 6, '2022-10-07 10:39:13', '2022-11-29 12:42:16', 0);
insert into `interface_info` (`id`, `name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`, `createTime`, `updateTime`, `isDelete`) values (19, '史锦程', '顾懿轩', 'www.jeanett-mclaughlin.biz', '杜擎宇', '罗远航', 0, '武昊天', 46451614, '2022-02-03 19:30:27', '2022-01-07 23:30:19', 0);


-- 用户调用接口关系表
create table if not exists api.`user_interface_info`
(
    id            bigint auto_increment comment '主键' primary key,
    userId        bigint                             not null comment '调用用户 id',
    interfaceInfo bigint                             not null comment '接口Id',
    totalNum      int      default 0                 not null comment '总调用次数',
    leftNum       int      default 0                 not null comment '剩余调用次数',
    status        int      default 0                 not null comment '0-正常，1-禁用',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除(0-未删，1-已删)'
)comment '用户调用接口关系';

insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (2, 2, 2, 1238, 7378);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (3, 3, 3, 73135469, 20467347);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (4, 4, 4, 7, 65);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (5, 5, 5, 201864902, 57775);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (6, 6, 6, 235873211, 455046);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (7, 7, 7, 1825, 67);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (8, 8, 8, 378385, 520);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (9, 9, 9, 1527610327, 372);
insert into `user_interface_info` (`id`, `userId`, `interfaceInfoId`, `totalNum`, `leftNum`) values (10, 10, 10, 484373649, 15);
