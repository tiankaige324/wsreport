package com.wsxd.main.utils;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Administrator
 *
 */
public class Md5ToolUtil {

		
		

    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public Md5ToolUtil() {
    	
    }


    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }


    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getMd5Code(String strObj) {
    	 String resultString = "";
         try {
             if(strObj == null){
             	
             	return resultString;
             }
             MessageDigest md = MessageDigest.getInstance("MD5");
 
             resultString = byteToString(md.digest(strObj.getBytes()));
         } catch (NoSuchAlgorithmException ex) {
             ex.printStackTrace();
         }
         return resultString;
    }
    
 
    public static  String transformMD5(String inputStr) {  
  
        MessageDigest md5=null;  
        try {  
            md5 = MessageDigest.getInstance("MD5");  
        } catch (Exception e) {  
            System.out.println(e.toString());  
            return null;  
        }  
        char[] charArray = inputStr.toCharArray();
        byte[] byteArray = new byte[charArray.length]; 
  
        for (int i = 0; i < charArray.length; i++){  
            byteArray[i] = (byte) charArray[i];  
        }  
  
 
         byte[] md5Bytes = md5.digest(byteArray);  
          
        StringBuffer md5Str= new StringBuffer();  
  
        for (int i = 0; i < md5Bytes.length; i++){  
            if (Integer.toHexString(0xFF & md5Bytes[i]).length() == 1)    
                md5Str.append("0").append(Integer.toHexString(0xFF & md5Bytes[i]));    
            else    
                md5Str.append(Integer.toHexString(0xFF & md5Bytes[i]));    
        }  
  
        return md5Str.toString();  
    }  
    
    
    public static void main(String[] args) {
    	
	}
}

