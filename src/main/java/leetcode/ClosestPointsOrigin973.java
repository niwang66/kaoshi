package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPointsOrigin973 {
    public static void main(String[] args){
        int[][] points = {{1,3},{-2,2},{1,1},{3,3}};
        int k = 1;
        int[][] result = kClosest(points,k);
    }

    public static int[][] kClosest(int[][] points, int K) {
        List<MyPoint> pointArray= new ArrayList<>();
        for(int[] point : points){
            pointArray.add(new MyPoint(point[0],point[1]));
        }
        Collections.sort(pointArray);
        int[][] res = new int[K][2];
        int len = pointArray.size();
        for(int i=0; i<K; i++){
            MyPoint myPoint =pointArray.get(i);
            res[i][0] = myPoint.x;
            res[i][1] = myPoint.y;
        }

        return res;
    }

}
class MyPoint implements Comparable{
    int x;
    int y;
    int distance;
    MyPoint(int x, int y){
        this.x = x;
        this.y = y;
        this.distance = x*x + y*y;
    }
    @Override
    public int compareTo(Object o) {
        int newDistance =((MyPoint)o).distance;
        return distance-newDistance;
    }
}

