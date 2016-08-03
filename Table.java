/**
 * Created by shahar on 03/08/16.
 */

import javax.swing.*;
import java.awt.*;

public class Table extends JTable {
    Currency []currencies;
    JTable jt;
    int size;
    Table(Currency[] currencies, int size){

        String []columns = {"Name", "Unit", "Code", "Country", "Rate", "Change"};
        String[][] data = new String[size][6];
        for(int i=0; i<size; i++){
            data[i][0] = currencies[i].getName();
            data[i][1] = Double.toString(currencies[i].getUnit());
            data[i][2] = currencies[i].getCode();
            data[i][3] = currencies[i].getCountry();
            data[i][4] = Double.toString(currencies[i].getRate());
            data[i][5] = Double.toString(currencies[i].getChange());
        }

        jt = new JTable(data,columns);
        jt.setPreferredScrollableViewportSize(new Dimension(450,65));
        jt.setFillsViewportHeight(true);
        JScrollPane jp = new JScrollPane(jt);
        add(jp);

    }
}
