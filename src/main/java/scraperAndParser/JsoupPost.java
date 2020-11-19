package scraperAndParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;

public class JsoupPost {
	 public static void main(String[] args) throws IOException, InterruptedException {
		 
		 String url = "https://httpbin.org/post";			
		 Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(5000)
					 .data("custname", "google")	
					 .data("custtel", "234")
					 .userAgent("Mozilla/5.0")
					 .post();
		 //print html page
		 String	str = doc.html();
		 System.out.println(str);
	 }
}
