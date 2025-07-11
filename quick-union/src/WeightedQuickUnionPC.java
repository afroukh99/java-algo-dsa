public class WeightedQuickUnionPC {

    private int[] parent;
    private int[] size;
    private int count;

    public  WeightedQuickUnionPC (int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0 ; i < N ; i++) {
            parent[i] = i;
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

    public void union (int p , int q) {
        if (connected( p , q )) return;

        int rootP = root(p);
        int rootQ = root(q);

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] +=size[rootQ];
        }else {
             parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

}
