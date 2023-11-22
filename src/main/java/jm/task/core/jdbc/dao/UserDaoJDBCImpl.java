package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = new Util().getConnection();
//    public static void main(String[] args) throws SQLException {
////        new UserDaoJDBCImpl().dropUsersTable();
//        new UserDaoJDBCImpl().createUsersTable();
//        new UserDaoJDBCImpl().saveUser("Name1", "LastName1", (byte) 20);
//
//    }
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable()  {
        try (Statement statement = connection.createStatement();){
//            statement.executeUpdate("drop table Books");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books (id BIGINT NOT NULL AUTO_INCREMENT, name CHAR(30) , lastname CHAR(30) , age TINYINT(3) , PRIMARY KEY(id))");

//            statement.executeUpdate("INSERT INTO Books (name, lastname, age) values ('Dante','Roger', 10)");
//            statement.executeUpdate("INSERT INTO Books (lastname) values ('Dante')");
//            statement.executeUpdate("INSERT INTO Books set name = 'Vova'");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table books");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books (id BIGINT NOT NULL AUTO_INCREMENT, name CHAR(30) , lastname CHAR(30) , age TINYINT(3) , PRIMARY KEY(id))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        String sql = "INSERT INTO books(name, lastname, age) VALUES(?, ?, ?)";

        try (PreparedStatement pstmt= connection.prepareStatement(sql)){
//            statement.executeUpdate("INSERT INTO Books (name, lastname, age) values (name,lastName,  age)");
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setByte(3, age);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM books WHERE ID=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong((int) id, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        String sql = "SELECT ID, NAME, LASTNAME, AGE FROM books";

        try (ResultSet resultSet = connection.createStatement().executeQuery(sql)){
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM books";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
