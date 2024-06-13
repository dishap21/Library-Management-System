package myLibrary.GUI.Work.Admin;

import javax.swing.*;
import java.awt.*;

public class AllAdmins extends JPanel {
    public AllAdmins(){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Get all Admins");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
    }
}
