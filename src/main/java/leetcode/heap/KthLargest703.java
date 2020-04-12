package leetcode.heap;

import java.util.PriorityQueue;

//小顶堆
public class KthLargest703 {
    int k;
    PriorityQueue<Integer> priorityQueue;
    public KthLargest703(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>();
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(priorityQueue.size()<k){
            priorityQueue.add(val);
        } else if (val > priorityQueue.peek()){
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args){
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest703 kthLargest = new KthLargest703(3, arr);
        System.out.println(kthLargest.add(3));// returns 4
        System.out.println(kthLargest.add(5));// returns 5
        kthLargest.add(10);// returns 5
        kthLargest.add(9);// returns 8
        kthLargest.add(4);// returns 8
    }

}
