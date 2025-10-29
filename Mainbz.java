import java.sql.*;//import biblioteki do obsługi bazy danych

public class Mainbz {

    public static void main(String[] args) {
        //String username = "notif";
        String username = "wiktorowski_projekt-programowanie";
        //String password = "notif";
        String password = "m33g08nfg3";
        String dbname = "wiktorowski_projekt-programowanie";
        //String servername = "jdbc:mysql://192.168.236.120:3306/" + dbname;
        String servername = "jdbc:mysql://localhost:1433/" + dbname;
        System.out.println("test");
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(servername, username, password);
            Statement statement;
            statement = connection.createStatement();//połączenie z bazą danych
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from Powiadomienia");

            String ilosc;
            String id;
            String nazwa;
            String opis;
            // wyświetlenie w terminalu
            while (resultSet.next()) {

                id = resultSet.getString("id");
                ilosc = resultSet.getString("ilosc");
                nazwa = resultSet.getString("nazwa");
                opis = resultSet.getString("opis").trim();
                System.out.println("Title : " + id + " Note : " + ilosc + " Time : " + nazwa + " Date : " + opis);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);

        }
        

    }
}
