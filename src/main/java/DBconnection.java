
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/BORAJI";
        String username = "admin";
        String password = "admin";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            //Open connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            //Execute statement
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT version()");

            //Get result
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
