package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserContactsDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import org.apache.log4j.Logger;

/**
 * Created by Kostya on 27.04.2016.
 */
public class UContactsDAOService {
    private static Logger log = Logger.getLogger(UContactsDAOService.class);
    private UserContactsDAO userContactsDAO;

    private static UContactsDAOService instance;

    public static synchronized UContactsDAOService getInstance() {
        if (instance == null) {
            instance = new UContactsDAOService();
        }
        return instance;
    }

    public UContactsDAOService() {
        userContactsDAO = new UserContactsDAO();
    }

    public void createOrUpdate(UserContacts uContacts){
        try {
            if (uContacts != null) {
                userContactsDAO.saveOrUpdate(uContacts);
            }
        }catch (ExceptionDAO e){

        }
    }
}
