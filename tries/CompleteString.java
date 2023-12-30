package tries;
/*
Coding Ninjas : https://www.codingninjas.com/studio/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos

*/
public class CompleteString {
    class Solution {

        public static String completeString(int n, String[] a) {
          // Write your code here.
           Trie trie = new Trie();
      
          //Insert words in the trie;
          //TC: O(n * len(word) )
          for(String word: a){
              trie.insert(word);
          }
      
          String longest = "";
          //TC: O(n * len(word) )
          for(int i = 0; i < a.length; i++){
                String word = a[i];
                if(trie.checkIfAllPrefixExists(word)){
                   if(word.length() > longest.length()){
                      longest = word;
                   //If equal return the lexicographically smaller
                   }else if(word.length() == longest.length() &&
                          word.compareTo(longest) < 0){
                         longest = word;
                   }
                }
          }
      
          return longest=="" ? "None" : longest;
      
      
        }
      
        static class Trie {
         
           Node root;
           
           Trie (){
             root = new Node();
           }
      
           void insert(String word){
             Node node = root;
             for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                     node.put(ch, new Node());
                }
                node = node.get(ch);
             }
             node.markEnd();
           }
      
           boolean checkIfAllPrefixExists(String word){
              Node node = root;
              for(int i = 0; i < word.length();i++){
                  char ch = word.charAt(i);
                  if(node.containsKey(ch)){
                     node = node.get(ch);
                     if (!node.isEnd() ){
                       return false;
                     }
                  }else{
                    return false;
                  }
              }
              return true;
           }
        }
      
        static class Node {
            private Node[] links;
            private boolean end;
      
            Node(){
              this.links = new Node [26];
              this.end = false;
            }
      
            boolean containsKey(char ch){
              return this.links[ch -'a'] != null;
            }
      
            void put(char ch, Node node){
              this.links[ch - 'a']= node;
            }
      
            Node get(char ch){
              return this.links[ch - 'a'];
            }
      
            boolean isEnd(){
              return  this.end;
            }
            void markEnd(){
              this.end = true;
            }
      
      
        }
      }
}
