package UI;

import database.DatabaseManager1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class ReportFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ReportFrame() {

        setTitle("Previous Reports");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245,248,245));

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setBackground(new Color(46,125,50));
        header.setPreferredSize(new Dimension(900,70));

        JLabel title = new JLabel("📄 Previous EcoScore Reports");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD,26));

        header.add(title);

        // ================= TABLE =================

        String[] columns = {
                "ID",
                "Name",
                "Emails",
                "Storage",
                "Streaming",
                "Device",
                "Carbon",
                "EcoScore",
                "Category"
        };

        model = new DefaultTableModel(columns,0);

        table = new JTable(model);
        table.setRowHeight(28);
        table.getTableHeader().setFont(
                new Font("Segoe UI",Font.BOLD,14));

        JScrollPane scrollPane = new JScrollPane(table);

        // ================= BUTTONS =================

        JPanel buttonPanel = new JPanel();

        JButton refreshButton = new JButton("Refresh");
        JButton deleteButton = new JButton("Delete Selected");

        refreshButton.addActionListener(e -> loadReports());

        deleteButton.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a report first!"
                );
                return;
            }

            int id = (int) model.getValueAt(row,0);

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Delete this report?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );

            if(choice == JOptionPane.YES_OPTION){

                DatabaseManager1.deleteReport(id);

                loadReports();

                JOptionPane.showMessageDialog(
                        this,
                        "Report deleted successfully!"
                );
            }

        });

        buttonPanel.add(refreshButton);
        buttonPanel.add(deleteButton);

        mainPanel.add(header,BorderLayout.NORTH);
        mainPanel.add(scrollPane,BorderLayout.CENTER);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        add(mainPanel);

        loadReports();

        setVisible(true);
    }

    // ================= LOAD REPORTS =================

    private void loadReports() {

        model.setRowCount(0);

        try {

            ResultSet rs = DatabaseManager1.getAllReports();

            while (rs != null && rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("emails_sent"),
                        rs.getDouble("cloud_storage"),
                        rs.getDouble("streaming_hours"),
                        rs.getDouble("device_hours"),
                        rs.getDouble("total_carbon"),
                        rs.getInt("eco_score"),
                        rs.getString("category")

                });

            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load reports!"
            );
        }

    }

}