package myLibrary.GUI.Work.User;

import myLibrary.GUI.LibraryGuiManager;
import myLibrary.Member.Member;
import myLibrary.Member.MemberDAO;

import javax.swing.*;
import java.awt.*;

public class MyDetails extends JPanel {
    private Member member;
    public MyDetails(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Your Details. If there is update, contact Admin");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Get My Details");
        button1.addActionListener(e -> getMyDetails(member));
        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("UserPanel"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void getMyDetails(Member member) {
        JPanel jPanel = new JPanel(new GridLayout(4,1));
        //MemberDAO memberDAO = new MemberDAO();
        JLabel id = new JLabel("Id: ");
        JLabel id_value = new JLabel(String.valueOf(member.getMember_id()));
        JLabel name = new JLabel("Name: ");
        JLabel name_value = new JLabel(member.getName());
        JLabel email_id = new JLabel("Email: ");
        JLabel mail_value = new JLabel(member.getEmail());
        JLabel phone = new JLabel("Phone: ");
        JLabel phone_value = new JLabel(member.getPhone());

        jPanel.add(id);
        jPanel.add(id_value);
        jPanel.add(name);
        jPanel.add(name_value);
        jPanel.add(email_id);
        jPanel.add(mail_value);
        jPanel.add(phone);
        jPanel.add(phone_value);
    }
}
