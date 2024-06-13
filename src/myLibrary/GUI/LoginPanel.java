package myLibrary.GUI;

import myLibrary.Member.Member;
import myLibrary.Member.MemberDAO;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private final MemberDAO memberDAO;
    private LibraryGuiManager libraryGuiManager;
    private Member member;
    public LoginPanel(LibraryGuiManager libraryGuiManager){
        this.libraryGuiManager = libraryGuiManager;
        memberDAO = new MemberDAO();
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
            if(memberDAO.findMember(email, password)  != null){
                ansLabel.setText("Login Successful");
                libraryGuiManager.SwitchToUserPanel();;
            }else{
                ansLabel.setText("Login not successful");
            }
            member = memberDAO.findMember(email, password);
            if (member != null) {
                libraryGuiManager.setCurrentMember(member);  // Set the current member in LibraryGuiManager
                // Navigate to the main application screen
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
