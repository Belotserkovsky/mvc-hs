package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BidDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Bid;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object BidDAO
 * Created by Kostya on 08.04.2016.
 */
public class BidDAOService {
    private static Logger log = Logger.getLogger(BidDAOService.class);

    private static BidDAOService instance;

    public synchronized static BidDAOService getInstance() {
        if (instance == null) {
            instance = new BidDAOService();
        }
        return instance;
    }

    private BidDAO bidDAO;

    public BidDAOService() {
        bidDAO = new BidDAO();
    }

    public void addBid (Bid bid) {
        try {
            if(bid != null) {
                bidDAO.saveOrUpdate(bid);
            }
        } catch (ExceptionDAO e) {
            log.error("DAO exception in service layer during addBid(): " + e);
        }
    }

    public Bid getBidByUserID(Integer key) {
        try {
            return bidDAO.get(key);
        } catch (ExceptionDAO e) {
            log.error("DAO exception in service layer during getBidByUserID(): " + e);;
            return null;
        }
    }

//    public List<Bid> getBidsList() {
//        try {
//            return bidDAO.readAll();
//        } catch (SQLException e) {
//            log.error("SQL exception: " + e);
//            return null;
//        }
//    }

    public void deleteBid (Bid bid) {
        try {
            if(bid != null) {
                bidDAO.delete(bid);
            }
        } catch (ExceptionDAO e) {
            log.error("DAO exception in service layer during deleteBid(): " + e);
        }
    }
}
