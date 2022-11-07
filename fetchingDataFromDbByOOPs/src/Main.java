import java.sql.*;
import java.util.Scanner;

public class Main {
     static Scanner scanner = new Scanner(System.in);
    private static Connection connection = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Enter the TableName:");
        String tableName = scanner.nextLine();
        Class.forName("org.postgresql.Driver");
        String dbURL = "jdbc:postgresql://localhost:5432/testdb?" + tableName;
        String username = "ems";
        String password = "ems";

        connection = DriverManager.getConnection(dbURL, username, password);

        String sql = "SELECT * FROM public." + tableName;

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (true){
            if (tableName.equalsIgnoreCase("customer")) {
                Customer customer = new Customer();
                customer.createCustomerList(result);
            }
        }
//        switch (tableName) {
//            case "customer":
//                Customer customer = new Customer();
//                customer.createCustomerList(result);
//                break;
//            case "account":
//                Account account = new Account();
//                account.createAccountList(result);
//                break;
//        }
    }
}