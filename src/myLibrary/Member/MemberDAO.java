package myLibrary.Member;

import myLibrary.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void updateMember(Member member){
        //
    }
    public void deleteMember(int memberId){
        //
    }
    public Member getMemberById(int memberId){
        Member member = null;
        return member;
    }
//    public List<Member> getAllMembers(){
//        //
//    }
    public Member findMember(String email, String password){
        String sql = "SELECT * FROM Member WHERE email = ? AND password = ?";
        try(
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int memberId = resultSet.getInt("member_id");
                String name = resultSet.getString("name");
                String emailFromDb = resultSet.getString("email");
                String passwordFromDb = resultSet.getString("password");
                String phone = resultSet.getString("phone_number");

                return new Member(memberId, name, emailFromDb, passwordFromDb, phone);
            } else {
                return null;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
