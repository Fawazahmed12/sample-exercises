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

public class Account {

    private static Connection connection = null;

    public static void myAccount (){
        System.out.println("hi");

        try {
            AppDataSource appDataSource = new AppDataSource();
            appDataSource.connect();

            String sql = "SELECT * FROM public.Account";

            ResultSet result = appDataSource.executeStatement(sql);


            List<Integer> ids = new ArrayList<>();
            List<String> names = new ArrayList<>();
            List<String> bankNames = new ArrayList<>();
            List<String> cities = new ArrayList<>();

            while (result.next()) {
                Integer Id = result.getInt("id");
                ids.add(Id);

                String Name = result.getString("name");
                names.add(Name);

                String BankName = result.getString("bankName");
                bankNames.add(BankName);

                String City = result.getString("city");
                cities.add(City);
            }
            getAccountRecords(ids,names,bankNames,cities);

        }catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    private static void getAccountRecords(List<Integer> ids, List<String> names, List<String> bankNames, List<String> cities) {

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
                "<th>Id</th>" +
                "<th>Name</th>" +
                "<th>BankName</th>" +
                "<th>City</th>" +
                "</tr>");
        for (int i = 0; i < bankNames.size(); i++) {
            buf.append("<tr><td>")
                    .append(ids.get(i))
                    .append("</td><td>")
                    .append(names.get(i))
                    .append("</td><td>")
                    .append(bankNames.get(i))
                    .append("</td><td>")
                    .append(cities.get(i))
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
