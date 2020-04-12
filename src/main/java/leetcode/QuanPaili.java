package leetcode;

import java.util.LinkedList;
import java.util.List;

public class QuanPaili {

    private static final List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args){
        LinkedList<Integer> track = new LinkedList<>();
        int[] nums = {1, 2, 3, 4};
        backtrack(nums, track);
        printList(res);
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        if(nums.length == track.size()){
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void printList(List<List<Integer>> lists){
        for(List<Integer> list: lists){
            for(Integer i: list){
                System.out.print(i + ",");
            }
            System.out.println();
        }

    }
}
