/**
 * Class for boggle solver.
 */
public class BoggleSolver {
    /**
     * dictionary of type TrieSET.
     */
    private TrieSET dict;
    /**
     * Constructs the object.
     * Initializes the data structure using the given
     array of strings as the dictionary.
     (You can assume each word in the dictionary contains
     only the uppercase letters A through Z.)
     * @param      dictionary  The dictionary
     */
    public BoggleSolver(final String[] dictionary) {
        dict = new TrieSET();
        for (String s : dictionary) {
            dict.add(s);
        }
    }
    /**
     * Gets all valid words.
     * Returns the set of all valid words in the given
     * Boggle board, as an Iterable.
     * @param      board  The board
     * @return     All valid words.
     */
    public Iterable<String> getAllValidWords(final BoggleBoard board) {
        SET<String> validwords = new SET<String>();
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                boolean[][] marked = new boolean[board.rows()][board.cols()];
                collect(board, i, j, marked, "", validwords);
            }
        }
        return validwords;
    }
    /**
     * helper method for getAllValidWords method.
     * @param      board   The board
     * @param      row     The row
     * @param      col     The col
     * @param      marked  The marked
     * @param      prefix  The prefix
     * @param      set     The set
     */
    private void collect(final BoggleBoard board, final int row, final int col,
                         final boolean[][] marked, final String prefix,
                         final SET<String> set) {
        if (marked[row][col]) {
            return;
        }
        char letter = board.getLetter(row, col);
        String word = prefix;

        if (letter == 'Q') {
            word += "QU";
        } else {
            word += letter;
        }

        if (!dict.hasPrefix(word)) {
            return;
        }

        if (word.length() > 2 && dict.contains(word)) {
            set.add(word);
        }

        marked[row][col] = true;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if ((row + i >= 0) && (row + i < board.rows())
                    && (col + j >= 0) && (col + j < board.cols())) {
                    collect(board, row + i, col + j, marked, word, set);
                }
            }
        }

        marked[row][col] = false;
    }
    /**
     * Returns the score of the given word if it is in the dictionary,
     zero otherwise.
     (You can assume the word contains only the uppercase letters A through Z.)
     * @param      word  The word
     * @return     score of type integer.
     */
    public int scoreOf(final String word) {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int seven = 7;
        final int eleven = 11;
        if (dict.contains(word)) {
            switch (word.length()) {
            case 0:
            case 1:
            case 2:
                return 0;
            case three:
            case four:
                return 1;
            case five:
                return 2;
            case six:
                return three;
            case seven:
                return five;
            default:
                return eleven;
            }
        } else {
            return 0;
        }
    }
}

