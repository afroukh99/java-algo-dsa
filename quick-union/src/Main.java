
import edu.princeton.cs.algs4.In;

public class Main {
    public static void main(String[] args) {
        String filename = "data/log.txt";
        In in = new In(filename);
        int N = MaxIdDetector.getMaxId(filename);

        SocialNetwork socialNetwork = new SocialNetwork(in , N);
        socialNetwork.getTimeStamp();
        System.out.println();
        System.out.println("========================================");
        WeightedQuickUnionPC weightedQuickUnionPC = new WeightedQuickUnionPC(10);
        // First component
        weightedQuickUnionPC.union(0 , 8);
        weightedQuickUnionPC.union(8,4);
        weightedQuickUnionPC.union(5,4);

        //seconde component
        weightedQuickUnionPC.union(3 , 1);
        weightedQuickUnionPC.union(6,1);
        weightedQuickUnionPC.union(9,6);
        weightedQuickUnionPC.union(3,2);
        weightedQuickUnionPC.union(7,3);

        // connect two components
        weightedQuickUnionPC.union(9 , 4);

        System.out.println("Components number :" + weightedQuickUnionPC.getCount());
        System.out.printf("The largest element in the connected component containing  %d : %d" , 4 , weightedQuickUnionPC.find(4));

    }
}