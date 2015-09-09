# catdating

##### Cat Dating site, Sep. 8, 2015

#### By Andrea Padgett, Hailey Harrison, Leslie Poole, Marie L. Mendez-Nunez

## Description

This application can be used by a cats to find their meow mate.  Cats can join the site and if they find a compatible match, edit and/or delete their profile.  

There is a many-to-many relationship between female and male cats.  A join table, matches, stores these relationships


## Setup

* Database must be created using psql.
  IN PSQL:
  Guest=# CREATE DATABASE dating;
  Guest=# /c dating;
  dating=# CREATE TABLE females (id serial PRIMARY KEY, name varchar, fixed varchar, city varchar, breed varchar);
  dating=# CREATE TABLE males (id serial PRIMARY KEY, name varchar, fixed varchar, city varchar, breed varchar);
  dating=# CREATE TABLE matches (id serial PRIMARY KEY, male_id int, female_id int);
  dating=# CREATE DATABASE dating_test WITH TEMPLATE dating;

* To run tests, enter gradle test.  
* To run program, enter gradle run.

* Dependencies: spark-core 2.1, velocity 1.7, sql2o 1.5.4, postgresql 9.4-1201-jdbc41,
  junit 4.+, fluentlenium-core 0.10.3, fluentlenium-assertj 0.10.3,

## Technologies Used

* HTML/CSS, Java, Sql, Velocity

### Legal
Copyright (c) 2015 Andrea Padgett, Hailey Harrison, Leslie Poole, Marie L. Mendez-Nunez

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
