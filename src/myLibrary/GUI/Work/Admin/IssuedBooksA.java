package myLibrary.GUI.Work.Admin;

import javax.swing.*;
import java.awt.*;

public class IssuedBooksA extends JPanel {
    public IssuedBooksA(){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Check all issued books");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
    }
}
