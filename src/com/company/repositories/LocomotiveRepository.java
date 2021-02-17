package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Locomotive;
import com.company.entities.Train;
import com.company.repositories.interfaces.ILocomotiveRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocomotiveRepository implements ILocomotiveRepository {

    private final IDB db;
    public LocomotiveRepository(IDB db){
        this.db = db;
    }

    @Override
    public boolean createLocomotive(Locomotive locomotive) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO locomotive(name,train_id) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, locomotive.getName());
            st.setInt(2, locomotive.getTrain_id());


            boolean executed = st.execute();
            return executed;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Locomotive getLocomotive(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,train_id FROM locomotive WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Locomotive locomotive = new Locomotive (rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("number"));


                return locomotive;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Locomotive> getAllLocomotives() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,train_id FROM locomotive";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Locomotive> locomotives = new ArrayList<>();
            while (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("train_id"));


                locomotives.add(locomotive);
            }

            return locomotives;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }



}

