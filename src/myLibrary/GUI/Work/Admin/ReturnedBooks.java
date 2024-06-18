package myLibrary.GUI.Work.Admin;

import myLibrary.Book.BookDAO;
import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import java.awt.*;

public class ReturnedBooks extends JPanel {
    public ReturnedBooks(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Check all issued books");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Enter the book id:");
        JTextField book_Id = new JTextField();
        book_Id.setPreferredSize(new Dimension(100, 30));
        JButton b1 = new JButton("Update books.");
        buttonPanel.add(label);
        buttonPanel.add(book_Id);
        buttonPanel.add(b1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);

        b1.addActionListener(e -> {
            int bookTestId = Integer.parseInt(book_Id.getText());
            updateReturnedBooks(bookTestId);
        });

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void updateReturnedBooks(int id) {
        BookDAO bookDAO = new BookDAO();
        boolean completed = bookDAO.updateQuantity(id, true);
        if(completed){
            JOptionPane.showMessageDialog(this, "Records updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Not able to update records. Try again.", "Failure.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
