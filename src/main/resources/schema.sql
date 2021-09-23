-- Removes tables
drop table if exists oauth_client_details cascade;
drop table if exists user_cliente;
drop table if exists role;
drop table if exists users;


drop sequence if exists role_id_seq;
drop sequence if exists users_id_seq;
drop sequence if exists cliente_id_seq;


create sequence users_id_seq;
create sequence role_id_seq;
create sequence cliente_id_seq;

create table if not exists oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

create table if not exists users (
    id INTEGER PRIMARY KEY default nextval('users_id_seq' :: regclass) not null,
    user_name VARCHAR(256),
    role VARCHAR(256),
    password VARCHAR(256),
    status VARCHAR(256) default 'active'
);

create table if not exists role (
    id INTEGER PRIMARY KEY default nextval('role_id_seq' :: regclass) not null,
    description VARCHAR(256),
    role_name VARCHAR(256)
);