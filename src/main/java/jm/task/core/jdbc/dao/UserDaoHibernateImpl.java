package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            String SQL = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(50), " +
                    " lastName VARCHAR (50), " +
                    " age INTEGER not NULL, " +
                    " PRIMARY KEY (id))";
            Session session = Util.getSessionFactory().openSession();
            session.createSQLQuery(SQL).executeUpdate();
            session.close();
            System.out.println("Creat table");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            String SQL = "DROP TABLE IF EXISTS Users";
            Session session = Util.getSessionFactory().openSession();
            session.createSQLQuery(SQL).executeUpdate();
            session.close();
            System.out.println("drop table");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user = new User(name, lastName, age);
            Session session = Util.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(session.get(User.class, id));
            tx1.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        try {
            Session session = Util.getSessionFactory().openSession();
            users = session.createQuery("From User").list();
            session.close();
            return users;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.createSQLQuery("TRUNCATE TABLE Users").executeUpdate();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
