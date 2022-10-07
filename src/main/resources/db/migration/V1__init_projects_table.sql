create table project(
    id serial primary key,
    project_name varchar(50) not null,
    description varchar(100) not null,
    manager_id serial not null,
    start_date timestamp with time zone
);

CREATE TABLE employee(
  id serial primary key,
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL
);

CREATE TABLE employee_project(
  employee_id serial NOT NULL,
  project_id serial NOT NULL,
  PRIMARY KEY (employee_id,project_id),
  constraint employee_project_fkey1 foreign key (employee_id)
  references employee(id),
  constraint employee_project_fkey2 foreign key (project_id)
  references project(id)
);