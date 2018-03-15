import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Wikipedia_test {
    public static void main(String arg[])throws IOException
    {
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        System.out.println(doc.title());
        Elements newHeadlines= doc.select("#mp-itn b a");
        for (Element headline:newHeadlines)
        {
            System.out.println(headline.attr("title")+" "+headline.absUrl("href"));
        }
    }

}

