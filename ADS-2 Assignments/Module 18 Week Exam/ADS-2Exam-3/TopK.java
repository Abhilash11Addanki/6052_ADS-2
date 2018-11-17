class TopK implements Comparable<TopK> {
	private String word;
	private int freq;
	TopK(String w, int f) {
		word = w;
		freq = f;
	}
	String getWord() {
		return word;
	}
	public int compareTo(TopK that) {
		if (this.freq > that.freq) {
			return 1;
		}
		if (this.freq < that.freq) {
			return -1;
		}
		if(this.word.length() > that.word.length()) {
			return 1;
		}
		if(this.word.length() < that.word.length()) {
            return -1;
		}
		return 0;
	}
}
