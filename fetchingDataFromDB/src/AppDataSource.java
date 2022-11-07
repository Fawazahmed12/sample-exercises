import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppDataSource {
    Connection connection;

    public void connect(){
        try{
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/Customer";
            String username = "ems";
            String password = "ems";
            this.connection = DriverManager.getConnection(dbURL, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet executeStatement(String sql) throws Exception {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
    }


}
