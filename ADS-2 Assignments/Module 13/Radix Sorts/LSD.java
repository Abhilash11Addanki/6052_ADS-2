/**
 * Class for lsd.
 */
class LSD {
    /**
     * 8 bits.
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

    /**
      * Rearranges the array of 32-bit integers in ascending order.
      * This is about 2-3x faster than Arrays.sort().
      *
      * @param a the array to be sorted
      */
    public void sort(final int[] a) {
        final int bits = 32;
        final int r = 1 << BITS_PER_BYTE;
        final int mask = r - 1;
        final int w = bits / BITS_PER_BYTE;

        int n = a.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) {

            // compute frequency counts
            int[] count = new int[r + 1];
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d)
                & mask;
                count[c + 1]++;
            }

            // compute cumulates
            for (int j = 0; j < r; j++) {
                count[j + 1] += count[j];
            }

            if (d == w - 1) {
                int shift1 = count[r] - count[r / 2];
                int shift2 = count[r / 2];
                for (int i = 0; i < r / 2; i++) {
                    count[i] += shift1;
                }
                for (int j = r / 2; j < r; j++) {
                    count[j] -= shift2;
                }
            }

            // move data
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & mask;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }
}
