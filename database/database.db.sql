BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS jobs (
    job_id INT,
    job_title VARCHAR(30),
    salary INT,
    PRIMARY KEY(job_id)
);
CREATE TABLE IF NOT EXISTS employees (
    employee_id INT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(20),
    phone_number VARCHAR(20),
    sex CHAR(1),
    birth_date DATE,
    profile_img BLOB,
    admin CHAR(1),
    job_id INT,
    department_id INT,
    manager_id INT,
    FOREIGN KEY(job_id) REFERENCES jobs(job_id),
    FOREIGN KEY(department_id) REFERENCES departments(department_id),
    FOREIGN KEY(manager_id) REFERENCES employees(employee_id),
    PRIMARY KEY(employee_id)
);
CREATE TABLE IF NOT EXISTS job_history (
    employee_id INT,
    start_date DATE,
    end_date DATE,
    job_id INT,
    department_id INT,
    FOREIGN KEY(job_id) REFERENCES jobs(job_id),
    FOREIGN KEY(department_id) REFERENCES departments(department_id),
    PRIMARY KEY(employee_id)
);
CREATE TABLE IF NOT EXISTS paid_time_off (
    employee_id INT,
    available_days INT,
    start_date DATE,
    end_date DATE,
    PRIMARY KEY(employee_id)
);
CREATE TABLE IF NOT EXISTS departments (
    department_id INT,
    department_name VARCHAR(20),
    manager_id INT,
    location_id INT,
    FOREIGN KEY(manager_id) REFERENCES employees(employee_id),
    FOREIGN KEY(location_id) REFERENCES locations(location_id),
    PRIMARY KEY(department_id)
);
CREATE TABLE IF NOT EXISTS locations (
    location_id INT,
    street_address VARCHAR(50),
    city VARCHAR(20),
    country VARCHAR(3),
    PRIMARY KEY(location_id)
);
COMMIT;