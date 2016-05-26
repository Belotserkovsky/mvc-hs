package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IBidDao;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class inherits the properties of BaseDao
 * Created by K.Belotserkovsky
 */
@Repository
public class BidDao extends BaseDao<Bid> implements IBidDao{
    private static Logger log = Logger.getLogger(BidDao.class);

    @Autowired
    public BidDao (SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List<BidDto> getAll() {
        List<BidDto> all = null;
        all = (List<BidDto>) getSession().createSQLQuery("SELECT b.F_ID as bidId, b.F_DESIRED_RUNTIME as desiredRuntime, " +
                "b.F_KIND_OF_WORKS as kindOfWorks, b.F_SCOPE as scope, b.F_CREATION_DATE as creationDate" +
                "b.F_STATUS as status, br.F_TITLE as brigadeTitle, b.F_USER_ID as userId from T_BID b JOIN T_BRIGADE br ON b.F_ID=br.F_ID")
                .addScalar("bidId", StandardBasicTypes.LONG)
                .addScalar("desiredRuntime", StandardBasicTypes.STRING)
                .addScalar("kindOfWorks", StandardBasicTypes.STRING)
                .addScalar("scope", StandardBasicTypes.STRING)
                .addScalar("creationDate", StandardBasicTypes.DATE)
                .addScalar("status", StandardBasicTypes.STRING)
                .addScalar("brigadeTitle", StandardBasicTypes.STRING)
                .addScalar("userId", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(BidDto.class)).list();
        return all;
    }
}
