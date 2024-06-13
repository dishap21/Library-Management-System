package myLibrary.GUI.Work;

import myLibrary.GUI.LibraryGuiManager;
import myLibrary.GUI.Work.User.AllBooks;

import javax.swing.*;
import java.awt.*;

public class LibUserPanel extends JPanel {
    public LibUserPanel(LibraryGuiManager libraryGuiManager) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to the Library System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton button1 = new JButton("See Books Available");
        JButton button2 = new JButton("Issue Book");
        JButton button3 = new JButton("Issued Books");
        JButton button4 = new JButton("Get my Details"); //books issued here

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        button1.addActionListener(e -> libraryGuiManager.SwitchToPanel("AllBooks"));
        button2.addActionListener(e -> libraryGuiManager.SwitchToPanel("IssueBook"));
        button3.addActionListener(e -> libraryGuiManager.SwitchToPanel("IssuedBook"));
        button4.addActionListener(e -> libraryGuiManager.SwitchToPanel("UserDetails"));

        add(buttonPanel, BorderLayout.CENTER);

        add(libraryGuiManager.HomeLogoutPanel("LoginPanel"), BorderLayout.SOUTH);
    }
}
