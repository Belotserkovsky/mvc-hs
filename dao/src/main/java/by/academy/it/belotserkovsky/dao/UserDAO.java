package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;

/**
 * Created by Kostya on 24.04.2016.
 */
public class UserDAO extends BaseDAO<User>{
    private static Logger log = Logger.getLogger(UserDAO.class);
    private Transaction transaction = null;

    /**
     * @param login
     * @param pass
     * @return
     * @throws ExceptionDAO
     */
    public User get(String login, String pass) throws ExceptionDAO {
        User user = null;
        log.info("Get user by login and pass:" + login +"-" + pass);
        try{
            Session session = HibernateUtil.getSession();
            String hql = "SELECT user FROM User user WHERE user.login=:login AND user.password=:pass";
            Query query = session.createQuery(hql);
            query.setParameter("login", login);
            query.setParameter("pass", pass);
            List<User> results = query.list();
            if(!results.isEmpty()){
                for(User result : results){
                    user = result;
                }
            }
            log.info("Get user: " + user);
        }catch (HibernateException e){
            log.error("Error get user by login in DAO: " + e);
            throw new ExceptionDAO(e);
        }
        return user;
    }

    /**
     * @param uid
     * @return
     * @throws ExceptionDAO
     */
    public UserDTO getDTO(Long uid) throws ExceptionDAO {
        UserDTO userDTO = null;
        try {
            Session session = HibernateUtil.getSession();
            userDTO = (UserDTO) session.createSQLQuery("SELECT u.F_UID as uid, u.F_FIRSTNAME as firstName, " +
                    "u.F_SECONDNAME as secondName, u.F_LOGIN as login, " +
                    "u.F_PASSWORD as pass, uc.F_ADDRESS as address, " +
                    "uc.F_PHONE as phone, uc.F_EMAIL as email " +
                    "from t_user u JOIN t_usercontacts uc ON u.F_UID=uc.F_UID")
                    .addScalar("uid", StandardBasicTypes.LONG)
                    .addScalar("firstName", StandardBasicTypes.STRING)
                    .addScalar("secondName", StandardBasicTypes.STRING)
                    .addScalar("login", StandardBasicTypes.STRING)
                    .addScalar("pass", StandardBasicTypes.STRING)
                    .addScalar("address", StandardBasicTypes.STRING)
                    .addScalar("phone", StandardBasicTypes.STRING)
                    .addScalar("email", StandardBasicTypes.STRING)
                    .setResultTransformer(Transformers.aliasToBean(UserDTO.class)).uniqueResult();
        } catch (NonUniqueResultException e) {
            log.error(e.getMessage());
        }
        return userDTO;
    }
//                    {private static final long serialVersionUID = 1L;
//                    public Object tranformTuple(Object[] arg0, String[] arg1){
//                        UserDTO userDTO = new UserDTO();
//                        userDTO.setUserId((Long)arg0[0]);
//                        userDTO.setFirstName((String)arg0[1]);
//                        userDTO.setSecondName((String)arg0[2]);
//                        userDTO.setLogin((String)arg0[3]);
//                        userDTO.setPassword((String)arg0[4]);
//                        userDTO.setAddress((String)arg0[5]);
//                        userDTO.setPhone((String)arg0[6]);
//                        userDTO.setEmail((String)arg0[7]);
//
//                        return userDTO;
//                    }
//
//                    @SuppressWarnings("unchecked")
//                    public List transformList(List arg0){
//                        return arg0;
//                    }
//                }).uniqueResult();
//    }catch (NonUniqueResultException e){
//        log.error(e.getMessage());
//    }


}
