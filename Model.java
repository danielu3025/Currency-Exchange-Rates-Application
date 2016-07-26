import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Model {
    public static void main(String[] args) throws IOException {
        Currency[] currencys = null;
        String lastDateUpDate = "" ;

        FetchData fd  = new FetchData();
        try {
            fd.loadData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        fileReader fr = new fileReader();
        fr.LoadFile();

        currencys = fr.GetCurrencies();
        lastDateUpDate = fr.GetUPToDate();

        View ui = new View(currencys,lastDateUpDate);
        ui.setVisible(true);
    }
}
