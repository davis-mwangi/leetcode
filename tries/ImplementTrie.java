package tries;
/*
Coding Ninjas: https://www.codingninjas.com/studio/problems/implement-trie_631356?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=PROBLEM
Take U Forward: https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=1
*/
public class ImplementTrie {
    public class Trie {


        //Initialize your data structure here
       private static Node root;
    
        Trie() {
            //Write your code here
            root = new Node();
        }
    
    
        //Inserts a word into the trie
    
        public static void insert(String word) {
            //Write your code here
            Node node = root;
            for(int i =0; i< word.length();i++){
                char ch = word.charAt(i);
                if( !node.containsKey(ch) ){
                    node.put(ch, new Node());
                }
                //Moves to the next reference node
                node = node.get(ch);
            }
            node.setEnd(); 
        }
    
    
        //Returns if the word is in the trie
    
        public static boolean search(String word) {
            //Write your code here
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i); 
                if(!node.containsKey(ch)){
                     return false;
                }
                node = node.get(ch);
            }
            //At the end, check if its an end node
            return node.isEnd();
        }
    
        
        //Returns if there is any word in the trie that starts with the given prefix
    
        public static boolean startsWith(String prefix) {
            //Write your code here
            Node node = root;
            for(int i = 0; i< prefix.length();i++){
                char ch = prefix.charAt(i);
               
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.get(ch);
            }
            return true;
    
        }
    
        static class Node{
            Node [] links;
            boolean flag;
    
            Node(){
                this.links = new Node[26];
                this.flag = false;
            }
            boolean containsKey(char ch){
    
               return  this.links[ch - 'a'] != null;
            }
            void put(char ch, Node node){
                this.links[ch - 'a'] = node;
            }
            Node get(char ch){
               return  this.links[ch - 'a'];
            }
            void setEnd(){
                this.flag = true;
            }
            boolean isEnd(){
                return this.flag;
            }
    
        }
    }
}
