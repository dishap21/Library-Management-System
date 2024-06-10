package myLibrary.Book;

import myLibrary.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    public void addBook(Book book){
        String sql = "INSERT INTO books (title, author, genre, quantity) VALUES ()";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, book.title);
            statement.setString(2, book.author);
            statement.setString(3, book.genre);
            statement.setInt(4, book.quantity);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
