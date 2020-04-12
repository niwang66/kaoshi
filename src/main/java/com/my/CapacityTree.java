package com.my;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CapacityTree {

    static List<String> res = new ArrayList<>();

    public static void main(String[] args){

        int[] capacitys = {10,2,4,3,5,10,2,18,9,7,2,2,1,3,12,1,8,6,2,2};
        NoLeafNode node1 = new NoLeafNode(0,new int[] {1,2,3,4});
        NoLeafNode node2 = new NoLeafNode(2,new int[] {5});
        NoLeafNode node3 = new NoLeafNode(4,new int[] {6,7});
        NoLeafNode node4 = new NoLeafNode(3,new int[] {11,12,13});
        NoLeafNode node5 = new NoLeafNode(6,new int[] {9});
        NoLeafNode node6 = new NoLeafNode(7,new int[] {8,10});
        NoLeafNode node7 = new NoLeafNode(16,new int[] {15});
        NoLeafNode node8 = new NoLeafNode(13,new int[] {14,16,17});
        NoLeafNode node9 = new NoLeafNode(17,new int[] {18,11});
        NoLeafNode[] noLeafNodes = new NoLeafNode[]{node1,node2,node3,node4,node5,node6,node7,node8,node9};
        String[] res = getPathofCapacity(capacitys,noLeafNodes,24);

    }

    static class TreeNode{
        int capacity;
        List<TreeNode> subNodes;
        TreeNode(int capacity){
            this.capacity = capacity;
            subNodes = new ArrayList<>();
        }
    }

    static class NoLeafNode{
        int nodeId;
        int[] subNodes;
        NoLeafNode(int nodeId, int[] subNodes){
            this.nodeId = nodeId;
            this.subNodes = subNodes;
        }
    }
    static String[] getPathofCapacity(int[] capacitys, NoLeafNode[] noLeafNodes, int targetCapacity){
        int len = capacitys.length;
        TreeNode[] nodes = new TreeNode[len];
        for(int i=0; i<len; i++){
            TreeNode node = new TreeNode(capacitys[i]);
            nodes[i]=node;
        }
        for(NoLeafNode noLeafNode : noLeafNodes){
            int nodeId = noLeafNode.nodeId;
            TreeNode node = nodes[nodeId];
            int[] subNodes = noLeafNode.subNodes;
            for(int subNodeID : subNodes){
                TreeNode subNode = nodes[subNodeID];
                node.subNodes.add(subNode);
            }
        }
        TreeNode head = nodes[0];

        findPathofCapacity(head,0,targetCapacity,"");
        Collections.sort(res);
        return null;
    }

    private static void findPathofCapacity(TreeNode node, int currentCapacity, int targetCapacity, String path) {
        currentCapacity = currentCapacity + node.capacity;
        path = path + " " + node.capacity;
        if(node.subNodes.size()==0){
            if(targetCapacity == currentCapacity){
                res.add(path.trim());
            }
        } else {
            if(currentCapacity>=targetCapacity){
                return;
            } else {
                for(TreeNode subNode:node.subNodes){
                    findPathofCapacity(subNode, currentCapacity,targetCapacity,path);
                }
            }
        }
    }
}
