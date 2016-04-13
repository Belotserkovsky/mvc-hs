package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Brigade;
import by.academy.it.belotserkovsky.poolConnection.DataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kostya on 06.04.2016.
 */
public class BrigadeDAO implements DAO <Brigade> {
    private static BrigadeDAO instance;
    private static Logger log = Logger.getLogger(BrigadeDAO.class);

    private final String COLUMN_NAME_ID = "b_id";
    private final String COLUMN_NAME_NAME = "name";

    private final String SQL_QUERY_CREATE_BRIGADE = "INSERT INTO brigades (name) VALUES (?)";
    private final String SQL_QUERY_DELETE_BRIGADE_BY_ID = "DELETE FROM brigades WHERE b_id = ?";
    private final String SQL_QUERY_READ_BRIGADE_BY_NAME = "SELECT FROM brigades WHERE name = ?";
    private final String SQL_QUERY_READALL_BRIGADES = "SELECT * FROM brigades";

    private BrigadeDAO() {
        super();
    }

    public static BrigadeDAO getInstance() {
        if (instance == null) {
            instance = new BrigadeDAO();
        }
        return instance;
    }

    public void create(Brigade brigade) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_CREATE_BRIGADE;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, brigade.getName());

            ps.executeUpdate();
            log.info("Create: " + brigade);

        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("IOException: " + e);
        } finally {
            ps.close();
            connection.close();
        }
    }

    public boolean isUpdate (Brigade brigade) throws SQLException{ return false;}

    public Brigade read(Object key) throws SQLException {

        Brigade newBrigade = null;
        String brigadeName = (String)key;

        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_READ_BRIGADE_BY_NAME;

        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, brigadeName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                newBrigade = new Brigade ();
                newBrigade.setId(rs.getInt(COLUMN_NAME_ID));
                newBrigade.setName(rs.getString(COLUMN_NAME_NAME));
                log.info("Read: " + key);
                return newBrigade;
            }
        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("IOException: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        return newBrigade;
    }

    public boolean isDelete(Object key) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_DELETE_BRIGADE_BY_ID;

        try{
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            Integer brigadeId = (Integer)key;

            ps.setInt(1, brigadeId.intValue());

            if(ps.executeUpdate() > 0){
                log.info("Delete: " + key);
                return true;
            }

        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        }finally {
            ps.close();
            connection.close();
        }
        return false;
    }

    public List<Brigade> readAll() throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        Brigade brigade = null;
        List<Brigade> allBrigades = new ArrayList<Brigade>();
        String query = SQL_QUERY_READALL_BRIGADES;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                brigade = new Brigade();
                brigade.setId(rs.getInt(COLUMN_NAME_ID));
                brigade.setName(rs.getString(COLUMN_NAME_NAME));
                allBrigades.add(brigade);
            }
        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        log.info("Read all: " + allBrigades);
        return allBrigades;
    }

}
