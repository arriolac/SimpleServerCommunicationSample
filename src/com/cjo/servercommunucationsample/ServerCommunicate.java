package com.cjo.servercommunucationsample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ServerCommunicate {
	
	private static final String SERVER_URL = "http://django.chrisarriola.me/droppintunes/get_music";
	
public static String getSongList()
{		String data = URLEncoder.encode("POST");
		return executeHttpRequest(data);
	}
	
	public static String getTest()
	{
		String data =  URLEncoder.encode("POST");
	//	String data =  "command=" + URLEncoder.encode("getAnimalSound") + "&animal=" + URLEncoder.encode("bird");
		return executeHttpRequest(data);
	}
	
public static String executeHttpRequest(String data)
{
	String result = "";
	try
	{
		URL url = new URL(SERVER_URL);
		URLConnection connection = url.openConnection();
		
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
		//Send the POST data
		DataOutputStream dataOut = new DataOutputStream(connection.getOutputStream());
		dataOut.writeBytes(data);
		dataOut.flush();
		dataOut.close();
		
		DataInputStream dataIn = new DataInputStream(connection.getInputStream());
		String inputLine;
		while ((inputLine = dataIn.readLine()) != null)
		{
			result += inputLine;
		}
		dataIn.close();
	} catch (IOException e)
	{
		e.printStackTrace();
		result = null;
	}
	return result;
}
}
