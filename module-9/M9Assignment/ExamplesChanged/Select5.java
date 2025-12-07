package databaseTest;

/*
*
* Professor Darrell Payne
* Bellevue University
*
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select5 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databasedb?serverTimezone=UTC";
        String user = "student1";
        String password = "pass";

        String sql = "SELECT * FROM address33 LIMIT 5";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("firstName") + " - " +
                    rs.getString("lastName") + " - " +
                    rs.getString("address")
                );
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
