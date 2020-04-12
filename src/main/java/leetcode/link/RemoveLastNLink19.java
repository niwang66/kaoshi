package leetcode.link;

import java.util.HashMap;
import java.util.Map;

public class RemoveLastNLink19 {
    public static void main(String[] args){
        ListNode head =  new ListNode(1);
        head.next = null;

        ListNode current = head;

        for(int i=2; i<=5; i++){
            ListNode newNode =  new ListNode(i);
            current.next = newNode;
            current = newNode;
        }
        head.print();
        removeNthFromEnd(head,2).print();

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        nodeMap.put(1, head);

        int counter = 1;
        ListNode countNode = head;
        while (countNode.next != null) {
            counter++;
            countNode = countNode.next;
            nodeMap.put(counter, countNode);
        }
        int index = counter -n;
        if(index==0) {
            return head.next;
        }
        nodeMap.get(index).next=nodeMap.get(index+2);
        return head;
    }
}
