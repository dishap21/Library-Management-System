package myLibrary.GUI.Work.Admin;

import myLibrary.Admin.AdminDAO;
import myLibrary.GUI.LibraryGuiManager;
import myLibrary.Library;
import myLibrary.Member.MemberDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllMembers extends JPanel {
    private JScrollPane scroll;
    public AllMembers(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Get All Members");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Get All Members");
        button1.addActionListener(e -> getAllMembers());
        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void getAllMembers() {
        if(scroll != null){
            remove(scroll);
        }
        MemberDAO memberDAO = new MemberDAO();
        DefaultTableModel model = memberDAO.getAllMembers();
        JTable table = new JTable(model);

        scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
