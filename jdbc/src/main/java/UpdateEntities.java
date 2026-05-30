import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEntities {
    public static void updateEmploye(Employee employee){
        String sql = "UPDATE employee set salary = ?, job_title = ? where id = ?";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDouble(1,employee.getSalary());
            preparedStatement.setString(2, employee.getJobTitle());
            preparedStatement.setString(3, employee.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static void updateCompany(Company company){
        String sql = "UPDATE company SET nome = ? WHERE id = ?";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, company.getName());
            preparedStatement.setInt(2, company.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
