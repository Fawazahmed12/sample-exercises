import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static Connection connection = null;

    public static void myCustomer() {
        try {

        AppDataSource appDataSource = new AppDataSource();
        appDataSource.connect();


        String sql = "SELECT * FROM public.Customer";
        ResultSet result  = appDataSource.executeStatement(sql);

        List<CustomerModel> customerModels = new ArrayList<>();

         while (result.next()) {

                String name = result.getString("name");
                String address = result.getString("address");
                Integer id = result.getInt("id");
                CustomerModel customerModel = new CustomerModel(name, address,id);
                customerModels.add(customerModel);
            }
            generateHTML(customerModels);

        }catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    private static void generateHTML(List<CustomerModel> customerModels) {

        StringBuilder buf = new StringBuilder();
        buf.append("<html>" +
                "<head>" +
                "<style>" +
                "table {" +
                "  font-family: arial, sans-serif;" +
                "  border-collapse: collapse;" +
                "  width: 100%;" +
                "}" +
                "" +"th {" +
                "color:blue;" +
                "}"+
                "td, th {" +
                "  border: 1px solid #dddddd;" +
                "  text-align: left;" +
                "  padding: 8px;" +
                "}" +
                "" +
                "tr:nth-child(even) {" +
                "  background-color: #dddddd;" +
                "}" +
                "</style>" +
                "</head>"+
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th>Name</th>" +
                "<th>Address</th>" +
                "<th>Id</th>" +
                "</tr>");


        for (CustomerModel customerModel: customerModels) {
            buf.append("<tr><td>")
                    .append(customerModel.name)
                    .append("</td><td>")
                    .append(customerModel.address)
                    .append("</td><td>")
                    .append(customerModel.id)
                    .append("</td></tr>");
        }
        buf.append("</table>" +
                "</body>" +
                "</html>");
        String html = buf.toString();

        File f = new File("./index.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(html);
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


}
