
/**
 * 查找二叉树的节点对象
 */
public class TreeNode {

    private int data;               // 数据
    private TreeNode parent;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode(int data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
        this.leftChild = null;
        this.rightChild = null;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
