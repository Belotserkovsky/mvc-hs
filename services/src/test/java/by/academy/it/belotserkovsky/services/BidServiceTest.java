package by.academy.it.belotserkovsky.services;

import by.academy.it.belotserkovsky.dao.interfacies.IBidDao;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.constants.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by K.Belotserkovsky
 */

@ContextConfiguration("/testServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@Transactional()
public class BidServiceTest {
    private static String KIND_OF_WORK = "kind of work";
    private static String SCOPE = "scope";
    private static String DESIRED_RUNTIME = "desired_runtime";
    private Long bidId;

    @Autowired
    IBidService bidService;

    @Autowired
    IBidDao bidDao;

    @Before
    public void before(){
        BidDto bidDto = new BidDto(KIND_OF_WORK, SCOPE, DESIRED_RUNTIME);
        Date currentDate = new Date(System.currentTimeMillis());
        String status = Status.OPEN.getType();
        Bid bid = new Bid(bidDto.getKindOfWorks(), bidDto.getScope(), bidDto.getDesiredRuntime(), currentDate, status);
        bidId = bidDao.saveOrUpdate(bid).getId();
    }

    @Test
    public void createBid() throws Exception {

        BidDto bidDto = new BidDto(KIND_OF_WORK, SCOPE, DESIRED_RUNTIME);
        bidService.createBid(bidDto);
    }

    @Test
    public void getAll() {
        List<BidDto> list = bidService.getBids();
        assertNotNull(list);
    }

    @Test
    public void getById(){
        Bid bid = bidService.getBidById(bidId);
        assertNotNull(bid);
    }

    @Test
    public void updateBid(){
        Bid bid = bidService.getBidById(bidId);
        bid.setStatus(Status.CLOSE.getType());
        bidService.updateBid(bid);
    }
}