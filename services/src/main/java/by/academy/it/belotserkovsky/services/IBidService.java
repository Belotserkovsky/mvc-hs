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
     * @param bidDto
     */
    void updateBid(BidDto bidDto);

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
