package myLibrary.GUI.Work.User;

import myLibrary.Book.Book;
import myLibrary.Book.BookDAO;
import myLibrary.Book.BorrowedBook;
import myLibrary.Book.BorrowedBookDAO;
import myLibrary.GUI.LibraryGuiManager;
import myLibrary.Member.Member;

import javax.swing.*;
import java.awt.*;

public class IssueBooks extends JPanel {
    private JPanel confirmPanel;
    private LibraryGuiManager libraryGuiManager;
    private Member member;
    public IssueBooks(LibraryGuiManager libraryGuiManager){
        this.libraryGuiManager = libraryGuiManager;
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Enter the id- Issue any book you want.");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Enter the id:");
        JTextField bookId = new JTextField();
        bookId.setPreferredSize(new Dimension(100, 30));
        JButton b1 = new JButton("Issue Book");
        buttonPanel.add(label);
        buttonPanel.add(bookId);
        buttonPanel.add(b1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("UserPanel"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        b1.addActionListener(e -> {
            int id = Integer.parseInt(bookId.getText());
            issueBook(id);
        });
        confirmPanel = new JPanel();
        add(confirmPanel, BorderLayout.CENTER);
    }

    private void issueBook(int id) {
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.getBookById(id);
        JPanel jPanel = new JPanel(new GridLayout(5,2));
        JLabel book_id = new JLabel("Id: ");
        JLabel id_value = new JLabel(String.valueOf(book.getBookId()));
        JLabel title = new JLabel("Title: ");
        JLabel title_value = new JLabel(book.getTitle());
        JLabel author = new JLabel("Author: ");
        JLabel author_value = new JLabel(book.getAuthor());
        JLabel genre = new JLabel("Genre: ");
        JLabel genre_value = new JLabel(book.getGenre());
        JButton confirm = new JButton("Confirm Issue");

        confirm.addActionListener(e -> confirmIssue(id));

        jPanel.add(book_id);
        jPanel.add(id_value);
        jPanel.add(title);
        jPanel.add(title_value);
        jPanel.add(author);
        jPanel.add(author_value);
        jPanel.add(genre);
        jPanel.add(genre_value);
        jPanel.add(confirm);

        remove(confirmPanel);
        confirmPanel = jPanel;
        add(confirmPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void confirmIssue(int id) {
        member = libraryGuiManager.getCurrentMember();
        BorrowedBook book = null;
        BorrowedBookDAO borrowedBookDAO = new BorrowedBookDAO();
        BookDAO bookDAO = new BookDAO();
        boolean update = bookDAO.updateQuantity(id, false);
        if(update){
            book = borrowedBookDAO.addBorrowedBook(id, member.getMember_id());
        }
        if(book != null){
            JOptionPane.showMessageDialog(this, "The book has been issue, Please collect it from counter. Due on: "+book.getDueDate(), "Book Issued.", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Not able to confirm the issue. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        revalidate();
        repaint();
        remove(confirmPanel);
    }
}
