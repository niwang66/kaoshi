package leetcode.heap;

import java.util.PriorityQueue;


//大顶堆
public class SwingWindow239 {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(arr,3);

        //System.out.println(q.peek().value);
        //System.out.println(q.peek().value);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len-k+1];
        for(int i=0; i< result.length; i++){
            PriorityQueue<NewInt> q = new PriorityQueue<>();
            for(int j=0; j<k; j++) {
                q.add(new NewInt(nums[i+j]));
            }
            result[i]=(q.peek().value);
        }
        return result;
    }
}

class NewInt implements Comparable{
    int value;
    NewInt(int value){
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        int newValue = ((NewInt) o).value;
        return newValue-value;
    }
}
