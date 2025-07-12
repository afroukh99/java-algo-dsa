
import edu.princeton.cs.algs4.In;

public class Main {
    public static void main(String[] args) {
        String filename = "data/log.txt";
        In in = new In(filename);
        int N = MaxIdDetector.getMaxId(filename);

        SocialNetwork socialNetwork = new SocialNetwork(in , N);
        socialNetwork.getTimeStamp();

    }
}