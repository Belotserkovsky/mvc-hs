package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IBrigadeDao;
import by.academy.it.belotserkovsky.pojos.Brigade;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Class inherits the properties of BaseDao
 * Created by K.Belotserkovsky
 */

@Repository
public class BrigadeDao extends BaseDao<Brigade> implements IBrigadeDao{

    @Autowired
    public BrigadeDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

}
