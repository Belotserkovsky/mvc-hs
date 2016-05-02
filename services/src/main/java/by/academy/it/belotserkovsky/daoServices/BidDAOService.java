package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BidDAO;
import by.academy.it.belotserkovsky.dao.BrigadeDAO;
import by.academy.it.belotserkovsky.dao.WorkerDAO;
import by.academy.it.belotserkovsky.dto.BidDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.Brigade;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.apache.tools.ant.taskdefs.Manifest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * @param bid
     */
    public void createOrUpdate (Bid bid) {
        try {
            if(bid != null) {
                bidDAO.saveOrUpdate(bid);
            }
        } catch (ExceptionDAO e) {
            log.error("DAO exception in service layer during addBid(): " + e);
        }
    }

    public void create (BidDTO bidDTO){
        Bid bid = null;
        Worker worker = null;
        Brigade brigade = null;
        Set<Worker> workers = new HashSet<Worker>();
        WorkerDAO workerDAO = null;
        String profession = null;
        String[] selected = bidDTO.getSelectedWorkers();
        Transaction transaction = null;

        try{
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            brigade = BrigadeDAOService.getInstance().createForBid(selected);
            bid = new Bid(bidDTO.getKindOfWorks(), bidDTO.getScope(), bidDTO.getDesiredRuntime());
            bid.setBrigade(brigade);
            User user = UserDAOService.getInstance().getById(bidDTO.getUid());
            bid.setUser(user);
            bidDAO.saveOrUpdate(bid);
            transaction.commit();
        }catch (ExceptionDAO e){
            transaction.rollback();
            log.error("DAO exception in service layer create() bid: " + e);
        }
    }

    /**
     * @param key
     * @return
     */
    public Bid getBid(Long key) {
        try {
            return bidDAO.get(key);
        } catch (ExceptionDAO e) {
            log.error("DAO exception in service layer during getBid(): " + e);;
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

    /**
     * @param bid
     */
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
