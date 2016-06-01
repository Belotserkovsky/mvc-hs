package by.academy.it.belotserkovsky.services;

import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public interface IBidService {

    /**
     * @param bidDto
     * @return bidId
     */
    Long createBid(BidDto bidDto);

    /**
     * @param bid
     */
    void updateBid(Bid bid);

    /**
     * @param bidId
     * @return bid
     */
    Bid getBidById(Long bidId);

    /**
     * @return List of bids
     */
    List<BidDto> getBids();


}
