import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View extends JFrame  {
    Currency[] currenciesObjList;

    public View(Currency[] currencies , String date) {
        Calculator calc = new Calculator(currencies,date);
        Table table = new Table(currencies,currencies.length);
        table.setVisible(true);
        calc.setVisible(true);

    }

}
