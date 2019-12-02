package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Model.EntityKitchen;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KItchenDAO extends DAO<EntityKitchen> implements IKitchenDAO {
    @Override
    public EntityKitchen insert(EntityKitchen obj) {
        return null;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityKitchen obj) {
        return false;
    }

    @Override
    public <L> EntityKitchen getByPrimaryKey(L id) {
        return null;
    }


    private void AppartmentViewByNumberOfKitchen(int nbKitchen, String appartmentView) throws SQLException {
        String sql = "CREATE OR REPLACE VIEW ? " +
                "AS SELECT * " +
                "FROM ? " +
                "GROUP BY kitchen.idKitchen" +
                "HAVING COUNT(*) = ?;";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, appartmentView);
        pst.setString(2, appartmentView);
        pst.setInt(3, nbKitchen);
        pst.execute();
    }
    private void AppartmentViewByNumberOfGasPoint(int nbGasPointByKitchen, String appartmentView) throws SQLException {
        String sql = "CREATE OR REPLACE VIEW ? " +
                "AS SELECT * " +
                "FROM ? " +
                "WHERE kitchen.nbGasPoint = ?;";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, appartmentView);
        pst.setString(2, appartmentView);
        pst.setInt(3, nbGasPointByKitchen);
        pst.execute();
    }

    @Override
    public void AppartmentViewByCaracteristics(int nbKitchen, int nbGasPointByKitchen, String appartmentView) throws SQLException {
        if (nbKitchen > (-1))
            AppartmentViewByNumberOfKitchen(nbKitchen,appartmentView);
        if (nbGasPointByKitchen > (-1))
            AppartmentViewByNumberOfGasPoint(nbGasPointByKitchen,appartmentView);
    }
}
