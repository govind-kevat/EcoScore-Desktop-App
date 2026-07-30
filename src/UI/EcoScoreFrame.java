package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import UI.ReportFrame;
import UI.ProfileFrame;

public class EcoScoreFrame extends JFrame {

    public EcoScoreFrame(String username) {

        setTitle("EcoScore AI");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245,248,245));

        // ================= HEADER =================

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(46,125,50));
        header.setPreferredSize(new Dimension(900,80));

        JLabel title = new JLabel("🌍 EcoScore AI");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));

        JLabel welcome = new JLabel("Welcome, " + username + "   ");
        welcome.setForeground(Color.WHITE);
        welcome.setFont(new Font("Segoe UI", Font.PLAIN,18));

        header.add(title, BorderLayout.WEST);
        header.add(welcome, BorderLayout.EAST);

        // ================= CENTER =================

        JPanel center = new JPanel();
        center.setBackground(new Color(245,248,245));
        center.setLayout(new BorderLayout());

// Dashboard Title

        JLabel dashboardTitle = new JLabel("Digital Carbon Footprint Dashboard");
        dashboardTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        dashboardTitle.setHorizontalAlignment(SwingConstants.CENTER);
        dashboardTitle.setBorder(BorderFactory.createEmptyBorder(30,0,20,0));

        center.add(dashboardTitle, BorderLayout.NORTH);

// Cards Panel

        JPanel cardsPanel = new JPanel();
        cardsPanel.setBackground(new Color(245,248,245));
        cardsPanel.setLayout(new GridLayout(2,2,30,30));
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(20,40,40,40));

        // ================= DASHBOARD CARDS =================

        DashboardCard calculateCard =
                new DashboardCard("📊", "Calculate EcoScore");

        DashboardCard reportsCard =
                new DashboardCard("📄", "Previous Reports");

        DashboardCard profileCard =
                new DashboardCard("👤", "Profile");

        DashboardCard logoutCard =
                new DashboardCard("🚪", "Logout");

        cardsPanel.add(calculateCard);
        cardsPanel.add(reportsCard);
        cardsPanel.add(profileCard);
        cardsPanel.add(logoutCard);

        // ================= CARD ACTIONS =================

// Calculate EcoScore
        calculateCard.setCardClickListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                new CalculatorFrame(username);
            }

        });


// Reports
        reportsCard.setCardClickListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                new ReportFrame();

            }

        });

        // ================= PROFILE =================
// Profile
        profileCard.setCardClickListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                new ProfileFrame(username);

            }

        });

// Logout
        logoutCard.setCardClickListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int option = JOptionPane.showConfirmDialog(
                        EcoScoreFrame.this,
                        "Do you really want to logout?",
                        "Logout",
                        JOptionPane.YES_NO_OPTION
                );

                if(option == JOptionPane.YES_OPTION){

                    new LoginFrame();

                    dispose();

                }

            }

        });
        center.add(cardsPanel, BorderLayout.CENTER);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);
        add(mainPanel);

        setVisible(true);
    }
}