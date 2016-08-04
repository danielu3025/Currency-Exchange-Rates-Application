package curr;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {
    int size = 0;
    String date = "";
    Currency[] currencies;
    String[] spiltString;
    public void LoadFile  () throws IOException {
        FileReader file = null;
        try {
            file  =  new FileReader("data.txt");

        }catch (FileNotFoundException e) {
            Model.log.error(e);
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(file);

        String txt = "";
        String line  = reader.readLine();
        size = Integer.parseInt(line);
        line = reader.readLine();
        date = line;
        currencies = new Currency[size];
        for(int i = 0 ; i<size; i++){
            line = reader.readLine();
            spiltString = line.split(",",-1);
            currencies[i] = new Currency(spiltString[0],spiltString[1],spiltString[2],spiltString[3],spiltString[4],spiltString[5]);
        }
    }
    public Currency[] GetCurrencies() {return currencies;}
    public String GetUPToDate(){
        return date;
    }
}