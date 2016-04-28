package by.academy.it.belotserkovsky.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Kostya on 22.04.2016.
 */
public class HibernateUtil {
    private static HibernateUtil util = null;

    private static Logger log = Logger.getLogger(HibernateUtil.class);

    private SessionFactory sessionFactory = null;

    private final ThreadLocal sessions = new ThreadLocal();

    private HibernateUtil() {
        try {
            sessionFactory = new Configuration().
                    configure().setNamingStrategy(new CustomNamingStrategy()).buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            System.exit(0);
        }
    }

    /**
     * @return
     */
    public Session getSession () {
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
    public void closeSession(){
        getSession().close();
        sessions.set(null);
    }

    /**
     * @return
     */
    public static synchronized HibernateUtil getHibernateUtil(){
        if (util == null){
            util = new HibernateUtil();
        }
        return util;
    }
}
