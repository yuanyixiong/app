/*数据结构发生变动,每天一个数据结构脚本记录*/

-- auto-generated definition
create table app_user.`user_base_info`
(
  id             bigint unsigned                     not null
  comment '主键;用户Id'
    primary key,
  user_pic       varchar(255) default ''             null
  comment '用户头像',
  user_nick_name varchar(255) default ''             null
  comment '用户昵称',
  user_sex       tinyint(1) unsigned default '1'     null
  comment '用户性别:男-1;女-2',
  user_type      tinyint(1) default '1'              not null
  comment '用户类型:真实用户-1;马甲用户-2;游客-3;',
  create_user    bigint                              null,
  create_time    timestamp default CURRENT_TIMESTAMP not null
  comment '创建时间',
  update_user    bigint                              null,
  update_time    timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
  comment '更新时间',
  is_valid       tinyint(1) unsigned default '1'     not null
  comment '是否有效:有效-1;无效-0'
)
  comment '用户基础信息表';

create index idx_user_nick_name
  on user_base_info (user_nick_name);




-- auto-generated definition
create table app_system.`app_sys_config`
(
  id           int auto_increment
  comment '主键ID'
    primary key,
  config_name  varchar(100)                              null
  comment '配置名称',
  config_desc  varchar(2000)                             null
  comment '配置描述',
  config_value varchar(5000)                             null
  comment '配置值',
  create_time  timestamp(3) default CURRENT_TIMESTAMP(3) not null
  comment '创建时间',
  create_user  bigint                                    null
  comment '创建者',
  update_time  timestamp default CURRENT_TIMESTAMP       not null
  on update CURRENT_TIMESTAMP
  comment '更新时间',
  update_user  bigint                                    null
  comment '更新者',
  constraint UK_CONFIG_NAME
  unique (config_name)
)
  comment '相关配置表';

