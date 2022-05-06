package cn.oddworld;

import java.util.ArrayList;
import java.util.List;

public class Leetcode25 {

    public static void main(String[] args) {

        Leetcode25 leetcode25 = new Leetcode25();
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        leetcode25.reverseKGroup(n1, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode node = head;
        int count = 0;
        while (node != null){
            count++;
            node = node.next;
        }
        int reverseCnt = count / k;
        if(reverseCnt == 0){
            return head;
        }

        List<ListNode> result = new ArrayList<>();
        reverse(result, head, k, reverseCnt);

        ListNode preNode = new ListNode(-1, null);
        for(ListNode item : result){
            preNode.next = item;
            while (item != null){
                preNode = item;
                item = item.next;
            }
        }

        return result.get(0);
    }

    public void reverse(List<ListNode> resultHead, ListNode head, int n, int reverseCnt){

        if(reverseCnt == 0){

            resultHead.add(head);
            return;
        }

        ListNode currentNode = head;
        ListNode preNode = null;
        int initCnt = n;
        while (currentNode != null && n > 0){
            ListNode temp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = temp;
            n--;
        }
        resultHead.add(preNode);
        reverse( resultHead,  currentNode, initCnt, reverseCnt-1);
    }
}
