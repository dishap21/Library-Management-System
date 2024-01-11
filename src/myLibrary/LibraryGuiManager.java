package myLibrary;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGuiManager {
    private Library library;
    private JPanel currentScreen;
    private JFrame frame;

    public LibraryGuiManager(Library library) {
        this.library = library;
        initializeGui();
    }

    private void initializeGui() {
        // Create a JFrame
        frame = new JFrame("Library Management System");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Initial Screen
        currentScreen = createScreen("Home", "Welcome Dear Member.");
        frame.getContentPane().add(currentScreen);
        frame.setVisible(true);
    }

    private JPanel createScreen(String title, String message) {
        JPanel screen = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        screen.add(titleLabel, BorderLayout.NORTH);

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        screen.add(messageLabel, BorderLayout.CENTER);

//        JLabel idLabel = new JLabel(message, SwingConstants.CENTER);
//        screen.add(idLabel, BorderLayout.CENTER);

        JButton issueButton = new JButton("Issue Book");
        JButton bookDetailsButton = new JButton("Get Book Details");
        JButton returnButton = new JButton("Return Book");
        issueButton.setBorder(new EmptyBorder(10, 20, 10, 20));
        bookDetailsButton.setBorder(new EmptyBorder(10, 20, 10, 20));
        returnButton.setBorder(new EmptyBorder(10, 20, 10, 20));

        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(createScreen("Issue Book", "Please Enter the ID of the book. \n (You can get ID in 'Book Details' section.)"));
                handleIssueBook();
            }
        });
        bookDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(createScreen("Book Details", "Enter the name of the Book or Author's name to get book: "));
                handleBookDetails();
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(createScreen("Return Book", "Please enter the ID of the Book."));
                handleReturnBook();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(issueButton);
        buttonPanel.add(bookDetailsButton);
        buttonPanel.add(returnButton);

        screen.add(buttonPanel, BorderLayout.SOUTH);

        return screen;
    }

    private void navigateTo(JPanel newScreen) {
        frame.getContentPane().remove(currentScreen);

        currentScreen = newScreen;

        frame.getContentPane().add(currentScreen);
        frame.revalidate();
        frame.repaint();
    }

    private void handleIssueBook() {
    }
    private void handleBookDetails() {
    }
    private void handleReturnBook() {
    }
    public void runGui() {
        System.out.println("Library Management System is running.....");
    }
    public void issueBook(Member member, Book book) {
        library.issueBook(member, book);
    }
}
