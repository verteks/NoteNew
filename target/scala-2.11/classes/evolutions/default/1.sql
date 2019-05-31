# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table note (
  id                        bigint not null,
  notebook_id               bigint,
  title                     varchar(255),
  author_email              varchar(255),
  message                   varchar(255),
  constraint pk_note primary key (id))
;

create table note_book (
  id                        bigint not null,
  title                     varchar(255),
  author_email              varchar(255),
  constraint pk_note_book primary key (id))
;

create table user (
  email                     varchar(255) not null,
  password_hash             varchar(255),
  salt                      varchar(255),
  constraint pk_user primary key (email))
;

create sequence note_seq;

create sequence note_book_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists note;

drop table if exists note_book;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists note_seq;

drop sequence if exists note_book_seq;

drop sequence if exists user_seq;

