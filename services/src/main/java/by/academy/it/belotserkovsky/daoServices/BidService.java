package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BidDao;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.exceptions.ExceptionDao;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Access to the class object BidDao
 * Created by K.Belotserkovsky
 */
public class BidService {
    private static Logger log = Logger.getLogger(BidService.class);
    private BidDao bidDAO;
    private Transaction transaction = null;
    private Session session = null;

    private static BidService instance;

    /**
     * @return Singleton
     */
    public synchronized static BidService getInstance() {
        if (instance == null) {
            instance = new BidService();
        }
        return instance;
    }

    public BidService() {
        bidDAO = new BidDao();
    }

    /**
     * @param bid
     */
    public void createOrUpdate (Bid bid) {
        try {
            if(bid != null) {
                bidDAO.saveOrUpdate(bid);
            }
        } catch (ExceptionDao e) {
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("Dao exception in service layer during addBid(): " + e);
            HibernateUtil.closeSession();
        }
    }

    /**
     * @param bidDto
     * @return Long bidID
     */
    public Long createBid (BidDto bidDto) {
        Bid bid = null;
        Long bidId = null;
        if(bidDto != null) {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            bid = new Bid(bidDto.getKindOfWorks(), bidDto.getScope(), bidDto.getDesiredRuntime());
            User user = UserService.getInstance().getById(bidDto.getUid());
            bid.setUser(user);
            try {
                bidDAO.saveOrUpdate(bid);
            } catch (ExceptionDao e) {
                transaction.rollback();
                log.error("Dao exception in service layer during saveOrUpdate() bid: " + e);
                HibernateUtil.closeSession();
            }
            transaction.commit();
        }
        session.evict(bid);
        bidId = bid.getId();
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
        } catch (ExceptionDao e) {
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("Dao exception in service layer during getBid(): " + e);;
            HibernateUtil.closeSession();
        }
        return bid;
    }

    /**
     * @return List of bids
     */
    public List<BidDto> getBidsList() {
        List<BidDto> allBids = null;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        allBids = bidDAO.getAll();
        transaction.commit();
        return allBids;
    }
}
