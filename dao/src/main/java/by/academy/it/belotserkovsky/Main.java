package by.academy.it.belotserkovsky;

import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;

import java.util.Locale;

/**
 * Created by Kostya on 22.04.2016.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);
    public static HibernateUtil util = null;

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        util = HibernateUtil.getHibernateUtil();
    }
}
