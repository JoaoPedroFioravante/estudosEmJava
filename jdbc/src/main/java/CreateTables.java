import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {
    public static void createTables(){
        String tableCompany = "create table if not exists company(\n" +
                "    id NUMERIC,\n" +
                "    nome TEXT,\n" +
                "    constraint comapany_pk primary key(id)\n" +
                ");";
        String tableEmployee = "create table if not exists employee(\n" +
                "    id TEXT,\n" +
                "    nome TEXT not null,\n" +
                "    job_title TEXT not null,\n" +
                "    salary NUMERIC default 1500,\n" +
                "    date_of_employment TEXT default CURRENT_DATE,\n" +
                "    company_id TEXT not null,\n" +
                "    constraint company_employee_fk foreign key(company_id) references company(id) on delete cascade,\n" +
                "    constraint employee_pk primary key(id),\n" +
                "    constraint salary_employee_ck check(salary > 0)\n" +
                ");";
        String tablePaycheck = "create table if not exists paycheck(\n" +
                "    salary NUMERIC,\n" +
                "    employee_id TEXT not null,\n" +
                "    data_pagamento TEXT default CURRENT_DATE,\n" +
                "    constraint paycheck_employee_id_fk foreign key(employee_id) references employee(id) on delete cascade,\n" +
                "    constraint paycheck_pk primary key(employee_id, data_pagamento)\n" +
                ");";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement preparedStatement = connection.prepareStatement(tableCompany);
        PreparedStatement preparedStatementEmployee = connection.prepareStatement(tableEmployee);
        PreparedStatement preparedStatementPaycheck = connection.prepareStatement(tablePaycheck)){
            preparedStatement.execute();
            preparedStatementEmployee.execute();
            preparedStatementPaycheck.execute();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
