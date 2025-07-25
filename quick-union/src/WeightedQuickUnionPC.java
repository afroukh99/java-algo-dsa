public class WeightedQuickUnionPC {

    private int[] parent;
    private int[] size;
    private int count;
    private int[] max;


    public  WeightedQuickUnionPC (int N) {
        parent = new int[N];
        size = new int[N];
        max = new int[N];
        count = N;

        for (int i = 0 ; i < N ; i++) {
            parent[i] = i;
            max[i] = i;
            size[i] = 1;
        }
    }

    public int root (int x) {
        if (x != parent[x]) {
            parent[x] = root(parent[x]);
        }
        return parent[x];
    }

    public int getCount () {return count;}

    public boolean connected (int p , int q) {
        int rootP = root(p);
        int rootQ = root(q);
        return rootP == rootQ;
    }

    public int find (int x) {
        return  max[root(x)];
    }

    public void union (int p , int q) {
        if (connected( p , q )) return;

        int rootP = root(p);
        int rootQ = root(q);

        if (size[rootP] > size[rootQ]) {
            if (max[rootQ] > max[rootP]) {
                max[rootP] = max[rootQ];
            }
            parent[rootQ] = rootP;
            size[rootP] +=size[rootQ];
        }else {
            if (max[rootP] > max[rootQ]) {
                max[rootQ] = max[rootP];
            }
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }


        count--;
    }

}
