package scraperAndParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class HttpURLConnectionPost {
	
	public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://httpbin.org/post";
        String POST_PARAMS = "custname=google&custtel=234";  
    	URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		
		//print response code
		int responseCode = con.getResponseCode();
		System.out.println("Response Code: " + responseCode);

		//print response body
		if (responseCode == HttpURLConnection.HTTP_OK) { 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("Response body: "+ response.toString());
		} else {
			System.out.println("error POST request");
		}
    }
}
