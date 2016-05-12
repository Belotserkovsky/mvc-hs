package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BidDAO;
import by.academy.it.belotserkovsky.dto.BidDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Access to the class object BidDAO
 * Created by K.Belotserkovsky
 */
public class BidDAOService {
    private static Logger log = Logger.getLogger(BidDAOService.class);
    private BidDAO bidDAO;
    private Transaction transaction = null;
    private Session session = null;

    private static BidDAOService instance;

    public synchronized static BidDAOService getInstance() {
        if (instance == null) {
            instance = new BidDAOService();
        }
        return instance;
    }

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
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("DAO exception in service layer during addBid(): " + e);
            HibernateUtil.closeSession();
        }
    }

    /**
     * @param bidDTO
     * @return Long bidID
     */
    public Long createBid (BidDTO bidDTO) {
        Bid bid = null;
        Long bidId = null;
        if(bidDTO != null) {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            bid = new Bid(bidDTO.getKindOfWorks(), bidDTO.getScope(), bidDTO.getDesiredRuntime());
            User user = UserDAOService.getInstance().getById(bidDTO.getUid());
            bid.setUser(user);
            try {
                bidDAO.saveOrUpdate(bid);
            } catch (ExceptionDAO e) {
                transaction.rollback();
                log.error("DAO exception in service layer during saveOrUpdate() bid: " + e);
                HibernateUtil.closeSession();
            }
            transaction.commit();
        }
        session.evict(bid);
        bidId = bid.getBId();
        return bidId;
    }

    /**
     * @param bId
     * @return Bid
     */
    public Bid getBid(Long bId) {
        Bid bid = null;
        try {
            bid = bidDAO.get(bId);
        } catch (ExceptionDAO e) {
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("DAO exception in service layer during getBid(): " + e);;
            HibernateUtil.closeSession();
        }
        return bid;
    }

    /**
     * @return List of bids
     */
    public List<BidDTO> getBidsList() {
        List<BidDTO> allBids = null;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        allBids = bidDAO.getAll();
        transaction.commit();
        return allBids;
    }
}
