package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BrigadeDAO;
import by.academy.it.belotserkovsky.dao.WorkerDAO;
import by.academy.it.belotserkovsky.dto.BidDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.Brigade;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Access to the class object BrigadeDAO
 * Created by Kostya on 08.04.2016.
 */

public class BrigadeDAOService {
    private static Logger log = Logger.getLogger(BrigadeDAOService.class);
    private BrigadeDAO brigadeDAO;
    private Transaction transaction = null;
    private Session session = null;

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
     * parse date input through checkbox
     * @param selected
     * @return
     */
    public void createBrigade (String[] selected, Long bidId){
        if (selected.length > 0 && bidId != null) {
            Bid bid = null;
            Brigade brigade = null;
            String title = "";
            Worker worker = null;
            Set<Worker> workers = new HashSet<Worker>();
            String profession = null;
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < selected.length; ++i) {
                profession = selected[i];
                title += (", " + profession.toLowerCase());
                worker = WorkerDAOService.getInstance().getByProfession(profession);
                workers.add(worker);
            }

            brigade = new Brigade(title.substring(2));
            for (Worker w : workers){
                w.getBrigades().add(brigade);
                WorkerDAOService.getInstance().createOrUpdate(w);
            }

            bid = BidDAOService.getInstance().getBid(bidId);
            bid.setBrigade(brigade);
            brigade.setBid(bid);
            BidDAOService.getInstance().createOrUpdate(bid);
            transaction.commit();
        }
    }
}
