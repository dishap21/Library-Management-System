package myLibrary.GUI.Work.User;

import myLibrary.GUI.LibraryGuiManager;
import myLibrary.Member.Member;

import javax.swing.*;
import java.awt.*;

public class MyDetails extends JPanel {
    private Member member;
    private LibraryGuiManager libraryGuiManager;
    private JPanel details;
    public MyDetails(LibraryGuiManager libraryGuiManager){
        this.libraryGuiManager = libraryGuiManager;;
        this.member = libraryGuiManager.getCurrentMember();
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Your Details. If there is update, contact Admin");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Get My Details");
        button1.addActionListener(e -> getMyDetails());
        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("UserPanel"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
        details = new JPanel();
        add(details, BorderLayout.CENTER);
    }

    private void getMyDetails() {
        member = libraryGuiManager.getCurrentMember();
        if (member == null) {
            JOptionPane.showMessageDialog(this, "No member is currently set.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JPanel jPanel = new JPanel(new GridLayout(4,2));
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

        remove(details);
        details = jPanel;
        add(details, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
