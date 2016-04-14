package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Bid;
import by.academy.it.belotserkovsky.poolConnection.DataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *implementation interface dao for dao
 * Created by Kostya on 06.04.2016.
 */
public class BidDAO implements DAO<Bid> {
    private static BidDAO instance;
    private static Logger log = Logger.getLogger(BidDAO.class);

    private final String COLUMN_NAME_ID = "b_id";
    private final String COLUMN_NAME_KIND_OF_WORKS = "kindOfworks";
    private final String COLUMN_NAME_SCOPE = "scope";
    private final String COLUMN_NAME_DESIRED_RUNTIME = "desiredRuntime";
    private final String COLUMN_NAME_USER_ID = "users_u_id";
    private final String COLUMN_NAME_BRIGADE_ID = "brigades_b_id";

    private final String SQL_QUERY_CREATE_BID = "INSERT INTO bids (kindOfWorks, scope, desiredRuntime, users_u_id, brigades_b_id) VALUES (?,?,?,?,?)";
    private final String SQL_QUERY_READ_BID_BY_USER_ID = "SELECT * FROM bids WHERE users_u_id = ?";
    private final String SQL_QUERY_UPDATE_BID = "UPDATE bids SET kindOfworks = ?, scope = ?, desiredRuntime = ?, users_u_id = ?, brigades_b_id = ? WHERE b_id = ?";
    private final String SQL_QUERY_READALL_BIDS = "SELECT * FROM bids";
    private final String SQL_QUERY_DELETE_ALL = "DELETE FROM bids";

    private BidDAO() {
        super();
    }

    public static BidDAO getInstance() {
        if (instance == null) {
            instance = new BidDAO();
        }
        return instance;
    }

    public void create(Bid bid) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_CREATE_BID;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, bid.getKindOfWorks());
            ps.setString(2, bid.getScope());
            ps.setString(3, bid.getDesiredRuntime());
            ps.setInt(4, bid.getUserId());
            ps.setInt(5, bid.getBrigadeId());

            ps.executeUpdate();
            log.info("Create:" + bid);

        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
    }

    public Bid read(Object key) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        Bid bid = null;
        Integer userID = (Integer)key;
        String query = SQL_QUERY_READ_BID_BY_USER_ID;
        try{
            connection = DataSource.getInstance().getConnection();
            ps.setInt(1, userID.intValue());
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                bid = new Bid();
                bid.setId(rs.getInt(COLUMN_NAME_ID));
                bid.setKindOfWorks(rs.getString(COLUMN_NAME_KIND_OF_WORKS));
                bid.setScope(rs.getString(COLUMN_NAME_SCOPE));
                bid.setDesiredRuntime(rs.getString(COLUMN_NAME_DESIRED_RUNTIME));
                bid.setUserId(rs.getInt(COLUMN_NAME_USER_ID));
                bid.setBrigadeId(rs.getInt(COLUMN_NAME_BRIGADE_ID));

                log.info("Read user's bid:" + bid);
                return bid;
            }
        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        }finally {
            if(ps != null) {
                ps.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
        return bid;
    }

    public List<Bid> readAll() throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        Bid bid = null;
        List<Bid> allBids = new ArrayList<Bid>();
        String query = SQL_QUERY_READALL_BIDS;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                bid = new Bid();
                bid.setId(rs.getInt(COLUMN_NAME_ID));
                bid.setKindOfWorks(rs.getString(COLUMN_NAME_KIND_OF_WORKS));
                bid.setScope(rs.getString(COLUMN_NAME_SCOPE));
                bid.setDesiredRuntime(rs.getString(COLUMN_NAME_DESIRED_RUNTIME));
                bid.setUserId(rs.getInt(COLUMN_NAME_USER_ID));
                bid.setBrigadeId(rs.getInt(COLUMN_NAME_BRIGADE_ID));

                allBids.add(bid);
                log.info("Read user's bid and add to list:" + bid);
            }
        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        log.info("Read all bids:" + allBids);
        return allBids;
    }

    public boolean isUpdate(Bid bid) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_UPDATE_BID;

        try{
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, bid.getKindOfWorks());
            ps.setString(2, bid.getScope());
            ps.setString(3, bid.getDesiredRuntime());
            ps.setInt(4, bid.getUserId());
            ps.setInt(5, bid.getBrigadeId());
            ps.setInt(6, bid.getId());

            if(ps.executeUpdate() > 0){
                log.info("Update:" + bid);
                return true;
            }

        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        return false;
    }

    public boolean isDelete(Object key) throws SQLException{ return false; }
}
