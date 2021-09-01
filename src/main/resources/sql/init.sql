CREATE TABLE DEPARTMENTS(
   department_id   SERIAL PRIMARY KEY,
   name            TEXT NOT NULL
);

CREATE TABLE EMPLOYEES(
   employee_id      SERIAL PRIMARY KEY,
   first_name       TEXT,
   last_name        TEXT,
   department_id    INT,
   job_title        TEXT,
   gender           TEXT,
   date_of_birth    DATE,
   CONSTRAINT fk_employees_departments
      FOREIGN KEY (department_id)
	  REFERENCES departments(department_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE SET NULL
        NOT VALID

);