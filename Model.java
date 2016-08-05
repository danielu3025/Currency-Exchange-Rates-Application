package curr;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Model {

    //public static Logger log = LogManager.getLogger(Model.class.getName());

    public static void main(String[] args) throws IOException {


        Currency[] currencys = null;
        String lastDateUpDate = "" ;

        FetchData fd  = new FetchData();
        try {
            fd.loadData();
        } catch (FileNotFoundException e) {
           // log.error("File not found!");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
           // log.error("Encode is unknown!");
            e.printStackTrace();
        }

        fileReader fr = new fileReader();
        fr.LoadFile();

        currencys = fr.GetCurrencies();
        lastDateUpDate = fr.GetUPToDate();

        View ui = new View(currencys,lastDateUpDate);

    }
}
