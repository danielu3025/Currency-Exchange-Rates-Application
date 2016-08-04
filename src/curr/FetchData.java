package curr;
import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FetchData{
    public  void loadData () throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("data.txt", "UTF-8");

        InputStream is = null;
        HttpURLConnection con = null;
        try
        {
            URL url = new URL("http://www.boi.org.il/currency.xml");
            HttpURLConnection.setFollowRedirects(false);
            con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            is = con.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);
            doc.normalizeDocument();

            NodeList rootNodes = doc.getElementsByTagName("CURRENCIES");
            Node root = rootNodes.item(0);
            Element rootElement = (Element) root;
            NodeList dateList  = rootElement.getElementsByTagName("LAST_UPDATE");
            Node upDateNode = dateList.item(0);
            Element upDate = (Element) upDateNode;
            NodeList currenciesList  = rootElement.getElementsByTagName("CURRENCY");
            writer.println(currenciesList.getLength());
            writer.println(upDate.getTextContent());

            for(int i = 0 ; i<currenciesList.getLength();i++){
                Node aCurrency =  currenciesList.item(i);
                Element currencyElement = (Element) aCurrency;
                Node nameTag = currencyElement.getElementsByTagName("NAME").item(0);
                Element name = (Element) nameTag;
                Node unitTag = currencyElement.getElementsByTagName("UNIT").item(0);
                Element unit = (Element) unitTag;
                Node currencyCodeTag =currencyElement.getElementsByTagName("CURRENCYCODE").item(0);
                Element currencyCode = (Element) currencyCodeTag;
                Node countryTag = currencyElement.getElementsByTagName("COUNTRY").item(0);
                Element country = (Element) countryTag;
                Node rateTag = currencyElement.getElementsByTagName("RATE").item(0);
                Element rate = (Element) rateTag;
                Node changeTag = currencyElement.getElementsByTagName("CHANGE").item(0);
                Element change = (Element) changeTag;
                writer.println(name.getTextContent() + "," + unit.getTextContent() + "," + currencyCode.getTextContent() +
                        "," + country.getTextContent() + "," + rate.getTextContent() + "," + change.getTextContent());
            }
        }
        catch(IOException e)
        {
            Model.log.error("Cannot fetch data! Returns NULL");
            e.printStackTrace();
        }
        catch(ParserConfigurationException e)
        {
            Model.log.error("Cannot parse XML file!");
            e.printStackTrace();
        }
        catch(SAXException e)
        {
            Model.log.error("Cannot parse XML file!");
            e.printStackTrace();
        }
        finally
        {
            if(is!=null)
            {
                try
                {
                    is.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(con!=null)
            {
                con.disconnect();
            }
            writer.close();
        }
    }


}