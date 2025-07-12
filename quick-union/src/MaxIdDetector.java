import edu.princeton.cs.algs4.In;

public class MaxIdDetector {


    public static int getMaxId (String filename) {
       In in = new In(filename);
       int maxId = 0;

       while (!in.isEmpty()) {
           String timeStamp = in.readString();
           int p = in.readInt();
           int q = in.readInt();
            maxId = Math.max(maxId, Math.max(p , q));
       }

       return maxId + 1;
    }


}
