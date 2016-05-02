package by.academy.it.belotserkovsky.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Kostya on 28.04.2016.
 */
public class HibernateUtil {
    private static Logger log = Logger.getLogger(HibernateUtil.class);
   // private static HibernateUtil util = null;
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal sessions = new ThreadLocal();

    static {
        try {
            sessionFactory = new Configuration().configure().setNamingStrategy(new CustomNamingStrategy()).buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * @return
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
     *
     */
    public static void closeSession(){
        getSession().close();
        sessions.set(null);
    }

    /**
     * @return
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
