CREATE TABLE DEPARTMENTS(
   DEPARTMENT_ID   SERIAL PRIMARY KEY,
   NAME TEXT      NOT NULL
);
CREATE TABLE EMPLOYEES(
   EMPLOYEE_ID  SERIAL PRIMARY KEY,
   first_name           TEXT      NOT NULL,
   last_name           TEXT      NOT NULL,
   department_id int,
   job_title           TEXT      NOT NULL,
   gender           TEXT      NOT NULL,
	date_of_birth           date      NOT NULL,
   CONSTRAINT fk_employees_departments
      FOREIGN KEY (department_id)
	  REFERENCES departments(department_id)

);
