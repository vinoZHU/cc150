package cc150.youxianglujinjiancha;

import java.util.*;

/**
 * Created by vino on 2017/6/3.
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 给定图中的两个结点的指针UndirectedGraphNode* a,UndirectedGraphNode* b(请不要在意数据类型，图是有向图),请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */
public class Main {

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        return check(a, b) || check(b, a);
    }

    private boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
        if (a == null || b == null)
            return false;
        if (a == b)
            return true;
        Map<UndirectedGraphNode, Boolean> visitedMap = new HashMap<>();
        Queue<UndirectedGraphNode> nextNodes = new LinkedList<>();
        nextNodes.add(a);

        while (!nextNodes.isEmpty()) {
            UndirectedGraphNode currentNode = nextNodes.poll();
            if (visitedMap.containsKey(currentNode))
                continue;
            visitedMap.put(currentNode, true);
            ArrayList<UndirectedGraphNode> neighbors = currentNode.neighbors;
            if (neighbors == null || neighbors.isEmpty())
                continue;
            for (UndirectedGraphNode node : neighbors) {
                if (node == b)
                    return true;
                nextNodes.add(node);
            }
        }
        return false;
    }

}
class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}