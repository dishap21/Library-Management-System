package myLibrary.GUI;

import myLibrary.Member.MemberDAO;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private MemberDAO memberDAO;
    public LoginPanel(){
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
            if(memberDAO.findMember(email, password)){
                ansLabel.setText("Login Successful");
            }else{
                ansLabel.setText("Login not successful");
            }
        });
    }
}
