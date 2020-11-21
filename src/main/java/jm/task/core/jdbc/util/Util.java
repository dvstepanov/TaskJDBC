package jm.task.core.jdbc.util;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.*;

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

    // Connect to MySQL Hibernate
    /*private static SessionFactory configureSessionFactory()
            throws HibernateException {

        // Настройки hibernate
        Configuration configuration = new Configuration()
                .setProperty( "hibernate.connection.driver_class",
                        "com.mysql.jdbc.Driver" )
                .setProperty( "hibernate.connection.url", connectionURL )
                .setProperty( "hibernate.connection.username", userName )
                .setProperty( "hibernate.connection.password", password)
                .setProperty( "hibernate.connection.pool_size", "1" )
                .setProperty( "hibernate.connection.autocommit", "false" )
                .setProperty( "hibernate.cache.provider_class",
                        "org.hibernate.cache.NoCacheProvider" )
                .setProperty( "hibernate.cache.use_second_level_cache",
                        "false" )
                .setProperty( "hibernate.cache.use_query_cache", "false" )
                .setProperty( "hibernate.dialect",
                        "org.hibernate.dialect.MySQLDialect" )
                .setProperty( "hibernate.show_sql","true" )
                .setProperty( "hibernate.current_session_context_class",
                        "thread" )
                .addPackage( "ru.miralab.db" )
                .addAnnotatedClass(User.class)
                ;
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }*/

}
