package by.academy.it.belotserkovsky.dao.interfacies;

import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public interface IBidDao extends Dao<Bid> {

    /**
     * Get all bids with brigade and user info
     * @return List<BidDto>
     */
    List<BidDto> getAll();
}
