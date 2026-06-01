package com.thutrang.automation.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {
	public static int getResponseCode(String urlString) {
		try {
			URL url = new URL(urlString);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			connection.disconnect();
			return responseCode;
		} catch (Exception e) {
			return 500;
		}
	}
	
	public static boolean isBrokenLink(String url) {
		return getResponseCode(url) >= 400;
	}

}
