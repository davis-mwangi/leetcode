package binary_search;
import java.util.*;

/**
 * https://leetcode.com/problems/search-suggestions-system/description/
 * 
 * 
    searchWord = "mouse"
    ["mobile","mouse","moneypot","monitor","mousepad"]
    ["mobile","moneypot","monitor","mouse","mousepad"] => Sorted lexicographically


    Time Complexity: (n log n ) + O(w*n) + 3*n
    Space Complexity: O(1)
 */ 
public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        //Sort Array
        Arrays.sort(products);

        int left = 0;
        int right = products.length - 1 ;

        List<List<String>>result = new ArrayList<>();
        for(int  i = 0; i < searchWord.length(); i++){
            char ch = searchWord.charAt(i);
            List<String>batch = new ArrayList<>();

            while(left <= right &&  (products[left].length() <= i  ||  products[left].charAt(i) != ch) ){
                left += 1;
            }

            while(left <= right && (products[right].length() <= i || products[right].charAt(i) != ch)){
                right -= 1;
            }
            //Get the first three or less
            int len = Math.min(3, (right - left + 1));
            for(int k = 0; k < len; k++){
               batch.add(products[left + k ]);
            }
            result.add(batch);

        }
        return result;
    }
    
}
