package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.BrigadeDao;
import by.academy.it.belotserkovsky.dao.interfacies.IBidDao;
import by.academy.it.belotserkovsky.dao.interfacies.IBrigadeDao;
import by.academy.it.belotserkovsky.dao.interfacies.IWorkerDao;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.Brigade;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Access to the class object BrigadeDao
 * Created by Kostya on 08.04.2016.
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BrigadeService implements IBrigadeService{
    private static Logger log = Logger.getLogger(BrigadeService.class);

    @Autowired
    private IWorkerDao workerDao;

    @Autowired
    private IBidDao bidDao;

    public void createBrigade (String[] selected, Long bidId){
        if (selected.length > 0 && bidId != null) {
            Bid bid = null;
            Brigade brigade = null;
            String title = "";
            Worker worker = null;
            Set<Worker> workers = new HashSet<Worker>();
            String profession = null;

            for (int i = 0; i < selected.length; ++i) {
                profession = selected[i];
                title += (", " + profession.toLowerCase());
                worker = workerDao.getByProfession(profession);
                workers.add(worker);
            }

            brigade = new Brigade(title.substring(2));
            for (Worker w : workers){
                w.getBrigades().add(brigade);
                workerDao.saveOrUpdate(w);
            }

            bid = bidDao.get(bidId);
            bid.setBrigade(brigade);
            brigade.setBid(bid);
            bidDao.saveOrUpdate(bid);
        }
    }
}
