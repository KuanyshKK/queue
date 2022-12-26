create table queues
(
    id      bigserial       not null primary key,
    code    varchar         not null unique
);

comment on table queues is 'Таблица для сохранения кодов';
comment on column queues.id is 'Id записи';
comment on column queues.code is 'Код записи';

insert into queues(code)
values ('a0a0');
