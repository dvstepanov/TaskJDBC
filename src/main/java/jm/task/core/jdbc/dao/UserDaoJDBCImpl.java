package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = Util.getMySQLConnectionJDBC();
            statement = connection.createStatement();
            String SQL = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(50), " +
                    " lastName VARCHAR (50), " +
                    " age INTEGER not NULL, " +
                    " PRIMARY KEY (id))";

            statement.executeUpdate(SQL);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void dropUsersTable() throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = Util.getMySQLConnectionJDBC();
            statement = connection.createStatement();
            String SQL = "DROP TABLE IF EXISTS Users";

            statement.executeUpdate(SQL);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = Util.getMySQLConnectionJDBC();
            statement = connection.createStatement();
            String SQL = "INSERT INTO  Users " +
                    "(name, lastname, age) " +
                    "VALUES " +
                    "('" + name + "', '"
                    + lastName + "', "
                    + age + ")";

            statement.executeUpdate(SQL);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


    }

    public void removeUserById(long id) throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = Util.getMySQLConnectionJDBC();
            statement = connection.createStatement();
            String SQL = "DELETE FROM  Users WHERE id=" + id;

            statement.executeUpdate(SQL);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            connection = Util.getMySQLConnectionJDBC();
            statement = connection.createStatement();
            String SQL = "SELECT * FROM Users";

            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                userList.add(user);
            }


        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = Util.getMySQLConnectionJDBC();
            statement = connection.createStatement();
            String SQL = "TRUNCATE TABLE Users";

            statement.executeUpdate(SQL);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
