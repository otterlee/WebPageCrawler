package edu.handong.csee.java.bonushw;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;

public class URLReader {
	String url="";
	String allLines="";
	
	URLReader(String inputURLFromCLI){
		this.url = inputURLFromCLI;
	}
	public void read() throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
        
        try {
             URL url = new URL("http://www.naver.com");
             
            // URLConnection 생성
            URLConnection urlConnection = url.openConnection();
             
            InputStream inputStreamUrl = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamUrl, "UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
             
            String line ;
            while((line = br.readLine()) != null){      
                stringBuffer.append(line + "\r\n") ;    
            }
             
            System.out.println(stringBuffer.toString()) ;
            allLines = stringBuffer.toString(); 
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
