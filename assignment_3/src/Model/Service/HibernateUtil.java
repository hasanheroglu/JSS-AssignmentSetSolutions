package Model.Service;


import Model.DAO.PrimaryKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class HibernateUtil {

    public static <T>void add(T dao){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(dao.getClass());
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(dao);
        transaction.commit();
        session.close();
    }
    public static <T>void update(T dao){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        
        configuration.addAnnotatedClass(dao.getClass());
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(dao);
        transaction.commit();
        session.close();
    }
    public static <T, X extends  Serializable>T search(Class clazz, X primaryKey){
        T object = null;
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(clazz);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PrimaryKey<X> key = new PrimaryKey<X>(primaryKey);
        object = (T) session.get(clazz, primaryKey);
        transaction.commit();
        session.close();

        return object;
    }
}
