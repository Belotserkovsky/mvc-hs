package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BrigadeDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Brigade;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object BrigadeDAO
 * Created by Kostya on 08.04.2016.
 */

public class BrigadeDAOService {
    private static Logger log = Logger.getLogger(BrigadeDAOService.class);
    private BrigadeDAO brigadeDAO;
    private static BrigadeDAOService instance;

    public static BrigadeDAOService getInstance() {
        if (instance == null) {
            instance = new BrigadeDAOService();
        }
        return instance;
    }

    public BrigadeDAOService() {
        brigadeDAO = new BrigadeDAO();
    }

    /**
     * @param brigade
     */
    public void createOrUpdate(Brigade brigade){
        try{
            if(brigade != null){
                brigadeDAO.saveOrUpdate(brigade);
            }
        }catch(ExceptionDAO e){
            log.error("DAO exception in service layer during createOrUpdate() brigade: " + e);
        }
    }

    /**
     * @param brigade
     */
    public void delete (Brigade brigade) {

        try {
            if(brigade != null){
                brigadeDAO.delete(brigade);
            }
        }catch (ExceptionDAO e){
            log.error("DAO exception in service layer during delete() brigade: " + e);
        }
    }
//
//    public List<Brigade> getBrigadesList () {
//        try {
//            return brigadeDAO.readAll();
//        } catch (SQLException e) {
//            log.error("SQL exception: " + e);
//            return null;
//        }
//    }
//
//    /**
//     *
//     *parse date input through checkbox
//     */
//    public String addBrigade (String[] selected){
//
//        String nameBrigade = "";
//        Brigade newBrigade = null;
//
//        try{
//            if(selected.length != 0) {
//                for (int i = 0; i < selected.length; ++i) {
//                    nameBrigade += "/" + selected[i] + "/";
//                }
//            }
//            newBrigade = new Brigade (nameBrigade);
//            brigadeDAO.create(newBrigade);
//        }catch (SQLException e){
//            log.error("SQL exception: " + e);
//        }
//        return nameBrigade;
//    }
}
