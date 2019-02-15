import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NumberThree {

	//public void 
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		
		String sURL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
		try {
			//sURL += "Spiderman";
			sURL += scan.nextLine();
			URL url = new URL(sURL);

			URLConnection uc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

			JSONParser parser = new JSONParser();

			String input;

			StringBuilder sb = new StringBuilder();
			while ((input = in.readLine()) != null) {
				sb.append(input);
			}
			JSONObject obj = (JSONObject) parser.parse(sb.toString());

			int totalPages = Integer.parseInt(obj.get("total_pages").toString());
			// System.out.println(totalPages);
			
			//System.out.println(sb.toString());

			for (int i = 1; i <= totalPages; i++) {

				url = new URL(sURL + "&page=" + i);
				uc = url.openConnection();
				in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

				obj = (JSONObject) parser.parse(in.readLine());
				System.out.println(obj);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
