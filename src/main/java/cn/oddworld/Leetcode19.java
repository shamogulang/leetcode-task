package cn.oddworld;

/**
 * Given the head of a linked list, remove the nth node from
 * the end of the list and return its head.
 */
public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curNode = head;
        int count = 0;
        while (curNode != null){
            count++;
            curNode = curNode.next;
        }

        int index = count - n  ;
        ListNode indexNode = head;

        ListNode preNode = null;
        for(int i = 0; i < index;i++){
            preNode = indexNode;
            indexNode = indexNode.next;
        }

        if(indexNode != null){

            if(preNode == null){
                return indexNode.next;
            }else {
                preNode.next = indexNode.next;
            }
        }
        return head;
    }
}


   class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
