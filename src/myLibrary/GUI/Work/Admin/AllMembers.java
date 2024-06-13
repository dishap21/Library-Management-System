package myLibrary.GUI.Work.Admin;

import javax.swing.*;
import java.awt.*;

public class AllMembers extends JPanel {
    public AllMembers(){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Get All Members");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
    }
}
