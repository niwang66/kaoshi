package leetcode.link;

import java.util.HashMap;
import java.util.Map;

public class ReverseLinkedList92 {

    public static void main(String[] args){
        ListNode head =  new ListNode(1);
        head.next = null;

        ListNode current = head;

        for(int i=2; i<=2; i++){
            ListNode newNode =  new ListNode(i);
            current.next = newNode;
            current = newNode;
        }
        head.print();
        reverseBetween(head,1,2).print();

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        nodeMap.put(1, head);

        int counter = 1;
        ListNode countNode = head;
        while (countNode.next != null) {
            counter++;
            countNode = countNode.next;
            nodeMap.put(counter, countNode);
        }
//        if(m>=counter || n>=counter){
//            return head;
//        }
        ListNode start = nodeMap.get(n);;
        if(m==1) {
            head = start;
        }
        else {
            nodeMap.get(m - 1).next = start;
        }
        ListNode current=start;
        for(int i=n-1; i>=m; i--){
            current.next = nodeMap.get(i);
            current = current.next;
        }
        if(n==counter){
            current.next = null;
        } else {
            current.next = nodeMap.get(n + 1);
        }
        return head;

    }
}
