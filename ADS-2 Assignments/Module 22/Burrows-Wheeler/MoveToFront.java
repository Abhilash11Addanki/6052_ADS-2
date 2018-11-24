import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
public class MoveToFront {
	private static char[] initMtf() {
		char[] mtf = new char[256];
		for (char c = 0; c < 256; c++) {
			mtf[c] = c;
		}
		return mtf;
	}
	private static char[] read() {
		String s = BinaryStdIn.readString();
		return s.toCharArray();
	}
	public static void encode() {
		char[] in = read();
		char[] mtf = initMtf();
		for (int i = 0; i < in.length; i++) {
			char c = 0;
			for (char k = 0; k < 256; k++) {
				char tmp = mtf[k];
				mtf[k] = c;
				c = tmp;
				if (c == in[i]) {
					mtf[0] = c;
					BinaryStdOut.write(k);
					break;
				}
			}
		}
		BinaryStdOut.flush();
	}
	public static void decode() {
		char[] in = read();
		char[] mtf = initMtf();
		for (int i = 0; i < in.length; i++) {
			char c = 0;
			for (char k = 0; k < 256; k++) {
				char tmp = mtf[k];
				mtf[k] = c;
				c = tmp;
				if (k == in[i]) {
					mtf[0] = c;
					BinaryStdOut.write(c);
					break;
				}
			}
		}
		BinaryStdOut.flush();
	}
	public static void main(String[] args) {
		if (args[0].equals("-")) {
			encode();
		} else if (args[0].equals("+")) {
			decode();
		}
	}
}
