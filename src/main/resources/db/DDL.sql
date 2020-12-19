-- DDL
create table user
(
    id bigint unsigned auto_increment primary key,
    email varchar(250) not null unique,
    password varchar(60) not null,
    name varchar(50) not null
);

CREATE TABLE university
(
    id bigint unsigned auto_increment primary key,
    code varchar(10) not null,
    title varchar(250) not null
);

create table study_program
(
    id bigint unsigned auto_increment primary key,
    title varchar(50) not null unique,
    university_id bigint unsigned not null,
    foreign key (university_id) references university(id)
);

create table person
(
    id bigint unsigned auto_increment primary key,
    name varchar(50) not null,
    surname varchar(50) not null,
    gender varchar(50) not null
);

create table student
(
    id bigint unsigned auto_increment primary key,
    study_type varchar(50) not null,
    date_started DATE not null,
    person_id bigint unsigned not null,
    study_program_id bigint unsigned not null,
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (study_program_id) REFERENCES study_program(id)
);

create table lecturer
(
    id bigint unsigned auto_increment primary key,
    person_id bigint unsigned not null,
    FOREIGN KEY (person_id) REFERENCES person(id)
);

create table module
(
    id bigint unsigned auto_increment primary key,
    title varchar(50) not null unique
);

create table study_program_module
(
    study_program_id bigint unsigned not null,
    module_id bigint unsigned not null,
    FOREIGN KEY (study_program_id) REFERENCES study_program(id),
    FOREIGN KEY (module_id) REFERENCES module(id),
    UNIQUE(study_program_id, module_id)
);

create table module_lecturer
(
    module_id bigint unsigned not null,
    lecturer_id bigint unsigned not null,
    FOREIGN KEY (module_id) REFERENCES module(id),
    FOREIGN KEY (lecturer_id) REFERENCES lecturer(id),
    UNIQUE(module_id, lecturer_id)
);

create table university_lecturer
(
    id bigint unsigned auto_increment primary key,
    level varchar(50) not null,
    salary DECIMAL(8, 2) not null,
    university_id bigint unsigned not null,
    lecturer_id bigint unsigned not null,
    FOREIGN KEY (university_id) REFERENCES university(id),
    FOREIGN KEY (lecturer_id) REFERENCES lecturer(id),
    UNIQUE(university_id, lecturer_id)
);
