package myLibrary.GUI.Work.User;

import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import java.awt.*;

public class IssueBooks extends JPanel {
    public IssueBooks(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Enter the id- Issue any book you want.");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Enter the id:");
        JTextField bookId = new JTextField();
        bookId.setSize(30, 10);
        JButton b1 = new JButton("Get My Details");
        buttonPanel.add(label);
        buttonPanel.add(bookId);
        buttonPanel.add(b1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("UserPanel"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        b1.addActionListener(e -> {
            int id = Integer.parseInt(bookId.getText());
            issueBook(id);
        });
    }

    private void issueBook(int id) {
    }
}
