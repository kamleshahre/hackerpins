create table Story (id bigint not null, description varchar(4000) not null, dislikes bigint not null, likes bigint not null, mediaUrl varchar(255), type varchar(255), submittedAt datetime not null, title varchar(255) not null, url varchar(255) not null, version integer not null, primary key (id))
create table Tags (Story_id bigint not null, tags varchar(255))
alter table Story add constraint UK_h2d47v2ijwllh2xxgo02hg1r5  unique (url)
alter table Tags add constraint FK_k19i21qfe12kss0t9q4gxsc5l foreign key (Story_id) references Story (id)
create table hibernate_sequence ( next_val bigint )
insert into hibernate_sequence values ( 1 )
