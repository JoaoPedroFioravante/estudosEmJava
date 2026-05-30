import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/// setar quem é o pai de employe e paycheck porque ai não precisa da outra entidade
/// quando cadastrar em company ou employee adicionar um campo que seta a chave primaria da entidade
public class AddEntities {
    public static void addEntityPaycheckOfEmployee(Paycheck paycheck){
        String sql = "INSERT OR IGNORE INTO paycheck values(?,?,?)";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setDouble(1, paycheck.getSalary());
            statement.setString(2, paycheck.getIdEmployee());
            statement.setString(3, paycheck.getPayday().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getErrorCode() + "--" + e.getMessage());
        }
    }
    public static void addEntityEmployee(Employee employee){
        String sql =  "INSERT OR IGNORE INTO employee values(?,?,?,?,?,?)";
        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            final PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,employee.getId()) ;
            preparedStatement.setString( 2, employee.getName());
            preparedStatement.setString(3, employee.getJobTitle());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getDateOfEmployment().toString());
            preparedStatement.setInt(6, employee.getIdCompany());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public static void addEntityCompany(Company company){
        String sql =  "INSERT OR IGNORE INTO company values(?,?)";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, company.getId());
            preparedStatement.setString(2, company.getName());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
