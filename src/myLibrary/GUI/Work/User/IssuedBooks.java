package myLibrary.GUI.Work.User;

import myLibrary.Book.BorrowedBookDAO;
import myLibrary.GUI.LibraryGuiManager;
import myLibrary.Member.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IssuedBooks extends JPanel {
    private Member member;
    public IssuedBooks(LibraryGuiManager libraryGuiManager){
        this.member = libraryGuiManager.getCurrentMember();
        setLayout(new BorderLayout());
        JLabel title = new JLabel("All book issued by you.");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Get All Books");
        button1.addActionListener(e -> getAllIssuedBooks());
        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("UserPanel"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void getAllIssuedBooks() {
        if (member != null) {
            BorrowedBookDAO borrowedBookDAO = new BorrowedBookDAO();
            DefaultTableModel model = borrowedBookDAO.getBorrowedBooksByMemberId(member.getMember_id());
            // You may want to add code to display the model in a table or handle it as needed
        } else {
            JOptionPane.showMessageDialog(this, "No member is currently set.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
