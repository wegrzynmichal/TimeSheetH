CREATE TABLE task(
  id serial primary key,
  task_name varchar(50) not null,
  description varchar(100) not null,
  start_date timestamp with time zone,
  duration int not null,
  project_id serial not null,
  employee_id serial not null,
  foreign key (project_id) references project(id),
  foreign key (employee_id) references employee(id)
)