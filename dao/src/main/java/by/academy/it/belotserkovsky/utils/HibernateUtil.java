package by.academy.it.belotserkovsky.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Class-helper to work with hibernate
 * Created by K.Belotserkovsky
 */
public class HibernateUtil {
    private static Logger log = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal sessions = new ThreadLocal();

    /**
     * Block to initialize SessionFactory.
     */
    static {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Method for obtaining object Session
     * @return Session
     */
    public static Session getSession () {
        Session session = (Session) sessions.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    /**
     * Closure of the session and the release thread-local
     */
    public static void closeSession(){
        Session session = (Session) sessions.get();
        if(session != null) {
            getSession().close();
            sessions.set(null);
        }
    }

    /**
     * @return Session Factory
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
