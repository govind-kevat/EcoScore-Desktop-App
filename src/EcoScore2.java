import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

class CarbonCalculator1 {

    public double calculateEmailImpact(int emailsSent) {
        return emailsSent * 0.004;
    }

    public double calculateCloudImpact(double gbStored) {
        return gbStored * 0.02;
    }

    public double calculateStreamingImpact(double streamingHours) {
        return streamingHours * 0.05;
    }

    public double calculateDeviceImpact(double deviceHours) {
        return deviceHours * 0.01;
    }
}

class EcoScoreEngine1 {

    public int calculateEcoScore(double totalCarbonKg) {
        double maxCarbon = 100.0;
        double score = 100 - ((totalCarbonKg / maxCarbon) * 100);
        return (int) Math.max(0, Math.min(100, score));
    }

    public String getCategory(int ecoScore) {
        if (ecoScore >= 90) {
            return "Excellent 🌱";
        } else if (ecoScore >= 70) {
            return "Good ✅";
        } else if (ecoScore >= 50) {
            return "Average ⚠️";
        } else {
            return "Poor ❌";
        }
    }
}

class DatabaseManager1 {
    private static final String URL = "jdbc:mysql://localhost:3306/ecoscoredb";
    private static final String USER = "root"; // change to your MySQL username
    private static final String PASSWORD = "Govind@123"; // change to your MySQL password

    // Method to create table if not exists
    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS ecoscore_reports (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100)," +
                "emails INT," +
                "storage DOUBLE," +
                "streaming_hours DOUBLE," +
                "device_hours DOUBLE," +
                "total_carbon DOUBLE," +
                "ecoscore INT," +
                "category VARCHAR(50)" +
                ")";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(createTableSQL);
            System.out.println("✅ Table checked/created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert report data
    public static void saveReport(String name, int emails, double storage,
                                  double streamingHours, double deviceHours,
                                  double totalCarbon, int ecoScore, String category) {
        String query = "INSERT INTO ecoscore_reports " +
                "(name, emails, storage, streaming_hours, device_hours, total_carbon, ecoscore, category) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, emails);
            pstmt.setDouble(3, storage);
            pstmt.setDouble(4, streamingHours);
            pstmt.setDouble(5, deviceHours);
            pstmt.setDouble(6, totalCarbon);
            pstmt.setInt(7, ecoScore);
            pstmt.setString(8, category);

            pstmt.executeUpdate();
            System.out.println("✅ Report saved to database successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class EcoScore2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       EcoScore AI System");
        System.out.println("=================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Number of emails sent: ");
        int emails = sc.nextInt();

        System.out.print("Cloud storage used (GB): ");
        double storage = sc.nextDouble();

        System.out.print("Video streaming hours per month: ");
        double streamingHours = sc.nextDouble();

        System.out.print("Device usage hours per day: ");
        double deviceHours = sc.nextDouble();

        CarbonCalculator1 calculator = new CarbonCalculator1();

        double emailImpact = calculator.calculateEmailImpact(emails);
        double cloudImpact = calculator.calculateCloudImpact(storage);
        double streamingImpact = calculator.calculateStreamingImpact(streamingHours);
        double deviceImpact = calculator.calculateDeviceImpact(deviceHours);

        double totalCarbon = emailImpact + cloudImpact + streamingImpact + deviceImpact;

        EcoScoreEngine1 engine = new EcoScoreEngine1();
        int ecoScore = engine.calculateEcoScore(totalCarbon);
        String category = engine.getCategory(ecoScore);

        System.out.println("\n========== REPORT ==========");
        System.out.println("User Name          : " + name);
        System.out.println("Email Impact       : " + emailImpact + " kg CO2");
        System.out.println("Cloud Impact       : " + cloudImpact + " kg CO2");
        System.out.println("Streaming Impact   : " + streamingImpact + " kg CO2");
        System.out.println("Device Impact      : " + deviceImpact + " kg CO2");
        System.out.println("--------------------------------");
        System.out.println("Total Carbon Footprint : " + totalCarbon + " kg CO2");
        System.out.println("EcoScore               : " + ecoScore + "%");
        System.out.println("Category               : " + category);

        System.out.println("\nSuggestions:");
        if (ecoScore < 90) {
            System.out.println("- Reduce unnecessary emails.");
            System.out.println("- Delete unused cloud files.");
            System.out.println("- Stream videos at lower quality.");
            System.out.println("- Turn off devices when not in use.");
        } else {
            System.out.println("- Great job! Keep following green digital habits.");
        }
        System.out.println("============================");

        // Create table first
        DatabaseManager1.createTable();

        // Save to database
        DatabaseManager1.saveReport(name, emails, storage, streamingHours, deviceHours, totalCarbon, ecoScore, category);

        sc.close();
    }
}