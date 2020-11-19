package scraperAndParser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.HttpURLConnection;
import org.apache.commons.io.FilenameUtils;
import javax.imageio.ImageIO;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IstockImages {
	public static void main(String[] args) throws Exception {

		String url = "https://www.istockphoto.com/stock-illustrations";
		String filepath = "images\\";
		
		Document document = Jsoup.connect(url).userAgent("Mozilla/5.0").get();	      
		Elements tag = document.getElementsByTag("img");
		
		int count =0;
		for (Element link : tag) {
			if (count == 10)
				break;
		 	String imgurl = link.attr("abs:src");
		 	if (imgurl.length() > 0 ) {
		 		try {
			     	System.out.println(imgurl);
			     	String fn = FilenameUtils.getBaseName(imgurl)+"."+FilenameUtils.getExtension(imgurl);	         	
			     	System.out.println(fn);   	
			     	HttpURLConnection con = (HttpURLConnection) new URL(imgurl).openConnection();
			   	    con.addRequestProperty("User-Agent", "Mozilla/5.0");
			   	    BufferedImage c = ImageIO.read(con.getInputStream());
			   	    Thread.sleep(3000);
			  	    File outputFile = new File(filepath+fn);
			  	    ImageIO.write(c, "jpg", outputFile);
		 		} catch (Exception e) {
		 			continue;
		 		}
		 	}
		 	count ++;
		}         
    }
}
