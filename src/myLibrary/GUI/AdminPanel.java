package myLibrary.GUI;

import myLibrary.Admin.AdminDAO;
import myLibrary.Member.MemberDAO;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    private AdminDAO adminDAO;
    private LibraryGuiManager libraryGuiManager;
    public AdminPanel(LibraryGuiManager libraryGuiManager){
        this.libraryGuiManager = libraryGuiManager;
        adminDAO = new AdminDAO();
        setLayout(new GridLayout(4,1));
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

        b1.addActionListener(e -> {
            String email = textField1.getText();
            String password = new String(textField2.getPassword());
            if(adminDAO.validateAdmin(email, password)){
                ansLabel.setText("Login Successful");
                libraryGuiManager.SwitchToAdminPanel();
            }else{
                ansLabel.setText("Login not successful");
            }
        });
    }
}
