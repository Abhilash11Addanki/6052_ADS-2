/**
 * Class for lsd.
 */
class LSD {
    /**
     * Bits per Byte of type int.
     */
    private static final int BITS_PER_BYTE = 8;
    /**
      * Rearranges the array of W-character
      * strings in ascending order.
      *
      * @param a the array to be sorted
      * @param w the number of characters per string
      */
    public void sort(final String[] a, final int w) {
        int n = a.length;
        final int r = 256;   // extend ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[r + 1];
            for (int i = 0; i < n; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            // compute cumulates
            for (int i = 0; i < r; i++) {
                count[i + 1] += count[i];
            }

            // move data
            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // copy back
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }
}
