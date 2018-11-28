package net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://www.baidu.com");
		URLConnection connection=url.openConnection();
		connection.connect();
		Map<String,List<String>> headers=connection.getHeaderFields();
		for(Map.Entry<String, List<String>> entry: headers.entrySet()) {
			String key =entry.getKey();
			for(String value:entry.getValue()) {
				System.out.println(key+": "+value);
			}
		}
		System.out.println("=====================");
		Scanner inScanner=new Scanner(connection.getInputStream(),"UTF-8");
		for(int n =1;inScanner.hasNextLine();n++) {
			System.out.println(inScanner.nextLine());
		}
	}

}
