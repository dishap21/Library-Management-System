package myLibrary.Admin;

import myLibrary.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO {

    public void addAdmin(Admin admin){
        String sql = "INSERT INTO books (full_name, password, email, phone_number) VALUES ()";
        try(
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, admin.name);
            statement.setString(2, admin.password);
            statement.setString(3, admin.email);
            statement.setString(4, admin.phone);
            statement.executeUpdate();
        }catch(
                SQLException e){
            e.printStackTrace();
        }
    }
    public boolean findAdmin(String username, String password){
        return true;
    }
}
