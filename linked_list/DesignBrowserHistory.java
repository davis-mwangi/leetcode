package linked_list;
/**
 * https://leetcode.com/problems/design-browser-history/description/
 */
public class DesignBrowserHistory {
    static class ListNode {
        String val;
        ListNode prev;
        ListNode next;

        public ListNode(String val){
            this.val  = val;
            this.prev =  null;
            this.next =  null;
        }

        public ListNode(String val, ListNode prev, ListNode next){
            this.val  = val;
            this.prev =  prev;
            this.next =  next;
        }
    }
    static class BrowserHistory {
        ListNode curr;
        public BrowserHistory(String homepage) {
            this.curr = new  ListNode(homepage);
        }
        
        public void visit(String url) {
            this.curr.next = new ListNode(url, this.curr, null);
            this.curr = this.curr.next;
        }
        
        public String back(int steps) {
            while(curr.prev != null  && steps > 0){
                curr =  curr.prev;
                steps -= 1;
            }
            return curr.val;
        }
        
        public String forward(int steps) {
            while(curr.next != null && steps > 0){
                curr = curr.next;
                steps -= 1;
            }
            return curr.val;
        }
    }
}
