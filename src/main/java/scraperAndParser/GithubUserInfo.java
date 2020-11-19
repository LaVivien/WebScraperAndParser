package scraperAndParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

public class GithubUserInfo {
	
	public static void main(String[] args) throws Exception {		
		
		String url = "https://api.github.com/users/google";
		Gson gson = new Gson();
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();		
		if (status == 200) {		
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			GithubUser user = gson.fromJson(in, GithubUser.class);
			System.out.println("User login: " + user.getLogin());
			System.out.println("User id: " + user.getId());
			in.close();	
		} else {
			System.out.println("error GET info");
		}
	}
}
