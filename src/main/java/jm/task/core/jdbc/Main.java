package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl testJDBC = new UserServiceImpl();
        testJDBC.createUsersTable();
        testJDBC.saveUser("Петя", "Иванов", (byte) 15);
        testJDBC.saveUser("Вася", "Сидров", (byte) 23);
        testJDBC.saveUser("Катя", "Петрова", (byte) 11);
        testJDBC.saveUser("Маша", "Машкина", (byte) 9);
        System.out.println(testJDBC.getAllUsers());
        testJDBC.cleanUsersTable();
        testJDBC.dropUsersTable();



    }

}





