package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager1 {

    private static final String URL = "jdbc:mysql://localhost:3306/ecoscoredb";
    private static final String USER = "root";
    private static final String PASSWORD = "Govind@123";

    // ================= CREATE TABLE =================

    public static void createTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS users(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100),
                    emails_sent INT,
                    cloud_storage DOUBLE,
                    streaming_hours DOUBLE,
                    device_hours DOUBLE,
                    total_carbon DOUBLE,
                    eco_score INT,
                    category VARCHAR(50)
                )
                """;

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement st = con.createStatement()
        ) {

            st.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= SAVE REPORT =================

    public static void saveReport(String name,
                                  int emails,
                                  double storage,
                                  double streaming,
                                  double device,
                                  double totalCarbon,
                                  int ecoScore,
                                  String category) {

        String sql = """
                INSERT INTO users
                (name, emails_sent, cloud_storage,
                 streaming_hours, device_hours,
                 total_carbon, eco_score, category)
                VALUES (?,?,?,?,?,?,?,?)
                """;

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setInt(2, emails);
            ps.setDouble(3, storage);
            ps.setDouble(4, streaming);
            ps.setDouble(5, device);
            ps.setDouble(6, totalCarbon);
            ps.setInt(7, ecoScore);
            ps.setString(8, category);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= GET ALL REPORTS =================

    public static ResultSet getAllReports() {

        String sql = "SELECT * FROM users ORDER BY id DESC";

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps = con.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // ================= DELETE REPORT =================

    public static void deleteReport(int id) {

        String sql = "DELETE FROM users WHERE id=?";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= PROFILE DATA =================

    public static ResultSet getProfileData() {

        String sql = """
                SELECT
                    COUNT(*) AS totalReports,
                    AVG(eco_score) AS averageScore,
                    MAX(eco_score) AS bestScore,
                    (SELECT category
                     FROM users
                     ORDER BY eco_score DESC
                     LIMIT 1) AS bestCategory
                FROM users
                """;

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps = con.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

}