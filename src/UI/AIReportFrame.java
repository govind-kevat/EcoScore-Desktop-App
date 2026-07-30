package UI;

import javax.swing.*;
import java.awt.*;

public class AIReportFrame extends JFrame {

    public AIReportFrame(String aiReport) {

        setTitle("EcoScore AI Assistant");
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245,248,245));

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setBackground(new Color(46,125,50));
        header.setPreferredSize(new Dimension(700,70));

        JLabel title = new JLabel("🤖 EcoScore AI Assistant");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));

        header.add(title);

        // ================= AI TEXT =================

        JTextArea area = new JTextArea(aiReport);

        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setMargin(new Insets(20,20,20,20));
        area.setBackground(Color.WHITE);
        area.setFont(new Font("Segoe UI", Font.PLAIN,16));

        JScrollPane scroll = new JScrollPane(area);

        // ================= BUTTON =================

        JPanel bottom = new JPanel();

        JButton close = new JButton("Close");

        close.setBackground(new Color(46,125,50));
        close.setForeground(Color.WHITE);
        close.setFocusPainted(false);
        close.setFont(new Font("Segoe UI", Font.BOLD,16));

        close.addActionListener(e -> dispose());

        bottom.add(close);

        mainPanel.add(header,BorderLayout.NORTH);
        mainPanel.add(scroll,BorderLayout.CENTER);
        mainPanel.add(bottom,BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }
}