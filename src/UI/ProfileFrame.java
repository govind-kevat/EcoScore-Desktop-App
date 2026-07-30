package UI;

import database.DatabaseManager1;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ProfileFrame extends JFrame {

    public ProfileFrame(String username) {

        setTitle("My Profile");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245,248,245));

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setBackground(new Color(46,125,50));
        header.setPreferredSize(new Dimension(600,70));

        JLabel title = new JLabel("👤 My Profile");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));

        header.add(title);

        // ================= PROFILE CARD =================

        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        card.setLayout(new GridLayout(5,1,10,10));

        JLabel userLabel = new JLabel("Username : " + username);
        JLabel reportsLabel = new JLabel("Total Reports : ");
        JLabel avgLabel = new JLabel("Average EcoScore : ");
        JLabel bestLabel = new JLabel("Best EcoScore : ");
        JLabel categoryLabel = new JLabel("Best Category : ");

        Font font = new Font("Segoe UI", Font.PLAIN,18);

        userLabel.setFont(font);
        reportsLabel.setFont(font);
        avgLabel.setFont(font);
        bestLabel.setFont(font);
        categoryLabel.setFont(font);

        // ================= LOAD DATABASE DATA =================

        try {

            ResultSet rs = DatabaseManager1.getProfileData();

            if(rs != null && rs.next()){

                reportsLabel.setText(
                        "Total Reports : " + rs.getInt("totalReports"));

                avgLabel.setText(
                        "Average EcoScore : "
                                + String.format("%.2f",
                                rs.getDouble("averageScore")));

                bestLabel.setText(
                        "Best EcoScore : "
                                + rs.getInt("bestScore"));

                categoryLabel.setText(
                        "Best Category : "
                                + rs.getString("bestCategory"));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        card.add(userLabel);
        card.add(reportsLabel);
        card.add(avgLabel);
        card.add(bestLabel);
        card.add(categoryLabel);

        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(new Color(245,248,245));
        center.add(card);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }
}