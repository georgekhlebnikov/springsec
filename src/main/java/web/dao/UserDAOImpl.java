package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.*;

//Аннотации @Repository @Service @Controller являются производными от @Component
@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    //лучше использовать конструктор или сеттер
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //получаем сессию и делаем запрос к бд
    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    // переопределяем из UserDAO
    //@Override
    //public User findByUsername(String name) {
        //Session session = sessionFactory.getCurrentSession();
        //return session.get(User.class, name);

    //    Query query= sessionFactory.getCurrentSession().createQuery("from User where name = :name");
    //    query.setParameter("name", name);
    //    return (User) query.getSingleResult(); //.uniqueResult();
    //}

}
