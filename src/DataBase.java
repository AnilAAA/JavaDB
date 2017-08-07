import java.sql.*;

public class DataBase {

    static final String DB_URL = "jdbc:mysql://localhost/MyDB";
    static final String USER = "root";
    static final String PASS = "ftd89";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Table");
            statement = connection.createStatement();

            String sql = "SELECT id, nameofproduct, feature, price, subid FROM Product";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nameofproduct = rs.getString("nameofproduct");
                String feature = rs.getString("feature");
                int price = rs.getInt("price");
                int subid = rs.getInt("subid");


                System.out.print("ID: " + id);
                System.out.print(", Name of Product: " + nameofproduct);
                System.out.print(", Feature: " + feature);
                System.out.print(", Price: " + price);
                System.out.println(", SID: " + subid);

            }
            rs.close();

        } catch (SQLException se) {

            se.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if (statement != null)

                    connection.close();

            } catch (SQLException se) {
            }
            try {
                if (connection != null)

                    connection.close();

            } catch (SQLException se) {

                se.printStackTrace();
            }
        }

    }
}