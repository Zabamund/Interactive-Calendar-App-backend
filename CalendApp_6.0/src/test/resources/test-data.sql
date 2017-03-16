delete from events;
delete from users;
delete from location;

insert into location(id, street, streetNO, postalcode, city, country)
 values (11,'terra','33','8404','winti','zuri' );
 
insert into location(id, street, streetNO, postalcode, city, country)
 values (22,'haltenreben','43','8408','seuzach','zuri' );
    
 insert into users(id, first_name, last_name, location_id, email, password)
 values (1,'john','smith',11,'j@smith.com','test1' );
 
 insert into users(id, first_name, last_name, location_id, email, password)
 values (2,'jane','doe',22,'j@doe.com','test2' );

insert into events(id, event_name, creator_id, date, time, description, location_id, open)
 values (111,'party1',1,'2017-01-01','01:01:01','party1 desc',11,true);
 
 insert into events(id, event_name, creator_id, date, time, description, location_id, open)
 values (222,'party2',2,'2017-02-02','02:02:02','party2 desc',22,false);
 
