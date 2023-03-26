--liquibase formatted sql

--changeset berkyt:initial-schema
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table products
(
    id uuid not null
        constraint products_pkey
            primary key,
    description varchar(255),
    image_url varchar(255),
    name varchar(255),
    price numeric(19,2)
);

alter table products;

create table users
(
    id uuid not null
        constraint users_pkey
            primary key,
    email varchar(255),
    name varchar(255)
);

alter table users;

create table carts
(
    id uuid not null
        constraint carts_pkey
            primary key,
    user_id uuid
        constraint carts_user_fk
            references users
);

alter table carts;

create table carts_products
(
    cart_id uuid not null
        constraint carts_products_carts_fk
            references carts,
    products_id uuid not null
        constraint carts_products_products_fk
            references products,
    constraint carts_products_pkey
        primary key (cart_id, products_id)
);

alter table carts_products;

create table orders
(
    id uuid not null
        constraint orders_pkey
            primary key,
    total_price numeric(19,2),
    user_id uuid
        constraint orders_user_id_fk
            references users
);

alter table orders;

create table orders_products
(
    order_id uuid not null
        constraint orders_products_orders_fk
            references orders,
    products_id uuid not null
        constraint orders_products_products_fk
            references products,
    constraint orders_products_pkey
        primary key (order_id, products_id)
);

alter table orders_products;

