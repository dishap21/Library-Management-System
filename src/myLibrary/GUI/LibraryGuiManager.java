package myLibrary.GUI;

import myLibrary.Library;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class LibraryGuiManager {
    private Library library;
    private static CardLayout cardLayout;
    private static JPanel cardPanel;
    public LibraryGuiManager(Library library) {
        this.library = library;
        initializeGui();
    }

    private void initializeGui() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Library Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create buttons
            JButton button1 = new JButton("Login");
            JButton button2 = new JButton("Register");
            JButton button3 = new JButton("Admin");

            // Add action listeners to the buttons
            button1.addActionListener(e -> cardLayout.show(cardPanel, "LoginPanel"));
            button2.addActionListener(e -> cardLayout.show(cardPanel, "RegisterPanel"));
            button3.addActionListener(e -> cardLayout.show(cardPanel, "AdminPanel"));

            //Panel for button
            JPanel buttons = new JPanel();
            buttons.add(button1);
            buttons.add(button2);
            buttons.add(button3);

            // Add custom UI to set the background color of the selected button
            button1.setUI(new SelectedButtonUI(Color.cyan));
            button2.setUI(new SelectedButtonUI(Color.cyan));
            button3.setUI(new SelectedButtonUI(Color.cyan));

            // Create card layout and panel
            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);

            // Add panels to the card panel
            cardPanel.add(new LoginPanel(), "LoginPanel");
            cardPanel.add(new RegisterPanel(), "RegisterPanel");
            cardPanel.add(new AdminPanel(), "AdminPanel");

            // Set up the main frame
            frame.setLayout(new BorderLayout());
            frame.add(buttons, BorderLayout.SOUTH);
            frame.add(cardPanel, BorderLayout.CENTER);

            // Set main frame properties
            frame.setSize(700, 400);
            frame.setVisible(true);
        });
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
}