import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Taking synsets file name as input.
		String synsets = sc.nextLine();
		File file = new File("Files\\" + synsets);
		HashMap<Integer, ArrayList<String>> synsetshm = new HashMap<Integer, ArrayList<String>>();
		HashMap<String, ArrayList<Integer>> revsynsetshm = new HashMap<String, ArrayList<Integer>>();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<Integer> al2 = new ArrayList<Integer>();
				String[] inp = scan.nextLine().split(",");
				String[] tokens = inp[1].split(" ");
				String[] tokens1 = inp[0].split(" ");
				for (String s : tokens) {
					al.add(s);
				}
				for (String i : tokens1) {
					al2.add(Integer.parseInt(i));
				}
				synsetshm.put(Integer.parseInt(inp[0]), al);
				revsynsetshm.put(inp[1], al2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// Taking hypernyms file name as input.
		String hypernyms = sc.nextLine();
		// Taking the type of testcase as input.
		String type = sc.nextLine();
		File file2 = new File("Files\\" + hypernyms);
		HashMap<Integer, Integer> hypernymshm = new HashMap<Integer, Integer>();
		int vertices = synsetshm.size();
		Digraph d = new Digraph(vertices);
		switch (type) {
		case "Graph":
			try {
				Scanner scan1 = new Scanner(file2);
				while (scan1.hasNextLine()) {
					String[] inp = scan1.nextLine().split(",");
					if (inp.length > 2) {
						for (int i = 1; i <= inp.length; i++) {
							d.addEdge(Integer.parseInt(inp[0]), Integer.parseInt(inp[i]));
						}
					} else {
						d.addEdge(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			DirectedCycle dc = new DirectedCycle(d);
			int cnt = 0;
			for (int i = 0; i < d.V(); i++) {
				if (d.outdegree(i) == 0) {
					cnt++;
				}
			}
			if (cnt > 1) {
				System.out.println("Multiple roots");
				break;
			}
			if (dc.hasCycle()) {
				System.out.println("Cycle detected");
				break;
			}
			System.out.println(d);
			break;
		case "Queries":
			while (sc.hasNext()) {
				String[] inp = sc.nextLine().split(" ");
				if (inp[0].equals("null")) {
					System.out.println("IllegalArgumentException");
					break;
				}
			}
		}
	}
}