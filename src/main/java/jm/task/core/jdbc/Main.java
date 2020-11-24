package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl testHibernate = new UserServiceImpl();
        testHibernate.createUsersTable();
        testHibernate.saveUser("Петя", "Иванов", (byte) 15);
        testHibernate.saveUser("Вася", "Сидров", (byte) 23);
        testHibernate.saveUser("Катя", "Петрова", (byte) 11);
        testHibernate.saveUser("Маша", "Машкина", (byte) 9);
        System.out.println(testHibernate.getAllUsers());
        testHibernate.cleanUsersTable();
        testHibernate.dropUsersTable();

    }

}





