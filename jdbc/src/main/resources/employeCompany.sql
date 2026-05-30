create table if not exists company(
    id NUMERIC,
    nome TEXT,
    constraint comapany_pk primary key(id)
);
create table if not exists employee(
    id TEXT,
    nome TEXT not null,
    job_title TEXT not null,
    salary NUMERIC default 1500,
    date_of_employment TEXT default CURRENT_DATE,
    company_id NUMERIC not null,
    constraint company_employee_fk foreign key(company_id) references company(id) on delete cascade,
    constraint employee_pk primary key(id),
    constraint salary_employee_ck check(salary > 0)
);
create table if not exists paycheck(
    salary NUMERIC,
    employee_id TEXT not null,
    data_pagamento TEXT default CURRENT_DATE,
    constraint paycheck_employee_id_fk foreign key(employee_id) references employee(id) on delete cascade,
    constraint paycheck_pk primary key(employee_id, data_pagamento)
);