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

INSERT INTO
	DEPARTMENTS(name)
VALUES
	('Tech support'),
	('HR'),
	('Dev department');

INSERT INTO
	EMPLOYEES(first_name, last_name, job_title, gender, date_of_birth)
VALUES
	('Alla', 'Kognitok', 'Cleaner', 'FEMALE', '10.11.1975'),
	('Larissa', 'Labuda', 'Cleaner', 'FEMALE', '25.05.1978'),
	('Vasiliy', 'Vasilyevich', 'Repairer', 'MALE', '15.08.1969');

INSERT INTO
	EMPLOYEES(first_name, last_name, job_title, department_id, gender, date_of_birth)
VALUES
	('Katya', 'Pushkina', 'HR assistant', 2, 'FEMALE', '22.04.1990'),
	('Roza', 'Kapushkina', 'Senior HR', 2, 'FEMALE', '11.09.1989'),
	('Oleg', 'Murashko', 'Support specialist', 1, 'MALE', '10.08.1978'),
	('Roman', 'Senkevich', 'Support specialist', 1, 'MALE', '09.07.1988'),
	('Maksim', 'Shurygin', 'Support specialist', 1, 'MALE', '06.11.1998'),
	('Artem', 'Butyagin', 'Junior Java Developer', 3, 'MALE', '07.01.1999'),
	('Oleg', 'Krisevich', 'Middle Java Developer', 3, 'MALE', '16.06.1995'),
	('Sergey', 'Zdasykevich', 'Senior Java Developer', 3, 'MALE', '25.05.1993'),
	('Vladimir', 'Milauskas', 'Team Lead', 3, 'MALE', '02.10.1990');
