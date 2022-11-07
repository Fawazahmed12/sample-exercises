import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<AccountModel> accountModelList = new ArrayList<>();

    public  void createAccountList(ResultSet result) throws SQLException {
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String bankName = result.getString("bankName");
            String city = result.getString("city");
            AccountModel accountModel = new AccountModel(id,name,bankName,city);
            accountModelList.add(accountModel);
        }
        generateAccountHtmlFile();
    }

    private  void generateAccountHtmlFile() {

        StringBuilder accountHtml = new StringBuilder();
        accountHtml.append("<html>" +
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
        for (AccountModel account: accountModelList) {
            accountHtml.append("<tr><td>")
                    .append(account.id)
                    .append("</td><td>")
                    .append(account.name)
                    .append("</td><td>")
                    .append(account.bankName)
                    .append("</td><td>")
                    .append(account.city)
                    .append("</td></tr>");
        }
        accountHtml.append("</table>" +
                "</body>" +
                "</html>");
        String htmlToString = accountHtml.toString();

        File f = new File("account.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(htmlToString);
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
