/**
 * 树节点
 */
public class TreeNode {

    private String data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(String data) {
        super();
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
