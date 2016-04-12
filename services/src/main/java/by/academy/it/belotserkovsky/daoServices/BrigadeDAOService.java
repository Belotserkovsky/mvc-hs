package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BrigadeDAO;
import by.academy.it.belotserkovsky.entity.Brigade;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object BrigadeDAO
 * Created by Kostya on 08.04.2016.
 */

public class BrigadeDAOService {
    private static BrigadeDAOService instance;

    public static BrigadeDAOService getInstance() {
        if (instance == null) {
            instance = new BrigadeDAOService();
        }
        return instance;
    }

    private BrigadeDAO brigadeDAO;

    public BrigadeDAOService() {
        brigadeDAO = BrigadeDAO.getInstance();
    }

    public Brigade getBrigadeByName (String name){

        Brigade brigade = null;

       try {
           if (name.length() != 0) {
               brigade = BrigadeDAO.getInstance().read(name);
               return brigade;
           }
       }catch (SQLException e){
           //log;
       }
        return null;
    }

    public void addBrigade (Brigade brigade) {
        try {
            brigadeDAO.create(brigade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBrigade (Object key) {

        try {
                if (brigadeDAO.isDelete(key)){
                //
            } else {
                //log
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Brigade> getBrigadesList () {
        try {
            return brigadeDAO.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String addBrigade (String[] selected){

        String nameBrigade = "";
        Brigade newBrigade = null;

        try{
            if(selected.length != 0) {
                for (int i = 0; i < selected.length; ++i) {
                    nameBrigade += "/" + selected[i] + "/";
                }
            }
            newBrigade = new Brigade (nameBrigade);
            brigadeDAO.create(newBrigade);
            //log
        }catch (SQLException e){
            //log
        }
        return nameBrigade;
    }
}
