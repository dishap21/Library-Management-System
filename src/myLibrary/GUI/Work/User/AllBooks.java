package myLibrary.GUI.Work.User;

import myLibrary.Book.BookDAO;
import myLibrary.GUI.LibraryGuiManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllBooks extends JPanel {
    private JScrollPane scroll;
    public AllBooks(LibraryGuiManager libraryGuiManager){
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Books available in our Library. (Remember the id to issue the book.)");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Get All Books");
        button1.addActionListener(e -> getAllBooks());
        buttonPanel.add(button1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("UserPanel"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void getAllBooks() {
        if(scroll != null){
            remove(scroll);
        }
        BookDAO bookDAO = new BookDAO();
        DefaultTableModel model = bookDAO.getAllBooks();
        JTable table = new JTable(model);

        scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
