
CREATE TABLE category
(
    id    bigint unsigned auto_increment primary key,
    title varchar(250) not null unique
);

CREATE TABLE movie
(
    id            bigint unsigned auto_increment primary key,
    title         varchar(250) not null,
    category_id   bigint unsigned not null,
    description   text,
    imdb_rating   decimal(2,1),
    year          int,
    constraint    fk_movie_category foreign key (category_id) references category (id)
);
