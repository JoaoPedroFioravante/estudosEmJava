import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class GetEntities {
    public static void getAllEmployeesOfCompany(Company company){
        String sql  = "SELECT * FROM employee WHERE company_id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, company.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Optional<Employee> emp = Optional.of(new Employee(
                        resultSet.getString("id"),
                        resultSet.getString("nome"),
                        resultSet.getDouble("salary"),
                        LocalDate.parse(resultSet.getString("date_of_employment")),
                        resultSet.getString("job_title"),
                        resultSet.getInt("company_id")
                ));
                emp.ifPresent(System.out::println);
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public static void getAllPaychecksOfEmployee(Employee employee){
        String sql = "SELECT * FROM paycheck WHERE employee_id = ?";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,employee.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Optional<Paycheck> pay = Optional.of(new Paycheck(
                        LocalDate.parse(resultSet.getString("data_pagamento")),
                        resultSet.getDouble("salary"),
                        resultSet.getString("employee_id")));
                pay.ifPresent(System.out::println);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
