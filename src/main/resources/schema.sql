create table authors(
      authors_id serial PRIMARY KEY,
      authors_name VARCHAR(100),
      gender VARCHAR(10)
);

CREATE TABLE books(
      books_id serial PRIMARY KEY,
      title VARCHAR(100),
      published_date TIMESTAMP,
      authors_id INT not null,
      constraint fk_key foreign key(authors_id) references authors(authors_id) on update cascade on delete cascade
);

INSERT INTO books(title, published_date, authors_id) VALUES ('History',21-04-2018 , 8),
                                            ('War and Peace', 23-09-2021, 2);

create table categories(
    category_id serial PRIMARY KEY,
     category_name VARCHAR(100) not null
);


create table book_category(
                              books_id int not null ,
                              category_id int not null,
                              PRIMARY KEY (books_id, category_id),
                              constraint fk_book foreign key(books_id) references books(books_id) on update cascade on delete cascade,
                              constraint fk_category foreign key(category_id) references categories(category_id) on update cascade on delete cascade
);


INSERT INTO book_category(books_id, category_id) VALUES (4, 1),
                                                       (7, 2),
                                                       (12, 1),
                                                       (4, 2);
