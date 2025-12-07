package databaseTest;

/*
*
* Professor Darrell Payne
* Bellevue University
*
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "student1";
        String password = "pass";

        try {
            // Load MySQL 8.1.0 JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS address33 ("
                       + "ID INT PRIMARY KEY, "
                       + "LASTNAME VARCHAR(40), "
                       + "FIRSTNAME VARCHAR(40), "
                       + "STREET VARCHAR(40), "
                       + "CITY VARCHAR(40), "
                       + "STATE VARCHAR(40), "
                       + "ZIP VARCHAR(40))";

            stmt.executeUpdate(sql);

            System.out.println("Table created successfully.");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error creating table.");
            e.printStackTrace();
        }
    }
}
