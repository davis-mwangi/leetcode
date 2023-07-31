package binary_search;
import java.util.*;
/**
 * https://leetcode.com/problems/time-based-key-value-store/description/
 * 
 * 
 */
// Using Binary Search
class TimeMap {
    /**
    key: {timestamp1: value,timestamp2: value }
    
     */
    private Map<String, List<Pair>>map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
           map.put(key, new ArrayList<Pair>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
   
    public String get(String key, int timestamp) {
        String result = "";
        if(!map.containsKey(key)){
             return result;
        }
         // Do Binary Search
         List<Pair>values = map.get(key);
         int left = 0;
         int right = values.size() - 1;
         while(left <=  right){
             int mid = left + ((right - left) / 2);
             Pair pair = values.get(mid);
             if(pair.getKey()<= timestamp){
                   result = pair.getValue();
                   left =  mid + 1;
             }else{
                 right =  mid - 1;
             }
         }
         return result;
    }
    static class Pair{
        Integer key;
        String value;
        public Pair(Integer key,String value ){
            this.key =  key;
            this.value = value;
        }
        public Integer getKey(){
            return this.key;
        }
        public String getValue(){
            return this.value;
        }
        public String  getValue(Integer key){
            if(this.key.equals(key)){
                return this.value;
            }
            return null;
        }
    }
}

 // Using TreeMap in Collections Framework
class TimeMap2 {
    /**
    key: {timestamp1: value,timestamp2: value }
    
     */
    private Map<String, TreeMap<Integer,String>>map;
    
    public TimeMap2() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
           map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
           return "";
        }else{
            Integer prevOrCurrKey = map.get(key).floorKey(timestamp);
            if(prevOrCurrKey != null){
                return map.get(key).get(prevOrCurrKey);
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
