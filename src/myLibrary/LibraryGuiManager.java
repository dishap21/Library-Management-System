package myLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicButtonUI;

public class LibraryGuiManager {
    private Library library;
    private static CardLayout cardLayout;
    private static JPanel cardPanel;
    private static Admin admin = new Admin("admin", "admin123");
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    public LibraryGuiManager(Library library) {
        this.library = library;
        initializeGui();
    }

    private void initializeGui() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Library Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create buttons
            JButton button1 = new JButton("Home");
            JButton button2 = new JButton("Book details");
            JButton button3 = new JButton("Issue Book");
            JButton button4 = new JButton("Return Book");
            JButton button5 = new JButton("Admin Section");

            // Add action listeners to the buttons
            button1.addActionListener(new ButtonClickListener("Panel 1"));
            button2.addActionListener(new ButtonClickListener("Panel 2"));
            button3.addActionListener(new ButtonClickListener("Panel 3"));
            button4.addActionListener(new ButtonClickListener("Panel 4"));
            button5.addActionListener(new ButtonClickListener("Panel 5"));

            // Add custom UI to set the background color of the selected button
            button1.setUI(new SelectedButtonUI(Color.cyan));
            button2.setUI(new SelectedButtonUI(Color.cyan));
            button3.setUI(new SelectedButtonUI(Color.cyan));
            button4.setUI(new SelectedButtonUI(Color.cyan));
            button5.setUI(new SelectedButtonUI(Color.cyan));

            // Create a panel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(button1);
            buttonPanel.add(button2);
            buttonPanel.add(button3);
            buttonPanel.add(button4);
            buttonPanel.add(button5);

            // Create card layout and panel
            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);

            // Create panels for each "page"
            JPanel panel1 = HomePanel();
            JPanel panel2 = BookDetails();
            JPanel panel3 = IssueBook();
            JPanel panel4 = ReturnBook();
            JPanel panel5 = AdminPanel();

            // Add panels to the card panel
            cardPanel.add(panel1, "Panel 1");
            cardPanel.add(panel2, "Panel 2");
            cardPanel.add(panel3, "Panel 3");
            cardPanel.add(panel4, "Panel 4");
            cardPanel.add(panel5, "Panel 5");

            // Set up the main frame
            frame.setLayout(new BorderLayout());
            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.add(cardPanel, BorderLayout.CENTER);

            // Set main frame properties
            frame.setSize(700, 400);
            frame.setVisible(true);
        });
    }
    static class ButtonClickListener implements ActionListener {
        private String panelName;

        public ButtonClickListener(String panelName) {
            this.panelName = panelName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (panelName.equals("Panel 5")) {
                // Handle login logic using a separate method
                createLoginPanel();
            } else {
                // Switch to the specified panel when a button (other than Login) is clicked
                cardLayout.show(cardPanel, panelName);
            }
        }
    }
    // Helper method to create a panel with some content
    private static JPanel HomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        // Title
        JLabel titleLabel = new JLabel("Home");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // content
        JLabel contentLabel = new JLabel("Welcome dear member");
        contentLabel.setSize(12, 8);
        contentLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(contentLabel, BorderLayout.CENTER);

        return panel;
    }
    private static JPanel BookDetails() {
        JPanel panel = new JPanel(new BorderLayout());
        // Title
        JLabel titleLabel = new JLabel("Book Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        return panel;
    }
    private static JPanel IssueBook() {
        JPanel panel = new JPanel(new BorderLayout());
        // Title
        JLabel titleLabel = new JLabel("Issue Book");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        return panel;
    }
    private static JPanel ReturnBook() {
        JPanel panel = new JPanel(new BorderLayout());
        // Title
        JLabel titleLabel = new JLabel("Return Book");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        return panel;
    }
    private static JPanel AdminPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        // Title
        JLabel titleLabel = new JLabel("Admin Section");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(new Label("Welcome, Admin."));
        JPanel contentPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.add(contentPanel2, BorderLayout.CENTER);
        // Content
        JPanel contentPanel = new JPanel(new FlowLayout());

        // Buttons Group
        ButtonGroup buttonGroup = new ButtonGroup();

        JButton bButton1 = new JButton("View Member Details");
        JButton bButton2 = new JButton("View Book Details");
        JButton bButton3 = new JButton("Add Book");
        JButton bButton4 = new JButton("Remove Book");
        JButton bButton5 = new JButton("Change Member Status");
        JButton bButton6 = new JButton("Add Member");
        JButton bButton7 = new JButton("Remove Member");

        bButton1.setPreferredSize(new Dimension(200, 50));
        bButton2.setPreferredSize(new Dimension(200, 50));
        bButton3.setPreferredSize(new Dimension(200, 50));
        bButton4.setPreferredSize(new Dimension(200, 50));
        bButton5.setPreferredSize(new Dimension(200, 50));
        bButton6.setPreferredSize(new Dimension(200, 50));
        bButton7.setPreferredSize(new Dimension(200, 50));

        buttonGroup.add(bButton1);
        buttonGroup.add(bButton2);
        buttonGroup.add(bButton3);
        buttonGroup.add(bButton4);
        buttonGroup.add(bButton5);
        buttonGroup.add(bButton6);
        buttonGroup.add(bButton7);

        contentPanel.add(bButton1);
        contentPanel.add(bButton2);
        contentPanel.add(bButton3);
        contentPanel.add(bButton4);
        contentPanel.add(bButton5);
        contentPanel.add(bButton6);
        contentPanel.add(bButton7);

        panel.add(contentPanel, BorderLayout.CENTER);
        return panel;
    }
    private static JPanel createLoginPanel() {
        System.out.println("login part");
        JPanel panel = new JPanel(new GridLayout(3, 2));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());
                System.out.println("login 2");
                if (admin.authenticate(enteredUsername, enteredPassword)) {
                    cardLayout.show(cardPanel, "Panel 5");
                    System.out.println("login 3");
                } else {
                    System.out.println("login 4");
                    JOptionPane.showMessageDialog(null, "Failed Login", "Login Error", JOptionPane.ERROR_MESSAGE);
                    cardLayout.show(cardPanel, "Panel 1");
                }
            }
        });

        System.out.println("login 5");
        return panel;
    }
    static class SelectedButtonUI extends BasicButtonUI {
        private Color selectedColor;

        public SelectedButtonUI(Color selectedColor) {
            this.selectedColor = selectedColor;
        }

        @Override
        protected void paintButtonPressed(Graphics g, AbstractButton b) {
            b.getModel().setArmed(true);
            b.getModel().setPressed(true);
        }

        @Override
        protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
            AbstractButton b = (AbstractButton) c;
            if (b.getModel().isArmed() || b.getModel().isSelected()) {
                g.setColor(selectedColor);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
            super.paintText(g, c, textRect, text);
        }
    }
    public void runGui() {
        System.out.println("Library Management System is running.....");
    }
    public void issueBook(Member member, Book book) {
        library.issueBook(member, book);
    }
}
