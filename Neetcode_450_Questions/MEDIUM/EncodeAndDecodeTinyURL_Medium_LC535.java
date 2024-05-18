package Neetcode_450_Questions.MEDIUM;

/*

https://leetcode.com/problems/encode-and-decode-tinyurl/description/

*/
import java.util.*;

public class EncodeAndDecodeTinyURL_Medium_LC535 {
    public class Codec {

        String baseUrl;

        Map<String, String> encodeMap;
        Map<String, String> decodeMap;

        public Codec() {
            this.encodeMap = new HashMap<>();
            this.decodeMap = new HashMap<>();
            this.baseUrl = "http://tinyurl.com/";
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String code = generateRandomString(10);

            String shortUrl = this.baseUrl + code;

            if (!this.encodeMap.containsKey(longUrl)) {
                this.encodeMap.put(longUrl, shortUrl);
                this.decodeMap.put(shortUrl, longUrl);
            }
            return this.encodeMap.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return this.decodeMap.get(shortUrl);
        }

        private String generateRandomString(int stringLength) {
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            int len = str.length();
            int min = 0;
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < stringLength; i++) {
                int index = (int) (Math.random() * (len - min)) + min;
                sb.append(str.charAt(index));
            }
            return sb.toString();
        }

    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
}
