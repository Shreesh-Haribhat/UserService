create table role (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table token (id bigint not null auto_increment, expire_at datetime(6), is_deleted bit, value varchar(255), user_id bigint, primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, email varchar(255), is_email_verified bit, name varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_roles (user_id bigint not null, roles_id bigint not null) engine=InnoDB;
alter table token add constraint FKe32ek7ixanakfqsdaokm4q9y2 foreign key (user_id) references user (id);
    alter table user_roles add constraint FKj9553ass9uctjrmh0gkqsmv0d foreign key (roles_id) references role (id);
    alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);