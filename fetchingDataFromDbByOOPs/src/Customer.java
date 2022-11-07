import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private  List<CustomerModel> customerModelList = new ArrayList<>();
    public  void createCustomerList(ResultSet result) throws SQLException {

        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String address = result.getString("address");
            CustomerModel customerModel = new CustomerModel(id,name,address);
            customerModelList.add(customerModel);
        }
        generateCustomerHtmlFile();
    }
    private  void generateCustomerHtmlFile() {
        StringBuilder customerHtml = new StringBuilder();
        customerHtml.append("<html>" +
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
                "<th>Id</th>" +
                "<th>Name</th>" +
                "<th>Address</th>" +
                "</tr>");
        for (CustomerModel customer: customerModelList) {
            customerHtml.append("<tr><td>")
                    .append(customer.id)
                    .append("</td><td>")
                    .append(customer.name)
                    .append("</td><td>")
                    .append(customer.address)
                    .append("</td></tr>");
        }
        customerHtml.append("</table>" +
                "</body>" +
                "</html>");
        String htmlToString = customerHtml.toString();

        File f = new File("customer.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(htmlToString);
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
