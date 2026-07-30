package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/ecoscoredb";
    private static final String USER = "root";
    private static final String PASSWORD = "Govind@123";

    // ================= LOGIN =================

    public boolean login(String username, String password) {

        String sql = "SELECT * FROM users_login WHERE username = ? AND password = ?";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= REGISTER =================

    public boolean register(String username, String password) {

        String sql = "INSERT INTO users_login (username, password) VALUES (?, ?)";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, username);
            ps.setString(2, password);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            // Duplicate Username
            if (e.getErrorCode() == 1062) {
                System.out.println("Username already exists!");
            } else {
                e.printStackTrace();
            }
        }

        return false;
    }
}