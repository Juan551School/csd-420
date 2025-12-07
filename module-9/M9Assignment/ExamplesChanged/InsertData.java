package databaseTest;

/* 
*
* Professor Darrell Payne
* Bellevue University
*
*/
import java.sql.*;

public class InsertData {

    Connection con;
    Statement stmt;

    public InsertData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false&serverTimezone=UTC";
            String user = "student1";
            String password = "pass";

            con = DriverManager.getConnection(url, user, password);

            // Disable auto-commit so manual COMMIT works
            con.setAutoCommit(false);

            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error connecting to database.");
            e.printStackTrace();
            System.exit(0);
        }

        try {
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(55,'Larry','Rich','1111 Redwing Circle888','Bellevue','NE','68123')")
                + " row updated");

            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(1,'Fine','Ruth','1111 Redwing Circle','Bellevue','NE','68123')")
                + " row updated");

            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(2,'Howard','Curly','1000 Galvin Road South','Bellevue','NE','68005')")
                + " row updated");

            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(3,'Howard','Will','2919 Redwing Circle','Bellevue','NE','68123')")
                + " row updated");

            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(4,'Wilson','Larry','1121 Redwing Circle','Bellevue','NE','68124')")
                + " row updated");

            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(5,'Johnson','George','1300 Galvin Road South','Bellevue','NE','68006')")
                + " row updated");

            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(6,'Long','Matthew','2419 Redwing Circle','Bellevue','NE','68127')")
                + " row updated");

            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(44,'Tom','Matthew','1999 Redwing Circle','Bellevue','NE','68123')")
                + " row updated");

            // Commit the transaction properly
            con.commit();

            System.out.println("Data Inserted");

        } catch (SQLException e) {
            System.out.println("Insert Data Failed");
            e.printStackTrace();

            // Roll back if something fails
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.out.println("Rollback failed");
                ex.printStackTrace();
            }
        }

        try {
            stmt.close();
            con.close();
            System.out.println("Database connections closed");
        } catch (SQLException e) {
            System.out.println("Connection close failed");
        }
    }

    public static void main(String args[]) {
        InsertData insertData = new InsertData();
    }
}
