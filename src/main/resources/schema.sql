create table netology.CUSTOMERS (
                           id serial primary key,
                           name varchar(255) not null,
                           surname varchar(255) not null,
                           age int not null,
                           phone_number varchar(255)
);
create table netology.ORDERS (
                        id serial primary key,
                        date timestamp DEFAULT NOW(),
                        customer_id int not null,
                        product_name varchar(255),
                        amount int,
                        FOREIGN KEY (customer_id) REFERENCES netology.CUSTOMERS (id)
);