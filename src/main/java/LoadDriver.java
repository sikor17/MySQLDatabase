import java.sql.Connection;
import java.sql.DriverManager;

public class LoadDriver {
    private String driver = "com.mysql.cj.jdbc.Driver";

    public void loadDriver() {

        try {
            Class c = Class.forName(driver);
            System.out.println("Ladowanie sterownika JDBC");
            System.out.println("Pakiet: " + c.getPackage());
            System.out.println("Nazwa klasy: " + c.getName());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        System.out.println("Sterownik załadowany");

    }
}
