# _Management software for a Hair Salon_

#### _A website for a up-and-coming hair salon to execute various tasks relating to tracking stylists and clients to make their day to day life easier. Coded on June 14, 2017_

#### By _**Sowmya Devi Logaswamy**_

## Description

_This is a management software with a dashboard which will allow the managers of a hair salon to execute various tasks relating to tracking stylists and clients to make their day to day life easier. A salon employee needs to be able to view list of stylists, add, update and delete stylists and clients respectively_

## Setup/Installation Requirements

* Enter 'postgres' on a command prompt
* Enter 'psql' in another tab
* In PSQL:
* CREATE DATABASE hair_salon;
* Connect to the database using \c hair_salon;
* CREATE TABLE stylists (id serial PRIMARY KEY, name varchar, description varchar);
* CREATE TABLE clients (id serial PRIMARY KEY, name varchar, address varchar, phone_number int,  stylist_Id int);
* Insert values into the tables stylists and clients.
* CREATE DATABASE hair_salon_test to maintain a separate test database;
* Connect to the database using \c hair_salon_test;

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
