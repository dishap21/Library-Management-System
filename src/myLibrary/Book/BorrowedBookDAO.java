package myLibrary.Book;

public class BorrowedBookDAO {
}

/*
* package myLibrary.dao;

import myLibrary.model.BorrowedBooks;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowedBooksDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/LibraryDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void addBorrowedBook(BorrowedBooks borrowedBooks) {
        String sql = "INSERT INTO BorrowedBooks (member_id, book_id, borrow_date, return_date, due_date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, borrowedBooks.getMemberId());
            pstmt.setInt(2, borrowedBooks.getBookId());
            pstmt.setDate(3, new java.sql.Date(borrowedBooks.getBorrowDate().getTime()));
            pstmt.setDate(4, borrowedBooks.getReturnDate() != null ? new java.sql.Date(borrowedBooks.getReturnDate().getTime()) : null);
            pstmt.setDate(5, new java.sql.Date(borrowedBooks.getDueDate().getTime()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BorrowedBooks getBorrowedBook(int borrowId) {
        String sql = "SELECT * FROM BorrowedBooks WHERE borrow_id = ?";
        BorrowedBooks borrowedBooks = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, borrowId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    borrowedBooks = new BorrowedBooks();
                    borrowedBooks.setBorrowId(rs.getInt("borrow_id"));
                    borrowedBooks.setMemberId(rs.getInt("member_id"));
                    borrowedBooks.setBookId(rs.getInt("book_id"));
                    borrowedBooks.setBorrowDate(rs.getDate("borrow_date"));
                    borrowedBooks.setReturnDate(rs.getDate("return_date"));
                    borrowedBooks.setDueDate(rs.getDate("due_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowedBooks;
    }

    public List<BorrowedBooks> getAllBorrowedBooks() {
        String sql = "SELECT * FROM BorrowedBooks";
        List<BorrowedBooks> borrowedBooksList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BorrowedBooks borrowedBooks = new BorrowedBooks();
                borrowedBooks.setBorrowId(rs.getInt("borrow_id"));
                borrowedBooks.setMemberId(rs.getInt("member_id"));
                borrowedBooks.setBookId(rs.getInt("book_id"));
                borrowedBooks.setBorrowDate(rs.getDate("borrow_date"));
                borrowedBooks.setReturnDate(rs.getDate("return_date"));
                borrowedBooks.setDueDate(rs.getDate("due_date"));

                borrowedBooksList.add(borrowedBooks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowedBooksList;
    }

    public void updateBorrowedBook(BorrowedBooks borrowedBooks) {
        String sql = "UPDATE BorrowedBooks SET member_id = ?, book_id = ?, borrow_date = ?, return_date = ?, due_date = ? WHERE borrow_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, borrowedBooks.getMemberId());
            pstmt.setInt(2, borrowedBooks.getBookId());
            pstmt.setDate(3, new java.sql.Date(borrowedBooks.getBorrowDate().getTime()));
            pstmt.setDate(4, borrowedBooks.getReturnDate() != null ? new java.sql.Date(borrowedBooks.getReturnDate().getTime()) : null);
            pstmt.setDate(5, new java.sql.Date(borrowedBooks.getDueDate().getTime()));
            pstmt.setInt(6, borrowedBooks.getBorrowId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBorrowedBook(int borrowId) {
        String sql = "DELETE FROM BorrowedBooks WHERE borrow_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, borrowId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/
