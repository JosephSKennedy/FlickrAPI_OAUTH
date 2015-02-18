<<<<<<< HEAD
/*Step 1: Generate signature

Step 2: Token Request

Step 3: User Authorization

Step 4: Request Token Exchanged for Access Token*/

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

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.*;

import java.util.Date;

public class FlickrApi_OAUTH {
	
	

	private static String requestTokenStr;
	private static String oauth_verifier;
	private static String accessTokenStr;
	
	
	
	private static String sha1(String s, String oauth_secret_key) throws 
	  UnsupportedEncodingException, NoSuchAlgorithmException, 
	  InvalidKeyException {
	
		SecretKeySpec key = new SecretKeySpec((oauth_secret_key).getBytes("UTF-8"), "HmacSHA1");
		
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(key);
		
		byte[] bytes = mac.doFinal(s.getBytes("UTF-8"));
		
		return new String(Base64.encodeBase64(bytes) );
	}
	
	private static void requestToken(String url)
	{
		
		
		requestTokenStr = "";
		return;
	}
	
	private static final void tokenRequest(){
		//Step One: Singing Requests
		//Get timestamp
		Date date = new Date();
	    long oauth_timestamp = date.getTime(); 
  	
		//Generate OAUTH Signature
		String realm = "https://www.flickr.com/services/oauth/request_token" +
			"?oauth_nonce=89601180" +
			"&oauth_timestamp=" + oauth_timestamp +
			"&oauth_consumer_key=" + CONSUMER_KEY +
			"&oauth_signature_method=HMAC-SHA1" +
			"&oauth_version=1.0" +
			"&oauth_callback=oob";
		
		String oauth_signature;
		try {
			oauth_signature = sha1(realm,"bc3db49fcd36d375");
			System.out.println(oauth_signature);
			
			oauth_timestamp = date.getTime(); 
    	
			realm = "https://www.flickr.com/services/oauth/request_token" +
				"?oauth_nonce=89601180" +
				"&oauth_timestamp=" + oauth_timestamp +
				"&oauth_consumer_key=" + CONSUMER_KEY +
				"&oauth_signature_method=HMAC-SHA1" +
				"&oauth_signature=" + oauth_signature +
				"&oauth_version=1.0" +
				"&oauth_callback=oob";
			
			requestToken(realm);
			
		} catch (InvalidKeyException e) {
			System.out.println("There is an invalid Key Exception"); 
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("There is an Unsupported Encoding Exception");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("There is no such Algorithm");
			e.printStackTrace();
		}
		
		/*
	     // Step two Getting a Request Token  
		 realm = "https://www.flickr.com/services/oauth/request_token";
         String oauth_nonce="95613465";
         String oauth_consumer_key="6c941c062d06341aa7b8c14abd609d55";
         String oauth_signature_method="HMAC-SHA1";
         String oauth_version="1.0";
         String oauth_signature="7w18YS2bONDPL%2FzgyzP5XTr5af4%3D";
//       String oauth_callback="http%3A%2F%2Fwww.example.com";
         String oauth_callback="oob";
         */
		 
		/*
         oauth_timestamp = date.getTime();
    	realm="https://www.flickr.com/services/oauth/request_token" + 
		"&oauth_nonce=4572616e48616d6d65724c61686176" +
		"&oauth_timestamp=" + oauth_timestamp +
		"&oauth_consumer_key=6c941c062d06341aa7b8c14abd609d55" +
        "&oauth_signature_method=HMAC-SHA1" +
        "&oauth_version=1.0" +
        "&oauth_signature=" + oauth_signature +
        "&oauth_callback=oob";
		*/
	}
	
	private static final void accessRequest(){
	
		
	}
	
	
	public static void main(String[] args) 
	{
		String oauth_nonce, oauth_timestamp, oauth_signature_method,
		  oauth_version = "1.0", ouath_signature, oauth_callback;
		
		tokenRequest();
		accessRequest();
		
	}


>>>>>>> refs/remotes/origin/master
}
