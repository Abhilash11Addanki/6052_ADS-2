import java.util.ArrayList;
public class SAP {
    private Digraph dg;
    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph g) {
        dg = g;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    /*public int length(int v, int w)

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w)
*/
    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int[] length(ArrayList<Integer> v, ArrayList<Integer> w) {
        int min = dg.V();
        int temp = 0;
        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < w.size(); j++) {
                BreadthFirstDirectedPaths b1 = new BreadthFirstDirectedPaths(dg, v.get(i));
                BreadthFirstDirectedPaths b2 = new BreadthFirstDirectedPaths(dg, w.get(j));
                for (int k = 0; k < dg.V(); k++) {
                    if (b1.hasPathTo(k) && b2.hasPathTo(k)) {
                        int sum = b1.distTo(k) + b2.distTo(k);
                        if (sum < min) {
                            min = sum;
                            temp = k;
                        }
                    }
                }
            }
        }
        int[] res = {min, temp};
        return res;
    }

    /*// a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w)

    // do unit testing of this class
    public static void main(String[] args)*/
}
