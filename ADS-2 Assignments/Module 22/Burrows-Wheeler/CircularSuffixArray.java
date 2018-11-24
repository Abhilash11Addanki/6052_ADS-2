public class CircularSuffixArray {
	private static final int cutoff = 5;
	private final char[] text;
	private final int[] index;
	private final int n;
    public CircularSuffixArray(String s) {
    	n = s.length();
    	s = s + '\0';
    	text = s.toCharArray();
    	index = new int[n];
    	for (int i = 0; i < n; i++) {
    		index[i] = i;
    	}
    	sort(0, n-1, 0);
    }
    public int length() {
    	return n;
    }

    /**
     * returns index of ith sorted suffix
     *
     * @param i
     *            the index of the ith sorted suffix
     * @return
     */
    public int index(int i) {
    	return index[i];
    }
    private char circularText(int i, int d) {
    	return text[(i + d) % n];
    }
    private void sort(int lo, int hi, int d) {
    	if (d == n) {
    		return;
    	}
    	if (hi <= lo + cutoff) {
    		insertion(lo, hi, d);
    		return;
    	}
    	int lt = lo, gt = hi;
    	char v = circularText(index[lo], d);
    	int i = lo + 1;
    	while (i <= gt) {
    		int t = circularText(index[i], d);
    		if (t < v) {
    			exch(lt++, i++);
    		} else if (t > v) {
    			exch(i, gt--);
    		} else {
    			i++;
    		}
    	}
    	sort(lo, lt - 1, d);
    	sort(lt, gt, d + 1);
    	sort(gt + 1, hi, d);
    }
    // sort from a[lo] to a[hi], starting at the dth character 
    private void insertion(int lo, int hi, int d) { 
        for (int i = lo; i <= hi; i++) 
            for (int j = i; j > lo && less(index[j], index[j-1], d); j--) 
                exch(j, j-1); 
    } 
 
    // is text[i+d..i-1) < text[j+d..i-1) ? 
    private boolean less(int i, int j, int d) { 
        if (i == j) return false; 
        for (int k = d; k < n; k++) { 
            if (circularText(i, k) < circularText(j, k)) return true; 
            if (circularText(i, k) > circularText(j, k)) return false; 
        } 
        return i > j; 
    } 
 
    // exchange index[i] and index[j] 
    private void exch(int i, int j) { 
        int swap = index[i]; 
        index[i] = index[j]; 
        index[j] = swap; 
    }
}
