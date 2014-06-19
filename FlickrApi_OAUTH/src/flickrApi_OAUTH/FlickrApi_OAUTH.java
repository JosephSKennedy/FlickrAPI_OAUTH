package flickrApi_OAUTH;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;

import org.apache.commons.codec.binary.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SignatureException;
import java.security.Security;
import java.util.Formatter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.*;

import java.util.Date;

public class FlickrApi_OAUTH {
		
	public static void main(String[] args) 
	{
	// Just a comment for git push 001
	// Step One Singing Requests ....Pass the string for the full URL and the Key and get back a signature  	
		  Provider[] Providers;
		  Providers = Security.getProviders();
		
		Date date = new Date();
	      long oauth_timestamp = date.getTime(); 
  	
		String realm = "https://www.flickr.com/services/oauth/request_token" +
			"?oauth_nonce=89601180" +
			"&oauth_timestamp=" + oauth_timestamp +
			"&oauth_consumer_key=6c941c062d06341aa7b8c14abd609d55" +
			"&oauth_signature_method=HMAC-SHA1" +
			"&oauth_version=1.0" +
			"&oauth_callback=oob";
		
		
		try {
			String signature = sha1(realm,"bc3db49fcd36d375");
			System.out.println(signature);
		} catch (InvalidKeyException e) {
			System.out.println("There is an invalid Key Exception"); 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("There is an Unsupported Encoding Exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("There is no such Algorithm");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	     oauth_timestamp = date.getTime(); 
    	 
	    
	      
	      
	      
	     // Step two Getting a Request Token
	      
				 realm = "https://www.flickr.com/services/oauth/request_token";
	             String oauth_nonce="95613465";
	     //        String	auth_timestamp="1305586162";
	             String oauth_consumer_key="6c941c062d06341aa7b8c14abd609d55";
	             String oauth_signature_method="HMAC-SHA1";
	             String oauth_version="1.0";
	             String oauth_signature="7w18YS2bONDPL%2FzgyzP5XTr5af4%3D";
	    //       String oauth_callback="http%3A%2F%2Fwww.example.com";
	             String oauth_callback="oob";
	             oauth_timestamp = date.getTime();
	                	realm="https://www.flickr.com/services/oauth/request_token" + 
	             			"&oauth_nonce=4572616e48616d6d65724c61686176" +
	             			"&oauth_timestamp=" + oauth_timestamp +
	               			"&oauth_consumer_key=6c941c062d06341aa7b8c14abd609d55" +
		                    "&oauth_signature_method=HMAC-SHA1" +
		   	                "&oauth_version=1.0" +
		                    "&oauth_signature=oauth_signature" +
		                    "&oauth_callback=http%3A%2F%2Fwww.example.com";
	}




private static String sha1(String s, String oauth_consumer_key) throws 
UnsupportedEncodingException, NoSuchAlgorithmException, 
InvalidKeyException {

 // SecretKeySpec key = new SecretKeySpec((oauth_consumer_key).getBytes("UTF-8"), "HmacSHA1");
  SecretKeySpec key = new SecretKeySpec(("1234").getBytes(), "HMACSHA1");

  Mac mac = Mac.getInstance("HmacSHA1");
  // Mac mac = Mac.getInstance("HmacMD5");
  mac.init(key);

  byte[] bytes = mac.doFinal(s.getBytes("UTF-8"));

  return new String(Base64.encodeBase64(bytes) );
}
}