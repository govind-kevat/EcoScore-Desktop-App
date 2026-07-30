package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import database.UserDAO;

public class LoginFrame extends JFrame {

    // ================= Components =================

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JCheckBox rememberMe;

    private JButton loginButton;
    private JButton registerButton;

    public LoginFrame() {

        // ================= Window =================

        setTitle("EcoScore AI");
        setSize(550, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // ================= Main Panel =================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245,248,245));

        // ================= Header =================

        JPanel header = new JPanel();
        header.setBackground(new Color(46,125,50));
        header.setPreferredSize(new Dimension(550,170));
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        header.add(Box.createVerticalStrut(18));

        JLabel logo = new JLabel("🌍");
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 42));

        JLabel title = new JLabel("EcoScore AI");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 34));

        JLabel subtitle = new JLabel("Digital Carbon Footprint System");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setForeground(new Color(230,255,230));
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN,16));

        header.add(logo);
        header.add(Box.createVerticalStrut(5));
        header.add(title);
        header.add(Box.createVerticalStrut(4));
        header.add(subtitle);

        // ================= Login Card =================

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(400,420));

        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220,220,220)),
                new EmptyBorder(25,35,25,35)
        ));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ================= Welcome =================

        JLabel welcome = new JLabel("Welcome Back");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI",Font.BOLD,28));

        gbc.insets = new Insets(0,0,5,0);
        card.add(welcome,gbc);

        // ================= Subtitle =================

        gbc.gridy++;

        JLabel info = new JLabel("Login to continue");
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setForeground(Color.GRAY);
        info.setFont(new Font("Segoe UI",Font.PLAIN,14));

        gbc.insets = new Insets(0,0,20,0);
        card.add(info,gbc);

        // ================= Username =================

        gbc.gridy++;

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        gbc.insets = new Insets(0,0,5,0);
        card.add(userLabel,gbc);

        gbc.gridy++;

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300,42));
        usernameField.setFont(new Font("Segoe UI",Font.PLAIN,15));

        gbc.insets = new Insets(0,0,12,0);
        card.add(usernameField,gbc);

        // ================= Password =================

        gbc.gridy++;

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        gbc.insets = new Insets(0,0,5,0);
        card.add(passLabel,gbc);

        gbc.gridy++;

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300,42));
        passwordField.setFont(new Font("Segoe UI",Font.PLAIN,15));

        gbc.insets = new Insets(0,0,12,0);
        card.add(passwordField,gbc);

        // ================= Options =================

        gbc.gridy++;

        JPanel optionPanel = new JPanel(new BorderLayout());
        optionPanel.setBackground(Color.WHITE);

        rememberMe = new JCheckBox("Remember Me");
        rememberMe.setBackground(Color.WHITE);
        rememberMe.setFocusPainted(false);
        rememberMe.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        JLabel forgotPassword = new JLabel("Forgot Password?");
        forgotPassword.setForeground(new Color(46,125,50));
        forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));

        optionPanel.add(rememberMe, BorderLayout.WEST);
        optionPanel.add(forgotPassword, BorderLayout.EAST);

        gbc.insets = new Insets(5,0,18,0);
        card.add(optionPanel, gbc);

        // ================= Login Button =================

        gbc.gridy++;

        loginButton = new JButton("LOGIN");
        loginButton.setPreferredSize(new Dimension(300,45));
        loginButton.setBackground(new Color(46,125,50));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.insets = new Insets(0,0,18,0);
        card.add(loginButton, gbc);

        // ================= Register =================

        gbc.gridy++;

        JPanel registerPanel = new JPanel();
        registerPanel.setBackground(Color.WHITE);

        JLabel text = new JLabel("Don't have an account?");
        text.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        registerButton = new JButton("Create Account");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setForeground(new Color(46,125,50));
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 13));

        registerPanel.add(text);
        registerPanel.add(registerButton);

        gbc.insets = new Insets(5,0,0,0);
        card.add(registerPanel, gbc);

        // ================= Center Panel =================

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(245,248,245));
        centerPanel.add(card);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);

        // ================= Events =================

        loginButton.addActionListener(e -> {

            String username = usernameField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());

            if(username.isEmpty() || password.isEmpty()){

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields."
                );
                return;
            }

            UserDAO dao = new UserDAO();

            if(dao.login(username,password)){

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!"
                );

                new EcoScoreFrame(username);
                dispose();

                // TODO
                // new DashboardFrame(username);
                // dispose();

            }else{

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password!"
                );

            }

        });

        registerButton.addActionListener(e -> {

            new RegisterFrame();

            dispose();

        });

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                loginButton.setBackground(new Color(56,142,60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                loginButton.setBackground(new Color(46,125,50));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new LoginFrame());

    }
}