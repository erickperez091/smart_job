create table if not exists user_(
    id varchar(255) primary key,
    email varchar(255),
    password varchar(255),
    created timestamp,
    modified timestamp,
    last_login timestamp,
    token varchar(255),
    active boolean
);

create table if not exists phone(
    id varchar(255) primary key,
    number varchar(255),
    cityCode varchar(255),
    countryCode varchar(255),
    user_id varchar(255),
    foreign key (user_id) references user_(id)
);

