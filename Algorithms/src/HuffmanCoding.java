import java.util.*;

public class HuffmanCoding {

    // Node class to represent the binary tree nodes
    private static class Node {
        char ch;
        int freq;
        Node left;
        Node right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public static String compress(String data) {
        // Step 1: Create a frequency table and min-heap
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : data.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            minHeap.offer(new Node(entry.getKey(), entry.getValue()));
        }

        // Step 2: Create a binary tree using the min-heap
        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();
            minHeap.offer(new Node('\0', left.freq + right.freq, left, right));
        }
        Node root = minHeap.poll();

        // Step 3: Assign binary codes to each character
        Map<Character, String> codes = new HashMap<>();
        assignCode(root, "", codes);

        // Step 4: Traverse the binary tree and store the codes in a hash table
        StringBuilder compressedData = new StringBuilder();
        for (char ch : data.toCharArray()) {
            compressedData.append(codes.get(ch));
        }

        return compressedData.toString();
    }

    private static void assignCode(Node node, String code, Map<Character, String> codes) {
        if (node.isLeaf()) {
            codes.put(node.ch, code);
            return;
        }
        assignCode(node.left, code + "0", codes);
        assignCode(node.right, code + "1", codes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter data to be compressed: ");
        String data = scanner.nextLine();
        String compressedData = compress(data);
        System.out.println("Compressed data: " + compressedData);
        scanner.close();
    }
}
