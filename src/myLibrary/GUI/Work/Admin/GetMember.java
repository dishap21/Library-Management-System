package myLibrary.GUI.Work.Admin;

import myLibrary.GUI.LibraryGuiManager;
import myLibrary.Library;
import myLibrary.Member.Member;
import myLibrary.Member.MemberDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class GetMember extends JPanel {
    private LibraryGuiManager libraryGuiManager;
    private Member member;
    private JPanel details;
    public GetMember(LibraryGuiManager libraryGuiManager){
        this.libraryGuiManager = libraryGuiManager;
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Get Member");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Enter the member id:");
        JTextField memberId = new JTextField();
        memberId.setPreferredSize(new Dimension(100, 30));
        JButton b1 = new JButton("Get Member");
        buttonPanel.add(label);
        buttonPanel.add(memberId);
        buttonPanel.add(b1);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        bottomPanel.add(libraryGuiManager.HomeLogoutPanel("AdminPanel2"), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        b1.addActionListener(e -> {
            String memberIdText = memberId.getText();
            try {
                int member_Id = Integer.parseInt(memberIdText);
                getOneMember(member_Id);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Book ID format", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        details = new JPanel();
        add(details, BorderLayout.CENTER);
    }

    private void getOneMember(int id) throws SQLException {
        MemberDAO memberDAO = new MemberDAO();
        member = memberDAO.getMemberById(id);
        System.out.println(member);
        if(member == null){
            JOptionPane.showMessageDialog(this, "Member not available. Check id.", "Failure", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JPanel jPanel = new JPanel(new GridLayout(5,2));
        JLabel book_id = new JLabel("Id: ");
        JLabel id_value = new JLabel(String.valueOf(member.getMember_id()));
        JLabel title = new JLabel("Name: ");
        JLabel title_value = new JLabel(member.getName());
        JLabel author = new JLabel("Email: ");
        JLabel author_value = new JLabel(member.getEmail());
        JLabel genre = new JLabel("Phone: ");
        JLabel genre_value = new JLabel(member.getPhone());

        jPanel.add(book_id);
        jPanel.add(id_value);
        jPanel.add(title);
        jPanel.add(title_value);
        jPanel.add(author);
        jPanel.add(author_value);
        jPanel.add(genre);
        jPanel.add(genre_value);

        remove(details);
        details = jPanel;
        add(jPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
