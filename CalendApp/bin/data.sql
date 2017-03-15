<<<<<<< HEAD
   
delete from events;
delete from users;
delete from location;


 insert into location(id,street,streetNO,postalcode,city,country) 
 values (1,'wackawacka',12,8045,'Zurich','Schweiz');
 insert into location(id,street,streetNO,postalcode,city,country) 
 values (2,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (3,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (4,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (5,'Alphaweg',122,80045,'LalaCity','alaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (6,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (7,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (8,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (9,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (10,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (11,'Alphaweg',122,80045,'LalaCity','LalaLand');

insert into location(id,street,streetNO,postalcode,city,country) 
values (12,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (13,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (14,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetno,postalcode,city,country) 
values (15,'Alphaweg',122,80045,'LalaCity','LalaLand');
insert into location(id,street,streetNO,postalcode,city,country) 
values (16,'Alphaweg',122,80045,'LalaCity','LalaLand');

 
 insert into users(id, email, location_id, first_name, last_name, password) 
 values (1, 'fake1@fake.com', 1, 'Lola',  'Lolly', 'password');

 insert into users(id, email, location_id, first_name, last_name, password) 
 values (2, 'fake2@fake.com', 2, 'Jenny',  'Jade', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (3, 'fake3@fake.com', 3, 'Delyla', 'Delux', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (4, 'fake4@fake.com', 4, 'Rose',  'Dorn', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (5, 'fake5@fake.com', 5, 'Abbey',  'Broken', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (6, 'fake6@fake.com', 6, 'Francine',  'Smith', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (7, 'fake7@fake.com', 7, 'Pemmela',  'Rock', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (8, 'fake8@fake.com',8, 'Kortney',  'Sweets', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (9, 'fake9@fake.com', 9, 'Jennifer',  'Jody', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (10, 'fake10@fake.com', 10, 'Christy', 'Pew', 'password');

insert into users(id, email, location_id, first_name, last_name, password) 
values (11, 'fake11@fake.com', 11, 'Adolf',  'Hoden', 'password');  

 
 
 


insert into events(id, event_name, creator_id, date, time, description, location_id, open)
 values (6,'party1',5,'2017-01-01','01:01:01','party1 desc',11,true);
 
 insert into events(id, event_name, creator_id, date, time, description, location_id, open)
 values (7,'party2',2,'2017-02-02','02:02:02','party2 desc',9,false);
 
 insert into events(id, event_name, creator_id, date,time, location_id,  description, open) 
 values (1,'DanceNighte', 10, '2017-01-01', '00:00:00',12, 'Happy New Year!',true);
 

insert into events(id, event_name, creator_id, date,time, location_id,  description, open) 
values (2,'Dinner', 9, '2017-02-14', '11:00:00',13, 'Happy Valentine''s Day!',false);

insert into events(id, event_name, creator_id, date,time, location_id,  description, open) 
values (3,'Swinging', 8, '2017-03-01', '09:00:00',14,  'Sometimes all you need is Lupe and Latex!',true);

insert into events(id, event_name, creator_id, date,time, location_id,  description, open) 
values (4,'Consume Coke', 7,'2017-03-01', '05:00:00',15, 'I mean the white Stuff. Heard it tastes like Lemon...',false);

insert into events(id, event_name, creator_id, date,time, location_id,  description, open) 
values (5,'Love a Squirrel', 6,'2017-03-01', '03:00:00',16, 'I want to touch da sqawow *honeybobo 2012*',true);




=======


insert into users(Id, email, location, first_name, last_name, password) values (1, 'fake1@fake.com', 1, 'Lola',  'Lolly', 'password');



insert into users(Id, email, location, first_name, last_name, password) values (2, 'fake2@fake.com', 2, 'Jenny',  'Jade', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (3, 'fake3@fake.com', 3, 'Delyla', 'Delux', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (4, 'fake4@fake.com', 4, 'Rose',  'Dorn', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (5, 'fake5@fake.com', 5, 'Abbey',  'Broken', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (6, 'fake6@fake.com', 6, 'Francine',  'Smith', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (7, 'fake7@fake.com', 7, 'Pemmela',  'Rock', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (8, 'fake8@fake.com',8, 'Kortney',  'Sweets', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (9, 'fake9@fake.com', 9, 'Jennifer',  'Jody', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (10, 'fake10@fake.com', 10, 'Christy', 'Pew', 'password');

insert into users(Id, email, location, first_name, last_name, password) values (11, 'fake11@fake.com', 11, 'Adolf',  'Hoden', 'password');

insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (1,'wackawacka',12,8045,'Zurich','Schweiz','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (2,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (3,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (4,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (5,'Alphaweg',122,80045,'LalaCity','alaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (6,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (7,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (8,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (9,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (10,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (11,'Alphaweg',122,80045,'LalaCity','LalaLand','','');

insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (12,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (13,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (14,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (15,'Alphaweg',122,80045,'LalaCity','LalaLand','','');
insert into location(Id,street,streetno,postalcode,city,country,latitude,longitude) values (16,'Alphaweg',122,80045,'LalaCity','LalaLand','','');


insert into events(Id, event_name, creator, date,time, location,  description, open) values (1,'DanceNight', 10, '2017-01-01', '00:00:00',12, 'Happy New Year!',true);

insert into events(Id, event_name, creator, date,time, location,  description, open) values (2,'Dinner', 9, '2017-02-14', '11:00:00.00',13, 'Happy Valentine''s Day!',false);

insert into events(Id, event_name, creator, date,time, location,  description, open) values (3,'Swinging', 8, '2017-03-01', '9:00:00.00',14,  'Sometimes all you need is Lupe and Latex!',true);

insert into events(Id, event_name, creator, date,time, location,  description, open) values (4,'Consume Coke', 7,'2017-03-01', '5:00:00.00',15, 'I mean the white Stuff. Heard it tastes like Lemon...',false);

insert into events(Id, event_name, creator, date,time, location,  description, open) values (5,'Love a Squirrel', 6,'2017-03-01', '3:00:00.00',16, 'I want to touch da sqawow *honeybobo 2012*',true);

>>>>>>> master
