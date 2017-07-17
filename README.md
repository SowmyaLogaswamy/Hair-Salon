# _Management software for a Hair Salon_

#### _A website for a up-and-coming hair salon to execute various tasks relating to tracking stylists and clients to make their day to day life easier. Coded on June 14, 2017_

#### By _**Sowmya Devi Logaswamy**_

## Description

_This is a management software with a dashboard which will allow the managers of a hair salon to execute various tasks relating to tracking stylists and clients to make their day to day life easier. A salon employee needs to be able to view list of stylists, add, update and delete stylists and clients respectively_

## Installation

```
$ git clone https://github.com/SowmyaLogaswamy/Hair-Salon.git
$ cd Hair-Salon
```

Install postgres:
```
$ postgres
```

Launch psql:
```
$ psql
```

Create databases:
```
Guest=# CREATE DATABASE hair_salon;
Guest=# CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;
```

Connect databases:
```
Guest=# \c hair_salon;
Guest=# \c hair_salon_test;
```

Create tables:
```
hair_salon=# CREATE TABLE stylists (id serial PRIMARY KEY, name varchar, description varchar);
hair_salon=# CREATE TABLE clients (id serial PRIMARY KEY, name varchar, address varchar, phone_number int,  stylist_id int);
```

Run the webserver:
```
$ gradle run
```

Navigate to `localhost:4567` in browser.

## Code Specs

|Behavior - Plain English|
|---|
|* _See a list of all our stylists and clients_|
|* _Add new stylists to our system when they are hired_|
|* _Add new clients to a specific stylist_|
|* _Update a stylist's details_|
|* _Update a client's details_|
|* _Delete a stylist if they're no longer employed here_|
|* _Delete a client if they no longer visit our salon_|

## Known Bugs

_No known issues or bugs at this time_

## Support and contact details

_Please contact at sowmyalogaswamy@gmail.com for any questions, feedback, or concerns._

## Technologies Used

_HTML, CSS, Java, Gradle, Spark, Velocity Template Engine, JUnit Testing, Postgres, SQL_

### License

*This software operates under the MIT license.*

Copyright (c) 2017 **_Sowmya Devi Logaswamy_**
