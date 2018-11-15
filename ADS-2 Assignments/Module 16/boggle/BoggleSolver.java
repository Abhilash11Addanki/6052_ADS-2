public class BoggleSolver {
	// Initializes the data structure using the given array of strings as the dictionary.
	String[] dict;
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	public BoggleSolver(String[] dictionary) {
		dict = dictionary;
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		return new Bag<String>();
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		for (String w : dict) {
			if (word.equals(w)) {
				return 0;
			}
		}
		return 0;
	}
}