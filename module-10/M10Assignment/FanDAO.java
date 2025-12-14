//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//December 14th, 2025
//FanDAO.java (Fan Data Access Object) 

package module10program;

import java.sql.*;

public class FanDAO {

	// The URL and sign in information used 
	private static final String URL =
		    "jdbc:mysql://localhost:3306/databasedb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USER = "student1";
	private static final String PASS = "pass";


    public Fan getFanById(int id) throws SQLException {
        String sql = "SELECT * FROM fans WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Fan(
                        rs.getInt("ID"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("favoriteteam")
                );
            }
        }
        return null;
    }

    public boolean updateFan(Fan fan) throws SQLException {
        String sql =
            "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fan.getFirstName());
            ps.setString(2, fan.getLastName());
            ps.setString(3, fan.getFavoriteTeam());
            ps.setInt(4, fan.getId());

            return ps.executeUpdate() == 1;
        }
    }
}
