package myLibrary.Admin;

import myLibrary.util.DatabaseUtil;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    public void updateAdmin(Admin admin){
        //
    }
    public void deleteAdmin(int adminId){
        //
    }
    public Admin getAdminById(int adminId){
        Admin admin;
        admin = new Admin("Disha","jhadgsj", "skdb","s6546",1);
        return admin;
    }
    public DefaultTableModel getAllAdmins(){
        String[] columnNames = {"Admin Id", "Name", "Email", "Phone Number"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        String sql = "SELECT admin_id, full_name, email, phone_number FROM Admin";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                int adminId = resultSet.getInt("admin_id");
                String admin = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                model.addRow(new Object[]{adminId, admin, email, phone});
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return model;
    }
    public boolean validateAdmin(String email, String password){
        String sql = "SELECT * FROM Admin WHERE email = ? AND password = ?";
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
