create database event_ticket_management;
create table attendees(
                          attendee_id serial primary key ,
                          attendee_name varchar(80) not null ,
                          email varchar(100) unique
);
create table venues(
    venue_id serial primary key ,
    venue_name varchar(80) not null ,
    location varchar(150)
);
create table events(
    event_id serial primary key ,
    event_name varchar(150) not null ,
    event_date varchar(100) not null ,
    venue_id INTEGER references venues(venue_id)
        on delete cascade on update cascade
);
create table event_attendee(
    id serial primary key ,
    event_id INTEGER not null references events(event_id)
        on delete set null on update cascade ,
    attendee_id INTEGER not null references attendees(attendee_id)
        on delete set null on UPDATE cascade
);

select a.attendee_id, a.attendee_name, a.email
from attendees a
inner join event_attendee ea
on a.attendee_id = ea.attendee_id
where event_id = 2;

drop table events;

insert into attendees values (default, 'JubJub', 'jubjub@gmail.com')