package leetcode.link;


import java.util.HashMap;
import java.util.Map;

public class RotateList61 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = null;

        ListNode current = head;

        for (int i = 2; i <= 5; i++) {
            ListNode newNode = new ListNode(i);
            current.next = newNode;
            current = newNode;
        }
        head.print();
        rotateRight(head, 2).print();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int count=1;
        ListNode current = head;
        nodeMap.put(1,current);
        while(current.next !=null){
            count++;
            current = current.next;
            nodeMap.put(count,current);
        }
        if(count==1 || k==0){
            return head;
        }
        k=k%count;
        int index = count-k;
        nodeMap.get(index).next=null;
        head = nodeMap.get(count-k+1);
        nodeMap.get(count).next=nodeMap.get(1);
        return head;
    }
}

