package myLibrary.Member;

import myLibrary.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
    public void addMember(Member member){
        String sql = "INSERT INTO Member (m_name, email, password, phone) VALUES (?,?,?,?)";
        try(
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, member.name);
            statement.setString(2, member.email);
            statement.setString(3, member.password);
            statement.setString(4, member.phone);
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean findMember(String username, String password){
        return true;
    }
}
