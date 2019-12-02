package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Model.EntityBedroom;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BedroomDAO extends DAO<EntityBedroom> implements IBedroomDAO {
    @Override
    public EntityBedroom insert(EntityBedroom obj) {
        return null;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityBedroom obj) {
        return false;
    }

    @Override
    public <L> EntityBedroom getByPrimaryKey(L id) {
        return null;
    }

    private void AppartmentViewByNumberOfBedroom(int nbBedroom, String appartmentView) throws SQLException {
        String sql = "CREATE OR REPLACE VIEW ? " +
                "AS SELECT * " +
                "FROM ? " +
                "GROUP BY bedroom.idBedroom" +
                "HAVING COUNT(*) = ?;";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, appartmentView);
        pst.setString(2, appartmentView);
        pst.setInt(3, nbBedroom);
        pst.execute();
    }
    private void AppartmentViewByTypeOfBedroom(String bedroomType, String appartmentView) throws SQLException {
        String sql = "CREATE OR REPLACE VIEW ? " +
                "AS SELECT * " +
                "FROM ? " +
                "WHERE bedroom.bedroomType = ?;";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, appartmentView);
        pst.setString(2, appartmentView);
        pst.setString(3, bedroomType);
        pst.execute();
    }

    @Override
    public void AppartmentViewByCaracteristics(int nbBedroom, String bedroomType, String appartmentView) throws SQLException {
        if (nbBedroom > (-1))
            AppartmentViewByNumberOfBedroom(nbBedroom,appartmentView);
        if (bedroomType != null)
            AppartmentViewByTypeOfBedroom(bedroomType,appartmentView);

    }
}
