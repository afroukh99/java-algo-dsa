import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class SocialNetwork {

    private In in;
    private WeightedQuickUnionPC weightedQuickUnionPC;

    public SocialNetwork (In in  , int N) {
        this.in = in;
        this.weightedQuickUnionPC = new WeightedQuickUnionPC(N);
    }

    public void getTimeStamp () {

            while (!in.isEmpty()) {
                String timeStamp = this.in.readString();
                int p = this.in.readInt();
                int q = this.in.readInt();

                weightedQuickUnionPC.union(p,q);

                if (weightedQuickUnionPC.getCount() == 1) {
                    StdOut.printf("Earliest time where all members are connected  : %s" , timeStamp);
                    return;
                }
            }
        StdOut.printf("Not all members became connected");

    }



}
