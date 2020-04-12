package com.my;

public class ReverseLinkNode {
    public static void main(String[] args){
        LinkNode myLink =  new LinkNode();
        myLink.val = 0;
        myLink.next = null;

        LinkNode nowLink = myLink;

        for(int i=1; i<=10; i++){
            LinkNode newLink =  new LinkNode();
            newLink.val = i;
            nowLink.next = newLink;
            nowLink = newLink;
        }
        printLink(myLink);

        LinkNode newLink = reverseLink(myLink);
        printLink(newLink);
    }

    private static LinkNode reverseLink(LinkNode myLink) {
        if(myLink == null){
            return null;
        }
        LinkNode pre = null;
        LinkNode now = myLink;
        while(now != null){
            LinkNode newNode = now.next;
            now.next = pre;
            pre = now;
            now = newNode;
        }
        return pre;
    }

    public static void printLink(LinkNode myLink){
        while(myLink!=null){
            System.out.print(myLink.val + ",");
            myLink = myLink.next;
        }
        System.out.println();
    }
}
