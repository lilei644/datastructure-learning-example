import java.util.Arrays;
import java.util.List;

/**
 * 二叉树
 */
public class BinaryTree {

    private TreeNode root;              // 根节点
    private int index = 0;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 创建二叉树
     *                        A
     *                  B          C
     *              #      D     #    E
     *                  #   #       #    #
     * 前序遍历：AB#D##C#E##
     *
     */
    public TreeNode createBinaryTree(List<String> dataList) {
        if (index <= 0 || index >= dataList.size()) {
            index = 0;
        }
        String data = dataList.get(index);

        // 判断接收到的节点是否为空
        if (data.equals("#")) {
            return null;
        }

        TreeNode treeNode = new TreeNode(data);

        // 判断是否是根节点
        if (root == null) {
            root = treeNode;
        }

        index ++;
        treeNode.setLeftChild(createBinaryTree(dataList));
        index ++;
        treeNode.setRightChild(createBinaryTree(dataList));
        return treeNode;
    }


    /**
     * 前序遍历
     * @param treeNode 节点
     */
    public void preOrderShow(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print(" # ");
            return;
        }

        System.out.print(" " + treeNode.getData() + " ");
        preOrderShow(treeNode.getLeftChild());
        preOrderShow(treeNode.getRightChild());
    }

    /**
     * 中序遍历
     * @param treeNode 节点
     */
    public void midOrderShow(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print(" # ");
            return;
        }

        midOrderShow(treeNode.getLeftChild());
        System.out.print(" " + treeNode.getData() + " ");
        midOrderShow(treeNode.getRightChild());
    }

    /**
     * 后序遍历
     * @param treeNode 节点
     */
    public void laterOrderShow(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print(" # ");
            return;
        }

        laterOrderShow(treeNode.getLeftChild());
        laterOrderShow(treeNode.getRightChild());
        System.out.print(" " + treeNode.getData() + " ");
    }




    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        String[] dataArray = new String[]{ "A", "B", "#", "D", "#", "#", "C", "#", "E", "#", "#"};

        // 创建二叉树
        binaryTree.createBinaryTree(Arrays.asList(dataArray));

        // 遍历二叉树
        System.out.print("\n前序遍历：");
        binaryTree.preOrderShow(binaryTree.getRoot());
        System.out.print("\n中序遍历：");
        binaryTree.midOrderShow(binaryTree.getRoot());
        System.out.print("\n后序遍历：");
        binaryTree.laterOrderShow(binaryTree.getRoot());

    }

}
