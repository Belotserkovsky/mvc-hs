package by.academy.it.belotserkovsky.services;

import by.academy.it.belotserkovsky.dao.interfacies.IBidDao;
import by.academy.it.belotserkovsky.dao.interfacies.IUserDao;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.constants.Status;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Access to the class object BidDao
 * Created by K.Belotserkovsky
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BidService implements IBidService{
    private static Logger log = Logger.getLogger(BidService.class);

    @Autowired
    private IBidDao bidDao;

    @Autowired
    private IUserDao userDao;

    /**
     * @param bidDto
     * @return Long bidID
     */
    public Long createBid (BidDto bidDto) {
        Long bidId = null;
        if(bidDto != null) {
            Date currentDate = new Date(System.currentTimeMillis());
            String status = Status.OPEN.getType();
            Bid bid = new Bid(bidDto.getKindOfWorks(), bidDto.getScope(), bidDto.getDesiredRuntime(), currentDate, status);
            User user = userDao.get(bidDto.getUserId());
            bid.setUser(user);
            bidId = bidDao.saveOrUpdate(bid).getId();
        }
//        bidId = bid.getId();
        return bidId;
    }

    public void updateBid(BidDto bidDto){
        Bid bid = bidDao.get(bidDto.getBidId());
        bid.setStatus(bidDto.getStatus());
        bidDao.saveOrUpdate(bid);
    }

    public Bid getBidById(Long bidId) {
        Bid bid = bidDao.get(bidId);
        return bid;
    }

    public List<BidDto> getBids() {
        List<BidDto> allBids = null;
        allBids = bidDao.getAll();
        return allBids;
    }
}
