import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class table_read {
    public static void main(String arg[])throws IOException
    {
        ArrayList<String> downServers = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.w3schools.com/html/html_tables.asp").get();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        Iterator<Element> iterator = table.select("td").iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().text()); //kolom -1
            System.out.println(iterator.next().text()); //kolom -2
        }

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
          System.out.println(cols);


        }
    }
}
