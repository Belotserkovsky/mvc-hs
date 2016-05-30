package by.academy.it.belotserkovsky.services;

import by.academy.it.belotserkovsky.dao.interfacies.IBidDao;
import by.academy.it.belotserkovsky.dao.interfacies.IWorkerDao;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.Brigade;
import by.academy.it.belotserkovsky.pojos.Worker;
import org.apache.log4j.Logger;
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

    public void createBrigade (String[] kindsOfWorks, Long bidId){
        Bid bid = null;
        Brigade brigade = null;
        String brigadeTitle = "";
        Worker worker = null;
        Set<Worker> workers = new HashSet<Worker>();

        for (String element : kindsOfWorks){
            String profession = defineProfession(element);
            brigadeTitle += (", " + profession);
            worker = workerDao.getByProfession(profession);
            workers.add(worker);
        }

        brigade = new Brigade(brigadeTitle.substring(2));
        for (Worker w : workers){
            w.getBrigades().add(brigade);
            workerDao.saveOrUpdate(w);
        }

        bid = bidDao.get(bidId);
        bid.setBrigade(brigade);
        brigade.setBid(bid);
        bidDao.saveOrUpdate(bid);
    }

    public String defineProfession(String kindOfWorks){
        switch (kindOfWorks){
            case("электротехнические"): return "электрик";
            case("сантехнические"): return "сантехник";
            case("сварочные"): return "сварщик";
            case("отделочные"): return "моляр/штукатур";
            default: return "Invalid kindOfWorks";
        }
    }
}
