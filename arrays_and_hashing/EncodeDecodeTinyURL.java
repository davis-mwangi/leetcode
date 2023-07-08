package arrays_and_hashing;
/*
https://leetcode.com/problems/encode-and-decode-tinyurl/description/
*/
import java.util.*;

public class EncodeDecodeTinyURL {
    private HashMap<String,String>encodeMap = new HashMap<>();
    private HashMap<String,String>decodeMap = new HashMap<>();
    private String baseURL;
   
    public EncodeDecodeTinyURL(){
        this.encodeMap = new HashMap<>();
        this.decodeMap = new HashMap<>();
        this.baseURL = "http://tinyurl.com/";
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        if(!encodeMap.containsKey(longUrl)){
            encodeMap.put(longUrl, baseURL + Integer.toString(encodeMap.size() + 1)  );
            decodeMap.put(baseURL + Integer.toString(decodeMap.size()+1), longUrl);
        }
        return encodeMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}
