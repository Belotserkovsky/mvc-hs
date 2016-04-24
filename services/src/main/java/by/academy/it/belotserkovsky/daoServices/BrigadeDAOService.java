package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.pojos.Brigade;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object BrigadeDAO
 * Created by Kostya on 08.04.2016.
 */

public class BrigadeDAOService {
//    private static Logger log = Logger.getLogger(BrigadeDAOService.class);
//
//    private static BrigadeDAOService instance;
//
//    public static BrigadeDAOService getInstance() {
//        if (instance == null) {
//            instance = new BrigadeDAOService();
//        }
//        return instance;
//    }
//
//    private BrigadeDAO brigadeDAO;
//
//    public BrigadeDAOService() {
//        brigadeDAO = BrigadeDAO.getInstance();
//    }
//
//    public Brigade getBrigadeByName (String name){
//
//        Brigade brigade = null;
//
//       try {
//           if (name.length() != 0) {
//               brigade = BrigadeDAO.getInstance().read(name);
//               return brigade;
//           }
//       }catch (SQLException e){
//           log.error("SQL exception: " + e);
//       }
//        return null;
//    }
//
//    public void addBrigade (Brigade brigade) {
//        try {
//            brigadeDAO.create(brigade);
//        } catch (SQLException e) {
//            log.error("SQL exception: " + e);
//        }
//    }
//
//    public void deleteBrigade (Object key) {
//
//        try {
//                if (brigadeDAO.isDelete(key)){
//                log.info("Deleted: " + key);
//            } else {
//                log.info("Not delete: " + key);
//            }
//        }catch (SQLException e){
//            log.error("SQL exception: " + e);
//        }
//    }
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
