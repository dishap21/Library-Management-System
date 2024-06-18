package myLibrary.GUI.Work.Admin;

import myLibrary.Book.BorrowedBook;
import myLibrary.Book.BorrowedBookDAO;
import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IssuedBooksA extends JPanel {
    private JScrollPane scroll;
    public IssuedBooksA(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Check all issued books");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("See All Issued Books");
        button1.addActionListener(e -> getAllIssuedBooks());
        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void getAllIssuedBooks() {
        if(scroll != null){
            remove(scroll);
        }
        BorrowedBookDAO borrowedBookDAO = new BorrowedBookDAO();
        DefaultTableModel model = borrowedBookDAO.getAllBorrowedBooks();
        JTable jTable = new JTable(model);

        scroll = new JScrollPane(jTable);
        add(scroll, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
