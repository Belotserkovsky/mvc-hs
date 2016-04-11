package by.academy.it.belotserkovsky.managers;

import java.util.ResourceBundle;

/**
 *manager for database access
 * Created by Kostya on 03.04.2016.
 */
public class SQLManager {

    private static SQLManager instance;
    private static ResourceBundle bundle;

    public static final String BUNDLE_NAME = "sql";

    //#USER dao
    public static final String SQL_QUERY_CREATE_USER = "SQL_QUERY_CREATE_USER";
    public static final String SQL_QUERY_READ_USER_BY_ID = "SQL_QUERY_READ_USER_BY_ID";
    public static final String SQL_QUERY_READ_USER_BY_LOGIN = "SQL_QUERY_READ_USER_BY_LOGIN";
    public static final String SQL_QUERY_READALL_USERS = "SQL_QUERY_READALL_USERS";
    public static final String SQL_QUERY_DELETE_USER_BY_LOGIN = "SQL_QUERY_DELETE_USER_BY_LOGIN";

    //#BID dao
    public static final String SQL_QUERY_CREATE_BID = "SQL_QUERY_CREATE_BID";
    public static final String SQL_QUERY_READALL_BIDS = "SQL_QUERY_READALL_BIDS";
    public static final String SQL_QUERY_READ_BID_BY_LOGIN = "SQL_QUERY_READ_BID_BY_LOGIN";

    //#WORKER dao
    public static final String SQL_QUERY_CREATE_WORKER = "SQL_QUERY_CREATE_WORKER";
    public static final String SQL_QUERY_DELETE_WORKER_BY_PROFESSION = "SQL_QUERY_DELETE_WORKER_BY_PROFESSION";
    public static final String SQL_QUERY_UPDATE_WORKER = "SQL_QUERY_UPDATE_WORKER";
    public static final String SQL_QUERY_READALL_WORKERS = "SQL_QUERY_READALL_WORKERS";

    //#BRIGADE DAO
    public static final String SQL_QUERY_CREATE_BRIGADE = "SQL_QUERY_CREATE_BRIGADE";
    public static final String SQL_QUERY_READALL_BRIGADES = "SQL_QUERY_READALL_BRIGADES";
    public static final String SQL_QUERY_DELETE_BRIGADE_BY_ID = "SQL_QUERY_DELETE_BRIGADE_BY_ID";


    public static SQLManager getInstance() {
        if(instance == null) {
            instance = new SQLManager();
            bundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public static String getProperty(String key) {
        return bundle.getString(key);
    }
}
