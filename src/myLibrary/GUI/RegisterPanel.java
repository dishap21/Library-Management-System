package myLibrary.GUI;

import myLibrary.Member.Member;
import myLibrary.Member.MemberDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class RegisterPanel extends JPanel {
    private MemberDAO memberDAO;
     public RegisterPanel(){
         JLabel titleLabel = new JLabel("Member Register");
         titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
         JLabel dummy = new JLabel("");
         titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
         add(titleLabel, BorderLayout.NORTH);
         add(dummy,BorderLayout.NORTH);
         memberDAO = new MemberDAO();
         setLayout(new GridLayout(6,1));
         JLabel nameLabel = new JLabel("Enter your Username: ");
         JTextField textField1 = new JTextField();
         JLabel emailLabel = new JLabel("Enter your Email: ");
         JTextField textField2 = new JTextField();
         JLabel passLabel = new JLabel("Enter your Password: ");
         JPasswordField textField3 = new JPasswordField();
         JLabel phoneLabel = new JLabel("Enter your Phone: ");
         JTextField textField4 = new JTextField();
         JButton b1= new JButton("Submit");
         JLabel ansLabel = new JLabel("");

         add(nameLabel);
         add(textField1);
         add(emailLabel);
         add(textField2);
         add(passLabel);
         add(textField3);
         add(phoneLabel);
         add(textField4);
         add(b1);
         add(ansLabel);

         b1.addActionListener(e -> {
             String name = textField1.getText();
             String email = textField2.getText();
             String password = new String(textField3.getPassword());
             String phone = textField4.getText();
             try{
                 memberDAO.addMember(new Member(name, email, password, phone));
                 ansLabel.setText("Registered Successful. Go to login page and access the Library.");
             }catch(Exception err){
                 System.out.println(err.getMessage());
                 ansLabel.setText("Login not successful");
             }
         });
     }
}
