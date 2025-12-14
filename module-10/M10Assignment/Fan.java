//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//December 14th, 2025
//Fan.java 

package module10program;

public class Fan {

    private int id;
    private String firstName;
    private String lastName;
    private String favoriteTeam;

    public Fan(int id, String firstName, String lastName, String favoriteTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteTeam = favoriteTeam;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFavoriteTeam() { return favoriteTeam; }
}
