import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {

    private String url = "jdbc:mysql://remotemysql.com:3306/yNcpq4AoK5";
    private String username = "yNcpq4AoK5";
    private String password = "dWI6zF2ZnB";
    private Connection connection;

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
