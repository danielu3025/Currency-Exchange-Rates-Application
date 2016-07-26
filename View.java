import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View extends JFrame  {
    Currency[] currenciesObjList;
    String lastDateUpDate ;
    String [] currNames ;
    Double[] currRaets;
    int[] currunit;
    JPanel panel=new JPanel();
    JComboBox cmbCurrListFrom ;
    JComboBox cmbCurrListTo ;
    JLabel lblFrom = new JLabel();
    JLabel lblTo = new JLabel();
    JLabel lblResult = new JLabel();
    JButton btCalc = new JButton("Calc");
    JTextField txtInput = new JTextField("",20);
    int fIndex = 0, tIndex = 0;

    public View(Currency[] currencies , String date) {
        currenciesObjList = currencies;
        lastDateUpDate = date;
        currNames = getNames();
        currRaets =getCurrRaets();
        currunit = getCurrunit();
        cmbCurrListFrom = new JComboBox(currNames);
        cmbCurrListTo = new JComboBox(currNames);

        setLayout(null);
        setSize(700,400);
        setResizable(false);
        setTitle("Currency Exchange Rates");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cmbCurrListFrom.setSelectedIndex(0);
        cmbCurrListTo.setSelectedIndex(0);

        lblFrom.setText("From: ");
        lblTo.setText("To: ");
        add(txtInput);
        add(lblFrom);
        add(cmbCurrListFrom);
        add(lblTo);
        add(cmbCurrListTo);
        add(btCalc);
        lblResult.setText("$$$RESULT$$$");
        add(lblResult);
        txtInput.setBounds(30,10,70,20);
        lblFrom.setBounds(30,35,100,20);
        cmbCurrListFrom.setBounds(70,35,250,30);
        lblTo.setBounds(360,35,100,20);
        cmbCurrListTo.setBounds(390,35,250,30);
        btCalc.setBounds(300,90,100,20);
        lblResult.setBounds(300,130,100,20);


        HendlerBTCalc  hendlerBTCalc = new HendlerBTCalc();
        HendlerCmbForm  hendlerCmbForm = new HendlerCmbForm();
        HendlerCmbTo  hendlerCmbTo = new HendlerCmbTo();


        btCalc.addActionListener(hendlerBTCalc);
        cmbCurrListFrom.addActionListener(hendlerCmbForm);
        cmbCurrListTo.addActionListener(hendlerCmbTo);

    }

    private class  HendlerBTCalc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Double res = Conversion(currRaets[fIndex],currRaets[tIndex],currunit[fIndex],currunit[tIndex]);
            String pr = String.valueOf(res);
            lblResult.setText(pr);
        }
    }
    private class  HendlerCmbForm implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cmbCurrListFrom){
                JComboBox cb = (JComboBox) e.getSource();
                fIndex = cb.getSelectedIndex();
            }
        }
    }
    private class  HendlerCmbTo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cmbCurrListTo){
                JComboBox cb = (JComboBox) e.getSource();
                tIndex = cb.getSelectedIndex();
            }
        }
    }


    public String[] getNames(){
        String [] res = new String[currenciesObjList.length];
        for (int i=0 ;i<currenciesObjList.length;i++){
            res[i] = currenciesObjList[i].code +" - " +  currenciesObjList[i].getName() + " (" + currenciesObjList[i].getCountry()+")" ;
        }
        return res;
    }
    public Double[] getCurrRaets(){
        Double [] res = new Double[currenciesObjList.length];
        for (int i=0 ;i<currenciesObjList.length;i++){
            res[i] = currenciesObjList[i].getRate();
        }
        return res;
    }
    public int[] getCurrunit(){
        int [] res = new int[currenciesObjList.length];
        for (int i=0 ;i<currenciesObjList.length;i++){
            res[i] = currenciesObjList[i].getUnit();
        }
        return res;
    }
    private Double Conversion(Double fRate,Double tRate,int fUnit,int tUnit){
        Double res = null;
        String input  = txtInput.getText();
        try {
            int inputNun = Integer.parseInt(input);
            res = (((fRate/fUnit)*inputNun)/tRate)*tUnit;
        }
        catch (NumberFormatException e){

            res = Double.valueOf(0);
        }
        return res;
    }

}
