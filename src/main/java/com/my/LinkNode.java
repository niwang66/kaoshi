package com.my;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinkNode {
    public LinkNode next;
    public int val;

    public static void main(String[] args){
        int[] array = {1,2,3};
        //List<Integer> list  = (List<Integer>) Arrays.asList(array);

        List<Integer> list1 = Arrays.stream(array).boxed().collect(Collectors.toList());

    }
}
