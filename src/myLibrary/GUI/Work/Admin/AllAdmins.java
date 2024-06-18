package myLibrary.GUI.Work.Admin;

import myLibrary.Admin.AdminDAO;
import myLibrary.Book.BookDAO;
import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllAdmins extends JPanel {
    private LibraryGuiManager libraryGuiManager;
    private JScrollPane scroll;
    public AllAdmins(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Get all Admins");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Get All Admins");
        button1.addActionListener(e -> getAllAdmins());
        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void getAllAdmins() {
        if(scroll != null){
            remove(scroll);
        }
        AdminDAO adminDAO = new AdminDAO();
        DefaultTableModel model = adminDAO.getAllAdmins();
        JTable table = new JTable(model);

        scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
