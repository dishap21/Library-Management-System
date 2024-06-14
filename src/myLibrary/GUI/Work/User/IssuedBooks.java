package myLibrary.GUI.Work.User;

import myLibrary.Book.BorrowedBookDAO;
import myLibrary.GUI.LibraryGuiManager;
import myLibrary.Member.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IssuedBooks extends JPanel {
    private Member member;
    private JScrollPane jScrollPane = null;
    LibraryGuiManager libraryGuiManager;
    public IssuedBooks(LibraryGuiManager libraryGuiManager){
        this.libraryGuiManager = libraryGuiManager;
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
        member = libraryGuiManager.getCurrentMember();
        if(jScrollPane != null){
            remove(jScrollPane);
        }
        if (member != null) {
            BorrowedBookDAO borrowedBookDAO = new BorrowedBookDAO();
            DefaultTableModel model = borrowedBookDAO.getBorrowedBooksByMemberId(member.getMember_id());
            System.out.println(member.getMember_id());
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No books issued/All books clear.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JTable jTable = new JTable(model);
                jScrollPane = new JScrollPane(jTable);
                add(jScrollPane, BorderLayout.CENTER);
            }

            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No member is currently set.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
