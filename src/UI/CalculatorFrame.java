package UI;

import javax.swing.*;
import java.awt.*;

import model.CarbonCalculator1;
import model.EcoScoreEngine1;
import database.DatabaseManager1;
import model.EcoAIAdvisor;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame(String username) {

        String loggedInUser = username;
        setTitle("EcoScore Calculator");
        setSize(900,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245,248,245));

        // ================= HEADER =================

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(46,125,50));
        header.setPreferredSize(new Dimension(900,70));

        JLabel title = new JLabel("🌍 EcoScore Calculator");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI",Font.BOLD,26));
        title.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));

        JLabel user = new JLabel("Welcome, " + username + "   ");
        user.setForeground(Color.WHITE);
        user.setFont(new Font("Segoe UI",Font.PLAIN,18));

        header.add(title,BorderLayout.WEST);
        header.add(user,BorderLayout.EAST);

        // ================= CENTER =================

        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(new Color(245,248,245));

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setPreferredSize(new Dimension(500,430));
        formPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12,12,12,12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

// Heading

        JLabel heading = new JLabel("Calculate Your Digital Carbon Footprint");
        heading.setFont(new Font("Segoe UI", Font.BOLD,22));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(heading,gbc);

        gbc.gridwidth = 1;

// Emails

        gbc.gridy++;

        formPanel.add(new JLabel("Emails Sent"),gbc);

        JTextField emailField = new JTextField();

        gbc.gridx=1;
        formPanel.add(emailField,gbc);

// Storage

        gbc.gridx=0;
        gbc.gridy++;

        formPanel.add(new JLabel("Cloud Storage (GB)"),gbc);

        JTextField storageField = new JTextField();

        gbc.gridx=1;
        formPanel.add(storageField,gbc);

// Streaming

        gbc.gridx=0;
        gbc.gridy++;

        formPanel.add(new JLabel("Streaming Hours"),gbc);

        JTextField streamField = new JTextField();

        gbc.gridx=1;
        formPanel.add(streamField,gbc);

// Device

        gbc.gridx=0;
        gbc.gridy++;

        formPanel.add(new JLabel("Device Usage Hours"),gbc);

        JTextField deviceField = new JTextField();

        gbc.gridx=1;
        formPanel.add(deviceField,gbc);

// Button

        JButton calculateButton = new JButton("Calculate EcoScore");
        JLabel emailResult = new JLabel("Email Impact : ");
        JLabel cloudResult = new JLabel("Cloud Impact : ");
        JLabel streamResult = new JLabel("Streaming Impact : ");
        JLabel deviceResult = new JLabel("Device Impact : ");
        JLabel totalResult = new JLabel("Total Carbon : ");
        JLabel ecoScoreResult = new JLabel("EcoScore : ");
        JLabel categoryResult = new JLabel("Category : ");
        calculateButton.setBackground(new Color(46,125,50));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setFont(new Font("Segoe UI",Font.BOLD,18));

        gbc.gridx=0;
        gbc.gridy++;
        gbc.gridwidth=2;

        formPanel.add(calculateButton,gbc);
        calculateButton.addActionListener(e -> {

            try {

                int emails = Integer.parseInt(emailField.getText());
                double storage = Double.parseDouble(storageField.getText());
                double streaming = Double.parseDouble(streamField.getText());
                double device = Double.parseDouble(deviceField.getText());

                CarbonCalculator1 calculator = new CarbonCalculator1();

                double emailImpact = calculator.calculateEmailImpact(emails);
                double cloudImpact = calculator.calculateCloudImpact(storage);
                double streamingImpact = calculator.calculateStreamingImpact(streaming);
                double deviceImpact = calculator.calculateDeviceImpact(device);

                double totalCarbon =
                        emailImpact +
                                cloudImpact +
                                streamingImpact +
                                deviceImpact;

                EcoScoreEngine1 engine = new EcoScoreEngine1();

                int ecoScore = engine.calculateEcoScore(totalCarbon);

                String category = engine.getCategory(ecoScore);

                emailResult.setText("Email Impact : " + emailImpact + " kg CO₂");

                cloudResult.setText("Cloud Impact : " + cloudImpact + " kg CO₂");

                streamResult.setText("Streaming Impact : " + streamingImpact + " kg CO₂");

                deviceResult.setText("Device Impact : " + deviceImpact + " kg CO₂");

                totalResult.setText("Total Carbon : " + totalCarbon + " kg CO₂");

                ecoScoreResult.setText("EcoScore : " + ecoScore + "%");

                categoryResult.setText("Category : " + category);

                // ================= AI SUGGESTIONS =================

                EcoAIAdvisor ai = new EcoAIAdvisor();

                String suggestion = ai.generateSuggestion(
                        emails,
                        storage,
                        streaming,
                        device,
                        ecoScore
                );

                new AIReportFrame(suggestion);

                DatabaseManager1.createTable();

                DatabaseManager1.saveReport(
                        loggedInUser,
                        emails,
                        storage,
                        streaming,
                        device,
                        totalCarbon,
                        ecoScore,
                        category
                );

                JOptionPane.showMessageDialog(
                        CalculatorFrame.this,
                        "✅ Report Saved Successfully!"
                );

            }
            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        CalculatorFrame.this,
                        "Please enter valid numbers!"
                );

            }

        });
        gbc.gridy++;
        gbc.gridwidth = 2;

        formPanel.add(emailResult, gbc);

        gbc.gridy++;
        formPanel.add(cloudResult, gbc);

        gbc.gridy++;
        formPanel.add(streamResult, gbc);

        gbc.gridy++;
        formPanel.add(deviceResult, gbc);

        gbc.gridy++;
        formPanel.add(totalResult, gbc);

        gbc.gridy++;
        formPanel.add(ecoScoreResult, gbc);

        gbc.gridy++;
        formPanel.add(categoryResult, gbc);


        center.add(formPanel);

        mainPanel.add(header,BorderLayout.NORTH);
        mainPanel.add(center,BorderLayout.CENTER);
        add(mainPanel);

        setVisible(true);

    }

}