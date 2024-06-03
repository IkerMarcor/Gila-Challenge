USE notification;

CREATE TABLE Categories (
id int NOT NULL AUTO_INCREMENT,
fieldname varchar(50) NOT NULL,
creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (id)
);

CREATE TABLE Notifications (
id int NOT NULL AUTO_INCREMENT,
categoryId int NOT NULL,
message varchar(255) NOT NULL,
creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (id),
FOREIGN KEY (categoryId) REFERENCES categories(id)
);

CREATE TABLE Person (
id int NOT NULL AUTO_INCREMENT,
fieldname varchar(50) NOT NULL,
email varchar(35),
phoneNumber varchar(35),
channels SET('sms','email','push'),
creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (id)
);

CREATE TABLE Subscribed (
categoryId int NOT NULL,
personId int NOT NULL,
FOREIGN KEY (categoryId) REFERENCES Categories(id),
FOREIGN KEY (personId) REFERENCES Person(id)
);

INSERT INTO Categories(fieldname)
VALUES ("Sports"),
("Finance"),
("Movies");

INSERT INTO Notifications(categoryId,message)
VALUES (1,"Un videojuego noticia"),
(2,"Encuentran cenizas de Babe ruth");

INSERT INTO Person( fieldname, email, phoneNumber, channels)
VALUES ("foo","foobar@gmail.com","8457845124","sms,email,push"),
("bar","bar@gmail.com","8457775124","sms,push");

INSERT INTO Subscribed(categoryId,personId)
VALUES (1,1),
(1,2),
(2,1);

SELECT * FROM Categories;
SELECT * FROM Notifications;
SELECT * FROM Person;
SELECT * FROM subscribed;

-- Filter by category
SELECT notifications.message, categories.fieldname FROM Notifications
INNER JOIN categories ON notifications.categoryId = categories.id
WHERE categories.fieldname = "Sports";

-- Log of all records sorted from newest to oldest
SELECT notifications.message, categories.fieldname AS category, notifications.creationDate FROM Notifications
INNER JOIN categories ON notifications.categoryId = categories.id
ORDER BY notifications.creationDate DESC;

-- Log of persons name where they get notified depending on the subscribed category
SELECT fieldname FROM person WHERE id IN
( SELECT personId FROM subscribed  WHERE categoryId IN
( SELECT Id FROM categories  WHERE fieldname = "Videogames"));

-- Log of all records sorted from newest to oldest V.2 also shows a record of who is subscribed
SELECT notifications.message, categories.fieldname AS category, person.fieldname AS subscribed, person.channels, notifications.creationDate FROM Notifications
JOIN categories ON notifications.categoryId = categories.id
JOIN subscribed ON categories.id = subscribed.categoryId
JOIN person ON subscribed.personId = person.id
ORDER BY notifications.creationDate DESC;