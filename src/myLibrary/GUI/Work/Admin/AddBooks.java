package myLibrary.GUI.Work.Admin;

import myLibrary.Book.Book;
import myLibrary.Book.BookDAO;
import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class AddBooks extends JPanel {
    public AddBooks(LibraryGuiManager libraryGuiManager){

        setLayout(new GridLayout(6, 2));

        JLabel title = new JLabel("Add Book");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        JLabel dummy = new JLabel("");
        add(title);
        add(dummy);

        JLabel titleLabel = new JLabel("Enter Book Title: ");
        JTextField textField1 = new JTextField();
        JLabel authorLabel = new JLabel("Enter Author name: ");
        JTextField textField2 = new JTextField();
        JLabel genreLabel = new JLabel("Enter Book genre: ");
        JTextField textField3 = new JTextField();
        JLabel quantityLabel = new JLabel("Enter Quantity: ");
        JTextField textField4 = new JTextField();

        add(titleLabel);
        add(textField1);
        add(authorLabel);
        add(textField2);
        add(genreLabel);
        add(textField3);
        add(quantityLabel);
        add(textField4);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Add new Book");

        // Add the action listener for the button inside the constructor
        button1.addActionListener(e -> {
            String bookTitle = textField1.getText();
            String author = textField2.getText();
            String genre = textField3.getText();
            try {
                int quantity = Integer.parseInt(textField4.getText());
                addBook(bookTitle, author, genre, quantity);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);

        add(bottomPanel);
    }

    private void addBook(String title, String author, String genre, int quantity) {
        Book book = new Book(title, author, genre, quantity);
        BookDAO bookDAO = new BookDAO();
        try{
            bookDAO.addBook(book);
            JOptionPane.showMessageDialog(this, "Book added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Not able to add books.", "Failure", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
}
