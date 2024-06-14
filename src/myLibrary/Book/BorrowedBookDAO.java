package myLibrary.Book;

import myLibrary.util.DatabaseUtil;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Calendar;

public class BorrowedBookDAO {
    public BorrowedBook addBorrowedBook(int book_id, int member_id) {
        return addBorrowedBook(book_id, member_id, null);
    }
    public BorrowedBook addBorrowedBook(int book_id, int member_id, Date returnDate){
        String sql = "INSERT INTO BorrowedBooks (member_id, book_id, borrow_date, return_date, due_date) VALUES (?, ?, ?, ?, ?)";
        Date borrowDate = null, duedate = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            borrowDate = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(borrowDate);
            cal.add(Calendar.DAY_OF_MONTH, 7);
            duedate = new Date(cal.getTimeInMillis());

            pstmt.setInt(1, member_id);
            pstmt.setInt(2, book_id);
            pstmt.setDate(3, borrowDate);
            pstmt.setDate(4, returnDate);
            pstmt.setDate(5, duedate);//date after 7 days
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new BorrowedBook(book_id, member_id, borrowDate, returnDate, duedate);
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
        String[] columns = {"Book id", "Title", "Author", "Issued Date", "Due Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        String sql = "SELECT Book.book_id, Book.title, Book.author, BorrowedBooks.borrow_date, BorrowedBooks.due_date FROM BorrowedBooks JOIN Book ON BorrowedBooks.book_id = Book.book_id WHERE member_id = ?";
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, memberId);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int bookId = resultSet.getInt("Book.book_id");
                    String book = resultSet.getString("Book.title");
                    String author = resultSet.getString("Book.author");
                    Date borrow_date = resultSet.getDate("BorrowedBooks.borrow_date");
                    Date due_date = resultSet.getDate("BorrowedBooks.due_date");
                    model.addRow(new Object[]{bookId, book, author, borrow_date, due_date});
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return model;
    }
}




















