package leetcode;
import java.util.*;

// 克隆图
public class CloneGraph {
    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);

        for (int i = 0; i < node.neighbors.size(); i++) {
            newNode.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
