package myLibrary.GUI.Work.Admin;

import javax.swing.*;
import java.awt.*;

public class AddBooks extends JPanel {
    public AddBooks(){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Add Book");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        setLayout(new GridLayout(4, 1));
        JLabel emailLabel = new JLabel("Enter your Email: ");
        JTextField textField1 = new JTextField();
        JLabel passLabel = new JLabel("Enter your Password: ");
        JPasswordField textField2 = new JPasswordField();
        JButton b1= new JButton("Submit");
        JLabel ansLabel = new JLabel("");

        add(emailLabel);
        add(textField1);
        add(passLabel);
        add(textField2);
        add(b1);
        add(ansLabel);
    }
}
