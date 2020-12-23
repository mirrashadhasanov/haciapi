package XML_TEST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class Test_HTTP_XML {
    public static void main(String[] args) {
        Test_HTTP_XML oobj_Test_HTTP_XML=new Test_HTTP_XML();
        oobj_Test_HTTP_XML.get_response();
    }
    public void get_response(){
        try {
            String url = "https://www.cbar.az/currencies/23.12.2025.xml";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            //System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(response.toString())));
            NodeList errNodes = doc.getElementsByTagName("ValType");

            if (errNodes.getLength() > 0 ) {
                Element err = (Element)errNodes.item(1);
                NodeList err2Nodes = err.getElementsByTagName("Valute");

                HashMap valMap = new HashMap();

                for (int i=0; i < err2Nodes.getLength(); i++){
                    Element err2 = (Element) err2Nodes.item(i);
                    String code = err2.getAttribute("Code");
                    String value = err2.getElementsByTagName("Value").item(0).getTextContent();

                    valMap.put(code, value);
                }

                System.out.println(valMap);




//                for json

//                JSONObject jsonObject=new JSONObject();
//                JSONObject object=new JSONObject();
//
//                for (int i=0; i < err2Nodes.getLength(); i++){
//                    Element err2 = (Element) err2Nodes.item(i);
//                    String code = err2.getAttribute("Code");
//                    String name = err2.getElementsByTagName("Name").item(0).getTextContent();
//                    String value = err2.getElementsByTagName("Value").item(0).getTextContent();
//
//                    object.put("name"+i, name);
//                    object.put("value"+i, value);
//
//                    jsonObject.put(code, object);
//
//                }
//                System.out.print(jsonObject);















            } else {
                // success
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}