package curr;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame {

    Currency []currencies;
    JTable jt;
    int size;

    Table(Currency[] currencies, int size) {

        String[] columns = {"Name", "Unit", "Code", "Country", "Rate", "Change"};
        String[][] data = new String[size][6];
        for (int i = 0; i < size; i++) {
            data[i][0] = currencies[i].getName();
            data[i][1] = Double.toString(currencies[i].getUnit());
            data[i][2] = currencies[i].getCode();
            data[i][3] = currencies[i].getCountry();
            data[i][4] = Double.toString(currencies[i].getRate());
            data[i][5] = Double.toString(currencies[i].getChange());
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
        jt = new JTable(tableModel);
        jt.setPreferredScrollableViewportSize(new Dimension(450, 65));
        jt.setFillsViewportHeight(true);
        JScrollPane jp = new JScrollPane(jt);
        add(jp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setTitle("Currency Exchange Rates- Table");
        DefaultTableModel  model = new DefaultTableModel(data, columns)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;//This causes all cells to be not editable
            }
        };

    }



}