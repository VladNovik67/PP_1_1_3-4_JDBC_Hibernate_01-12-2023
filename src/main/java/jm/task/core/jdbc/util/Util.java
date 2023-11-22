package jm.task.core.jdbc.util;

import org.hibernate.engine.jdbc.connections.internal.DriverConnectionCreator;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public static final String DB_URL ="jdbc:mysql://localhost:3306/mydbtest";
    public static final String userName ="root";
    public static final String password ="Guantanama20237654!";

        public Connection getConnection() {
        Connection connection = null;
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, userName, password);
            }  catch (SQLException  | ClassNotFoundException e) {
                e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
                System.out.println("Ошибка SQL !");
            }
        }
        return connection;
    }
}
