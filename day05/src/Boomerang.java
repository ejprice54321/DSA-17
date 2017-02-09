import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
//        MyHashMap map = new MyHashMap();
//        List[] tempList;
//        for (int i=0; i<points.length; i++){
//            for (int j=0; j<points.length; j++) {
//                tempList[i] = Math.sqrt(double )
//                if (!map.containsKey(points[i])) {
//                    map.put(points[i])
//                }
//            }
//        }
        return 0;
    }


    private static int getSquaredDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
