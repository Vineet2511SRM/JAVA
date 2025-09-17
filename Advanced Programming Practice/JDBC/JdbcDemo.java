package JDBC;
import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "vineet12@11"
            );

            // 3. Statement
            Statement stmt = con.createStatement();

            // 4. Execute
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // 5. Process
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }

            // 6. Close
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
