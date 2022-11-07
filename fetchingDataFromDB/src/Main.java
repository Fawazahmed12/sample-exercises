import java.sql.Connection;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            System.out.println("Enter choice");
            System.out.println("1.Customer record");
            System.out.println("2.Account record");
            int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                Customer.myCustomer();
                break;
            case 2:
                Account.myAccount();
                break;
            default:
                break;
        }
    }
}