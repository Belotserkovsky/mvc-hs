package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Worker;
import by.academy.it.belotserkovsky.managers.SQLManager;
import by.academy.it.belotserkovsky.poolConnection.DataSource;

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

    private final String COLUMN_NAME_ID = "w_id";
    private final String COLUMN_NAME_FULLNAME = "fullName";
    private final String COLUMN_NAME_PROFESSION = "profession";
    private final String COLUMN_NAME_BRIGADE_ID = "brigades_b_id";

    private final String SQL_QUERY_CREATE_WORKER = "INSERT INTO workers (fullName,profession) VALUES (?,?)";
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

            if (ps.executeUpdate() > 0){}

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            { ps.close(); }
            connection.close();
        }
    }

    public Worker read(Object key) throws SQLException { return null; }

    public void update(Worker worker) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_UPDATE_WORKER;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, worker.getBrigadeId());
            ps.setInt(2, worker.getId());

            ps.executeUpdate();

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ps.close();
            connection.close();
        }
    }

    public void delete(Object workerId) throws SQLException{

        Integer id = (Integer) workerId;
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_DELETE_WORKER_BY_ID;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, id.intValue());

            ps.executeUpdate();

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           ps.close();
           connection.close();
        }
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
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            ps.close();
            connection.close();
        }
        return allWorkers;
    }
}
