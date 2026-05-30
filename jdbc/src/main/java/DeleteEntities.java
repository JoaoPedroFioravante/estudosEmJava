import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DeleteEntities {
    public static void deleteEmployee(String key){
        String sql = "DELETE FROM employee where id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, key);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static void deleteCompany(int id){
        String sql = "DELETE FROM company WHERE id = ?";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static void deletePaycheck(LocalDate date, String keyEmployee){
        String sql = "DELETE FROM paycheck WHERE employee_id = ? AND data_pagamento = ?";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,keyEmployee);
            preparedStatement.setString(2,date.toString());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
