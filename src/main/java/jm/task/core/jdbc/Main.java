package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

//        UserDao userDao = new UserDaoJDBCImpl();
//        userDao.createUsersTable();
//        userDao.saveUser("Name1", "LastName1", (byte) 20);
//        userDao.saveUser("Name2", "LastName2", (byte) 25);
//        userDao.saveUser("Name3", "LastName3", (byte) 31);
//        userDao.saveUser("Name4", "LastName4", (byte) 38);
//
//        userDao.removeUserById(1);
//        userDao.getAllUsers();
//        userDao.cleanUsersTable();
//        userDao.dropUsersTable();

        UserDao userDao2 = new UserDaoHibernateImpl();
        userDao2.dropUsersTable();
        userDao2.createUsersTable();
        userDao2.saveUser("Vova", "Joui", (byte) 22);
//        List<User> users = userDao2.getAllUsers();
//        userDao2.removeUserById(1);
//        userDao2.cleanUsersTable();
//        userDao2.dropUsersTable();
//        users.forEach(n -> System.out.println(n.getName()));

    }
}
