   
delete from events;
delete from users;
delete from location;

-- location
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

 -- users
 
 insert into users(id, email, location_id, first_name, last_name, password,image) 
 values (1, 'fake1@fake.com', 1, 'Lola',  'Lolly', 'password','https://unsplash.com/photos/swPTbY7v6Ow');

 insert into users(id, email, location_id, first_name, last_name, password,image) 
 values (2, 'fake2@fake.com', 2, 'Jenny',  'Jade', 'password','https://unsplash.com/search/photos/person?photo=T1wpGZhvwUo');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (3, 'fake3@fake.com', 3, 'Delyla', 'Delux', 'password','https://unsplash.com/photos/swPTbY7v6Ow');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (4, 'fake4@fake.com', 4, 'Rose',  'Dorn', 'password','https://unsplash.com/search/photos/person?photo=T1wpGZhvwUo');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (5, 'fake5@fake.com', 5, 'Abbey',  'Broken', 'password','https://unsplash.com/photos/swPTbY7v6Ow');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (6, 'fake6@fake.com', 6, 'Francine',  'Smith', 'password','https://unsplash.com/search/photos/person?photo=T1wpGZhvwUo');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (7, 'fake7@fake.com', 7, 'Pemmela',  'Rock', 'password','https://unsplash.com/photos/swPTbY7v6Ow');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (8, 'fake8@fake.com',8, 'Kortney',  'Sweets', 'password','https://unsplash.com/photos/swPTbY7v6Ow');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (9, 'fake9@fake.com', 9, 'Jennifer',  'Jody', 'password','https://unsplash.com/photos/swPTbY7v6Ow');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (10, 'fake10@fake.com', 10, 'Christy', 'Pew', 'password','https://unsplash.com/photos/swPTbY7v6Ow');

insert into users(id, email, location_id, first_name, last_name, password,image) 
values (11, 'fake11@fake.com', 11, 'Adolf',  'Hoden', 'password','https://unsplash.com/search/photos/person?photo=T1wpGZhvwUo');  

-- events
 
insert into events(id, event_name, creator_id, date,time, location_id,  description, open,image) 
 values (1,'DanceNighter', 10, '2017-01-01', '00:00:00',12, 'Happy New Year!',true,'https://unsplash.com/search/party?photo=vu3cYpSsB9U');
 
insert into events(id, event_name, creator_id, date,time, location_id,  description, open,image) 
values (2,'Dinner', 9, '2017-02-14', '11:00:00',13, 'Happy Valentine''s Day!',false,'https://unsplash.com/search/party?photo=ya631mqQ7Ng');

insert into events(id, event_name, creator_id, date,time, location_id,  description, open,image) 
values (3,'Swinging', 8, '2017-03-01', '09:00:00',14, 'Sometimes all you need is Lupe and Latex!',true,'https://unsplash.com/search/party?photo=ya631mqQ7Ng');

insert into events(id, event_name, creator_id, date,time, location_id,  description, open,image) 
values (4,'Consume Coke', 7,'2017-03-01', '05:00:00',15, 'I mean the white Stuff. Heard it tastes like Lemon...',false,'https://unsplash.com/search/party?photo=Q14J2k8VE3U');

insert into events(id, event_name, creator_id, date,time, location_id,  description, open,image) 
values (5,'Love a Squirrel', 6,'2017-03-01', '03:00:00',16, 'I want to touch da sqawow *honeybobo 2012*',true,'https://unsplash.com/search/party?photo=PAykYb-8Er8');

insert into events(id, event_name, creator_id, date, time, description, location_id, open,image)
 values (6,'party1',5,'2017-01-01','01:01:01','party1 desc',11,true,'https://unsplash.com/search/party?photo=Q14J2k8VE3U');
 
 insert into events(id, event_name, creator_id, date, time, description, location_id, open,image)
 values (7,'party2',2,'2017-02-02','02:02:02','party2 desc',9,false,'https://unsplash.com/search/party?photo=51AhxwkYyHo');
 
 insert into events(id, event_name, creator_id, date, time, description, location_id, open,image)
 values (8,'party3',2,'2017-02-02','02:02:02','party3 desc',9,false,'https://unsplash.com/search/party?photo=--LyFIjXoFY');
 
    
 -- users_friends
 insert into users_friends(user_id,friends_id) values (1,2);
 insert into users_friends(user_id,friends_id) values (1,3);
 insert into users_friends(user_id,friends_id) values (2,5);
 insert into users_friends(user_id,friends_id) values (2,7);
 insert into users_friends(user_id,friends_id) values (2,1);
 insert into users_friends(user_id,friends_id) values (3,1);
  
 -- users_events
 insert into users_events(user_id,events_id)values(1,1);
 insert into users_events(user_id,events_id)values(1,2);
 insert into users_events(user_id,events_id)values(2,5);
 insert into users_events(user_id,events_id)values(2,6);
 insert into users_events(user_id,events_id)values(2,1);
 insert into users_events(user_id,events_id)values(2,2);
 insert into users_events(user_id,events_id)values(2,3);
 insert into users_events(user_id,events_id)values(3,2);
 
 -- events_participants
 insert into events_participants(event_id,participants_id)values(1,1);
 insert into events_participants(event_id,participants_id)values(2,1);
 insert into events_participants(event_id,participants_id)values(5,2);
 insert into events_participants(event_id,participants_id)values(6,2);
 insert into events_participants(event_id,participants_id)values(1,2);
 insert into events_participants(event_id,participants_id)values(2,2);
 insert into events_participants(event_id,participants_id)values(3,2);
 insert into events_participants(event_id,participants_id)values(2,3);
 
 
 
 


