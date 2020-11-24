package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    // Connect to MySQL JDBC
    private static String connectionURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=UTC";
    private static String userName = "root";
    private static String password = "root";


    public static Connection getMySQLConnectionJDBC() throws SQLException {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection ERROR");
        }

        return connection;
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.driver_class",
                                "com.mysql.cj.jdbc.Driver")
                        .setProperty("hibernate.connection.url", connectionURL)
                        .setProperty("hibernate.connection.username", userName)
                        .setProperty("hibernate.connection.password", password)
                        .setProperty("hibernate.dialect",
                                "org.hibernate.dialect.MySQLDialect")
                        .setProperty("hibernate.show_sql", "true")
                        .addAnnotatedClass(User.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
