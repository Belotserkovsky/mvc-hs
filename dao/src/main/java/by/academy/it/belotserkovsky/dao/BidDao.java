package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dto.BidDTO;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;

/**
 * Class inherits the properties of BaseDao
 * Created by Kostya on 24.04.2016.
 */
public class BidDao extends BaseDao<Bid> {
    private static Logger log = Logger.getLogger(BidDao.class);

    /**
     * Get all bids with brigade info
     * @return List<BidDTO>
     */
    public List<BidDTO> getAll() {
        List<BidDTO> all = null;
        Session session = HibernateUtil.getSession();
        all = (List<BidDTO>) session.createSQLQuery("SELECT b.F_BID as bId, b.F_DESIREDRUNTIME as desiredRuntime, " +
                "b.F_KINDOFWORKS as kindOfWorks, b.F_SCOPE as scope," +
                "br.F_TITLE as brigadeTitle, b.f_user_id as uid from t_bid b JOIN t_brigade br ON b.F_BID=br.F_BID")
                .addScalar("bId", StandardBasicTypes.LONG)
                .addScalar("desiredRuntime", StandardBasicTypes.STRING)
                .addScalar("kindOfWorks", StandardBasicTypes.STRING)
                .addScalar("scope", StandardBasicTypes.STRING)
                .addScalar("brigadeTitle", StandardBasicTypes.STRING)
                .addScalar("uid", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(BidDTO.class)).list();
        return all;
    }
}
