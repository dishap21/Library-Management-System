package myLibrary.GUI.Work.Admin;

import myLibrary.Book.Book;
import myLibrary.Book.BookDAO;
import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DeleteBook extends JPanel {
    private JPanel confirmPanel;
    public DeleteBook(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Check all issued books");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Enter the book id:");
        JTextField bookId = new JTextField();
        bookId.setPreferredSize(new Dimension(100, 30));
        JButton b1 = new JButton("Delete Book");
        buttonPanel.add(label);
        buttonPanel.add(bookId);
        buttonPanel.add(b1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        b1.addActionListener(e -> {
            String bookIdText = bookId.getText();
            try {
                int book_Id = Integer.parseInt(bookIdText);
                deleteBook(book_Id);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Book ID format", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        confirmPanel = new JPanel();
        add(confirmPanel, BorderLayout.CENTER);
    }

    private void deleteBook(int id) throws SQLException{
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.getBookById(id);
        if(book == null){
            JOptionPane.showMessageDialog(this, "Book not available. Check id.", "Failure", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JPanel jPanel = new JPanel(new GridLayout(5,2));
        JLabel book_id = new JLabel("Id: ");
        JLabel id_value = new JLabel(String.valueOf(book.getBookId()));
        JLabel title = new JLabel("Title: ");
        JLabel title_value = new JLabel(book.getTitle());
        JLabel author = new JLabel("Author: ");
        JLabel author_value = new JLabel(book.getAuthor());
        JLabel genre = new JLabel("Genre: ");
        JLabel genre_value = new JLabel(book.getGenre());
        JButton confirm = new JButton("Confirm Delete");

        confirm.addActionListener(e -> confirmDelete(id));

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

    private void confirmDelete(int id) {
        BookDAO bookDAO = new BookDAO();
        try{
            bookDAO.deleteBook(id);
            JOptionPane.showMessageDialog(this, "Book deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Not Able to delete the book.\n"+e.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
        revalidate();
        repaint();
        remove(confirmPanel);
    }
}
