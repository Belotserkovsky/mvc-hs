package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BidDAO;
import by.academy.it.belotserkovsky.entity.Bid;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object BidDAO
 * Created by Kostya on 08.04.2016.
 */
public class BidDAOService {

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
            e.printStackTrace();
        }
    }

    public Bid getBidByUserLogin(String login) {
        try {
            return bidDAO.read(login);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Bid> getBidsList() {
        try {
            return bidDAO.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateBid (Bid bid) {
        try {
            bidDAO.update(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
