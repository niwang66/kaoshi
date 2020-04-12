package leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            int y = target -x;
            map.containsKey(y);
        }
        return null;
    }
}
