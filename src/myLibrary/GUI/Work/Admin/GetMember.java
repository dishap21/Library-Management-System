package myLibrary.GUI.Work.Admin;

import javax.swing.*;
import java.awt.*;

public class GetMember extends JPanel {
    public GetMember(){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Get Member");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
    }
}
