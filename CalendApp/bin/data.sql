-- BCrypt encoded "test"   --> "$2a$10$0iRS.6c1mJBa08Ru/pWdJeizfFObi3bbD4e.JXDrBJcbP0kdl64ca"
-- BCrypt encoded "master" --> "$2a$10$xk76Fs2eNWVQ3nVRhJb0We6QaA27X.tElKf7vxjZG4AqoXcIPZUwi"
insert into user(id, date_created, username, password, enabled, email, first_name, last_name) values (1, {ts '2010-07-22 10:30:00.00'}, 'jsmith', '$2a$10$0iRS.6c1mJBa08Ru/pWdJeizfFObi3bbD4e.JXDrBJcbP0kdl64ca', 1, 'jsmith@example.com', 'John', 'Smith');
insert into user(id, date_created, username, password, enabled, email, first_name, last_name) values (2, {ts '2013-01-19 16:00:00.00'}, 'jedi', '$2a$10$xk76Fs2eNWVQ3nVRhJb0We6QaA27X.tElKf7vxjZG4AqoXcIPZUwi', 1, 'jedi@example.com', 'Luke', 'Skywalker');

insert into role(id, name) values(1, 'ROLE_USER');
insert into role(id, name) values(2, 'ROLE_ADMIN');

insert into user_role(user_id, roles_id) values(1, 1);
insert into user_role(user_id, roles_id) values(2, 1);
insert into user_role(user_id, roles_id) values(2, 2);

insert into tweet(id, user_id, date_created, text) values (1, 1, {ts '2017-01-01 00:00:00.00'}, 'Happy New Year!');
insert into tweet(id, user_id, date_created, text) values (2, 1, {ts '2017-02-14 08:30:00.00'}, 'Happy Valentine''s Day!');
insert into tweet(id, user_id, date_created, text) values (3, 2, {ts '2017-03-01 12:15:00.00'}, 'But I was going into Tosche Station to pick up some power converters!');
insert into tweet(id, user_id, date_created, text) values (4, 2, {ts '2017-03-01 12:25:00.00'}, 'I''m Luke Skywalker, and I''m here to rescue you!');
insert into tweet(id, user_id, date_created, text) values (5, 2, {ts '2017-03-01 12:35:00.00'}, 'I am a Jedi, like my father before me.');
