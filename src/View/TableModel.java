package View;
import Model.EntityAppartment;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


    public class TableModel extends AbstractTableModel {

        private final String[] Titres = { "idAppartment", "Description", "Address",
                "statue" };
        private final List<EntityAppartment> appart = new ArrayList();

        @Override
        public int getColumnCount() {
            return Titres.length;
        }

        @Override
        public int getRowCount() {
            return appart.size();
        }

        @Override
        public String getColumnName(int column) {
            return Titres[column];
        }

        @Override
        public Object getValueAt(int row, int column) {
            switch (column) {
                case 0:
                    return appart.get(row).getIdAppartment();
                case 1:
                    return appart.get(row).getDescription();
                case 2:
                    return appart.get(row).getAdress();
                case 3:
                    return appart.get(row).getState();
                default:
                    return "";
            }
        }
    }

