package tries;
/*
Coding Ninjas:  https://www.codingninjas.com/studio/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
YouTube : https://www.youtube.com/watch?v=K5pcpkEMCN0&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=2

*/

public class ImplementTrieII {

public class Trie {

    private static Node root;
   
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0; i< word.length(); i++){
             char ch = word.charAt(i);
             if(!node.containsKey(ch)){
                node.put(ch, new Node());
             }
            //Next node
            node =  node.get(ch);
            node.increasePrefixCount();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for(int i =0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        return node.getEndCount();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0; i< word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                 return 0;
            } 
            node = node.get(ch);
        }
        return node.getPrefixCount();
    }


    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0; i< word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                 return;
            }
            node = node.get(ch);
            node.decrementPrefixCount();
        }
        node.decrementEnd();

    }
    static class Node {
        private Node [] links;
        private int endsWith;
        private int prefixCount;

        Node(){
            this.links = new Node[26];
            this.endsWith = 0;
            this.prefixCount = 0;  
        }

        boolean containsKey(char ch){
            return this.links[ch - 'a'] != null;
        }
        Node get(char ch){
            return this.links[ch - 'a'];
        }

        void put(char ch, Node node){
            this.links[ch - 'a'] = node;
        }
        
        void increaseEnd(){
            this.endsWith ++;
        }
        void decrementEnd(){
            this.endsWith --;
        }

        void increasePrefixCount(){
            this.prefixCount ++;
        }
        void decrementPrefixCount(){
            this.prefixCount--;
        }
        int getEndCount(){
            return this.endsWith;
        }
         int getPrefixCount(){
            return this.prefixCount;
        }
    }

}

}
