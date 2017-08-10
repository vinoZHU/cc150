package jianzhioffer;

/**
 * Created by vino on 2017/8/8.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class 序列化二叉树 {
    int index;
    String Serialize(TreeNode root) {
        if (root == null)
            return "#,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index = -1;
        String[] nodes = str.split(",");
        return doDeserialize(nodes);

    }
    private TreeNode doDeserialize(String[] str) {
        index++;
        if (index >= str.length)
            return null;
        TreeNode node = null;
        if (!str[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(str[index]));
            node.left = doDeserialize(str);
            node.right = doDeserialize(str);
        }
        return node;
    }
}