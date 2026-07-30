package UI;

import database.UserDAO;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton backButton;

    public RegisterFrame() {

        setTitle("Create Account");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245,248,245));

        JLabel title = new JLabel("Create Account");
        title.setBounds(120,30,250,40);
        title.setFont(new Font("Segoe UI",Font.BOLD,28));

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50,100,100,25);

        usernameField = new JTextField();
        usernameField.setBounds(50,130,330,35);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50,180,100,25);

        passwordField = new JPasswordField();
        passwordField.setBounds(50,210,330,35);

        JLabel confirmLabel = new JLabel("Confirm Password");
        confirmLabel.setBounds(50,260,150,25);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(50,290,330,35);

        registerButton = new JButton("CREATE ACCOUNT");
        registerButton.setBounds(50,350,330,40);
        registerButton.setBackground(new Color(46,125,50));
        registerButton.setForeground(Color.WHITE);

        backButton = new JButton("Back to Login");
        backButton.setBounds(50,405,330,35);

        panel.add(title);
        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passLabel);
        panel.add(passwordField);
        panel.add(confirmLabel);
        panel.add(confirmPasswordField);
        panel.add(registerButton);
        panel.add(backButton);

        add(panel);

        // ================= Register =================

        registerButton.addActionListener(e -> {

            String username = usernameField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());
            String confirm = String.valueOf(confirmPasswordField.getPassword());

            if(username.isEmpty() || password.isEmpty() || confirm.isEmpty()){

                JOptionPane.showMessageDialog(this,"Please fill all fields.");
                return;
            }

            if(!password.equals(confirm)){

                JOptionPane.showMessageDialog(this,"Passwords do not match.");
                return;
            }

            UserDAO dao = new UserDAO();

            if(dao.register(username,password)){

                JOptionPane.showMessageDialog(this,"Account Created Successfully!");

                new LoginFrame();

                dispose();

            }else{

                JOptionPane.showMessageDialog(this,"Username already exists.");

            }

        });

        // ================= Back =================

        backButton.addActionListener(e->{

            new LoginFrame();

            dispose();

        });

        setVisible(true);

    }

}