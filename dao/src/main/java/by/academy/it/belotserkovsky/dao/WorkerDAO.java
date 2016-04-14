package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Worker;
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
 * implementation interface dao for worker
 * Created by Kostya on 06.04.2016.
 */
public class WorkerDAO implements DAO<Worker> {
    private static WorkerDAO instance;
    private static Logger log = Logger.getLogger(WorkerDAO.class);


    private final String COLUMN_NAME_ID = "w_id";
    private final String COLUMN_NAME_FULLNAME = "fullName";
    private final String COLUMN_NAME_PROFESSION = "profession";
    private final String COLUMN_NAME_BRIGADE_ID = "brigades_b_id";

    private final String SQL_QUERY_CREATE_WORKER = "INSERT INTO workers (fullName,profession, brigades_b_id) VALUES (?,?,?)";
    private final String SQL_QUERY_DELETE_WORKER_BY_ID = "DELETE FROM workers WHERE w_id = ?";
    private final String SQL_QUERY_UPDATE_WORKER = "UPDATE workers SET brigades_b_id = ? WHERE w_id = ?";
    private final String SQL_QUERY_READALL_WORKERS = "SELECT * FROM workers";

    private WorkerDAO() {
        super();
    }

    public static WorkerDAO getInstance() {
        if (instance == null) {
            instance = new WorkerDAO();
        }
        return instance;
    }

    public void create(Worker worker) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_CREATE_WORKER;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, worker.getFullName());
            ps.setString(2, worker.getProfession());
            ps.setInt(3, worker.getBrigadeId());

            ps.executeUpdate();
            log.info("Create: " + worker);

        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
    }

    public Worker read(Object key) throws SQLException { return null; }

    public boolean isUpdate(Worker worker) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_UPDATE_WORKER;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, worker.getBrigadeId());
            ps.setInt(2, worker.getId());

           if(ps.executeUpdate() > 0){
               log.info("Update: " + worker);
               return true;
           }
        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        return false;
    }

    public boolean isDelete(Object workerId) throws SQLException{

        Integer id = (Integer) workerId;
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_DELETE_WORKER_BY_ID;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, id.intValue());

            if (ps.executeUpdate() > 0){
                log.info("Delete: " + workerId);
                return true;
            }

        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("c3p0 exception: " + e);
        } finally {
           ps.close();
           connection.close();
        }
        return false;
    }

    public List<Worker> readAll() throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        Worker worker = null;
        List<Worker> allWorkers = new ArrayList<Worker>();
        String query = SQL_QUERY_READALL_WORKERS;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                worker = new Worker();
                worker.setId(rs.getInt(COLUMN_NAME_ID));
                worker.setFullName(rs.getString(COLUMN_NAME_FULLNAME));
                worker.setProfession(rs.getString(COLUMN_NAME_PROFESSION));
                worker.setBrigadeId(rs.getInt(COLUMN_NAME_BRIGADE_ID));
                allWorkers.add(worker);
            }
        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        log.info("Readed all workers: " + allWorkers);
        return allWorkers;
    }
}
