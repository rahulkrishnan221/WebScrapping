import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class table_read {
    public static void main(String arg[])throws IOException
    {
        Connection.Response res = Jsoup
            .connect("http://evarsity.srmuniv.ac.in/srmswi/usermanager/ParentLogin.jsp")
            .data("txtRegNumber","iamalsouser")
                .data("txtPwd","thanksandregards")
                .data("txtSN","PRA1611003040056")
                .data("txtPD","07061998")
                .data("txtPA","1")
            .method(Connection.Method.GET)
            .execute();

//This will get you cookies
        Map<String, String> cookies = res.cookies();

        ArrayList<String> downServers = new ArrayList<>();
       // Document doc1=Jsoup.connect("https://www.w3schools.com/tags/tag_table.asp").get();
     //   Document doc = Jsoup.connect("http://evarsity.srmuniv.ac.in/srmswi/resource/StudentDetailsResources.jsp?resourceid=7").cookies(cookies).get();

        Document doc=Jsoup.connect("http://evarsity.srmuniv.ac.in/srmswi/resource/StudentDetailsResources.jsp?resourceid=7").cookies(cookies).get();
       Element table = doc.select("table").get(0); //select the first table.
       // System.out.println(table);
       Elements rows = table.select("tr");

        Iterator<Element> iterator = rows.select("tr").iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().text()); //kolom -1

        }

      /*  for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
          System.out.println(cols);


        } */


    }
}
