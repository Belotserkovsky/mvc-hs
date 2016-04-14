package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BidDAO;
import by.academy.it.belotserkovsky.entity.Bid;
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

    public static BidDAOService getInstance() {
        if (instance == null) {
            instance = new BidDAOService();
        }
        return instance;
    }

    private BidDAO bidDAO;

    public BidDAOService() {
        bidDAO = BidDAO.getInstance();
    }

    public void addBid (Bid bid) {
        try {
            bidDAO.create(bid);
        } catch (SQLException e) {
            log.error("SQL exception: " + e);
        }
    }

    public Bid getBidByUserID(Integer key) {
        try {
            return bidDAO.read(key);
        } catch (SQLException e) {
            log.error("SQL exception: " + e);;
            return null;
        }
    }

    public List<Bid> getBidsList() {
        try {
            return bidDAO.readAll();
        } catch (SQLException e) {
            log.error("SQL exception: " + e);
            return null;
        }
    }

    public void updateBid (Bid bid) {
        try {
            bidDAO.isUpdate(bid);
        } catch (SQLException e) {
            log.error("SQL exception: " + e);
        }
    }
}
