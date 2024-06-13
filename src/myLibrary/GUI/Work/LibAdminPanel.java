package myLibrary.GUI.Work;

import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import java.awt.*;

public class LibAdminPanel extends JPanel {
    public LibAdminPanel(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Admin Section");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton button1 = new JButton("See all Books");
        JButton button2 = new JButton("See Issued Books");
        JButton button3 = new JButton("All Members");
        JButton button4 = new JButton("All Admins");
        JButton button5 = new JButton("Get Member Details");
        JButton button6 = new JButton("Add Book");

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);

        button1.addActionListener(e -> libraryGuiManager.SwitchToPanel("AllBooks"));
        button2.addActionListener(e -> libraryGuiManager.SwitchToPanel("SeeIssuedBook"));
        button3.addActionListener(e -> libraryGuiManager.SwitchToPanel("AllMembers"));
        button4.addActionListener(e -> libraryGuiManager.SwitchToPanel("AllAdmins"));
        button5.addActionListener(e -> libraryGuiManager.SwitchToPanel("GetMemberDetails"));
        button6.addActionListener(e -> libraryGuiManager.SwitchToPanel("AddBook"));

        add(buttonPanel, BorderLayout.CENTER);

        add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);
    }
}
