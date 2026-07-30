package UI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;

public class DashboardCard extends JPanel {

    public DashboardCard(String icon, String title) {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(280,180));

        setBorder(new CompoundBorder(
                new LineBorder(new Color(220,220,220),1,true),
                new EmptyBorder(20,20,20,20)
        ));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN,50));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI",Font.BOLD,20));

        add(iconLabel,BorderLayout.CENTER);
        add(titleLabel,BorderLayout.SOUTH);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                setBackground(new Color(232,245,233));
                setBorder(new CompoundBorder(
                        new LineBorder(new Color(46,125,50),2,true),
                        new EmptyBorder(20,20,20,20)
                ));

            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBackground(Color.WHITE);
                setBorder(new CompoundBorder(
                        new LineBorder(new Color(220,220,220),1,true),
                        new EmptyBorder(20,20,20,20)
                ));

            }

        });

    }
    public void setCardClickListener(MouseAdapter listener) {
        addMouseListener(listener);
    }

}