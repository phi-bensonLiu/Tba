package service;

import java.io.UnsupportedEncodingException;

@SuppressWarnings("serial")
public class EncodingTool extends Exception{
	public static String encodeStr(String str) {  
        try {  
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}
