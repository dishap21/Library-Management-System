package myLibrary.Book;

import myLibrary.util.DatabaseUtil;

import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.sql.*;

public class BorrowedBookDAO {
    public void addBorrowedBook(BorrowedBook borrowedBook){
        String sql = "INSERT INTO BorrowedBooks (member_id, book_id, borrow_date, return_date, due_date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, borrowedBook.getMemberId());
            pstmt.setInt(2, borrowedBook.getBookId());
            pstmt.setDate(3, new java.sql.Date(borrowedBook.getBorrowDate().getTime()));
            pstmt.setDate(4, borrowedBook.getReturnDate() != null ? new java.sql.Date(borrowedBook.getReturnDate().getTime()) : null);
            pstmt.setDate(5, new java.sql.Date(borrowedBook.getDueDate().getTime()));
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateBorrowedBook(BorrowedBook borrowedBook){
        //
    }
    public void deleteBorrowedBook(int borrowedBookId){
        String sql = "DELETE FROM BorrowedBooks WHERE borrow_id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, Integer.parseInt("borrowId"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    public BorrowedBook getAllBorrowedBooks(){
//        String sql = "SELECT * FROM BorrowedBooks WHERE borrow_id = ?";
//        BorrowedBook borrowedBooks = null;
//
//        try (Connection conn = DatabaseUtil.getConnection();
//             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//            preparedStatement.setInt(1, borrowId);
//            try (ResultSet rs = preparedStatement.executeQuery()) {
//                if (rs.next()) {
//                    borrowedBooks = new BorrowedBook();
//                    borrowedBooks.setBorrowId(rs.getInt("borrow_id"));
//                    borrowedBooks.setMemberId(rs.getInt("member_id"));
//                    borrowedBooks.setBookId(rs.getInt("book_id"));
//                    borrowedBooks.setBorrowDate(rs.getDate("borrow_date"));
//                    borrowedBooks.setReturnDate(rs.getDate("return_date"));
//                    borrowedBooks.setDueDate(rs.getDate("due_date"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return borrowedBooks;
//    }
    public DefaultTableModel getBorrowedBooksByMemberId(int memberId){
        DefaultTableModel model = new DefaultTableModel();
        return model;
    }
}
