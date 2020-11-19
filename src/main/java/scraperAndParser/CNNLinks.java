package scraperAndParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CNNLinks {

    public static void main(String[] args) throws Exception {

		String url = "https://www.cnn.com/";   	
		Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();  		
		//extract all links
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			String line = link.attr("href");
			System.out.println(line);    	    
		}        
    }
}
