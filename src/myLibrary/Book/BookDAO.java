package myLibrary.Book;

import myLibrary.util.DatabaseUtil;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    public void addBook(Book book){
        String sql = "INSERT INTO books (title, author, genre, quantity) VALUES (?, ?, ?, ?)";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, book.title);
            statement.setString(2, book.author);
            statement.setString(3, book.genre);
            statement.setInt(4, book.quantity);
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteBook(int bookId){
        String sql = "DELETE FROM Book WHERE book_id="+ bookId;
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public Book getBookById(int bookId){
        String sql = "SELECT book_id, title, author, genre, quantity FROM Book WHERE book_id = ?";
        Book retBook = null;
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, bookId);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    int book_Id = resultSet.getInt("book_id");
                    String book = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String genre = resultSet.getString("genre");
                    int quantity = resultSet.getInt("quantity");
                    retBook = new Book(book_Id, quantity, book, author, genre);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println(retBook);
        return retBook;
    }
    public DefaultTableModel getAllBooks(){
        String[] columnNames = {"Book Id", "Title", "Author", "Genre", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        String sql = "SELECT book_id, title, author, genre, quantity FROM Book";
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String book = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                int quantity = resultSet.getInt("quantity");
                model.addRow(new Object[]{bookId, book, author, genre, quantity});
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return model;
    }

    public boolean updateQuantity(int id, boolean increase) {
        String sql = "UPDATE Book SET quantity = ? WHERE book_id = ?";
        Book book = getBookById(id);
        if(book == null){
            System.out.println("Book not available.");
            return false;
        }
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            int quantity = increase ? book.quantity + 1 : book.quantity - 1;
            if(quantity < 0){
                return false;
            }
            statement.setInt(1, quantity);
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
