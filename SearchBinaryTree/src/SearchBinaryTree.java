

/**
 * 查找二叉树 —— 小的在左节点，大的在右节点
 */
public class SearchBinaryTree {

    private TreeNode root;          // 根节点


    public TreeNode getRoot() {
        return root;
    }

    /**
     * 查找二叉树添加节点
     *
     * @param data 节点数据
     */
    public void put(int data) {

        // 判断是否有根节点
        if (root == null) {
            root = new TreeNode(data);
            return;
        }

        // 根据大小添加是左还是右
        TreeNode node = root;
        TreeNode parent = null;
        while (node != null) {
            parent = node;
            if (data < node.getData()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }

        // 找到添加的节点位置
        TreeNode treeNode = new TreeNode(data, parent);
        if (data < parent.getData()) {
            parent.setLeftChild(treeNode);
        } else {
            parent.setRightChild(treeNode);
        }
    }


    /**
     * 中序遍历，查找二叉树中序遍历即为排序
     *
     * @param treeNode 节点
     */
    public void midOrderShow(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        midOrderShow(treeNode.getLeftChild());
        System.out.print(" " + treeNode.getData() + " ");
        midOrderShow(treeNode.getRightChild());
    }


    /**
     * 删除某一个数据的节点
     *
     * @param data 数据
     */
    public void delete(int data) {
        TreeNode node = searchNode(data);
        if (node == null) {
            return;
        }

        // 删除的节点既没有左孩子，也没有右孩子，则直接将父节点的孩子节点指向为null
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            if (node.getParent().getLeftChild() == node) {
                node.getParent().setLeftChild(null);
            } else if (node.getParent().getRightChild() == node) {
                node.getParent().setRightChild(null);
            }
        }

        // 删除的节点有左孩子没有右孩子，则直接将节点数据修改成左孩子
        if (node.getLeftChild() != null && node.getRightChild() == null) {
            node.setData(node.getLeftChild().getData());
            node.setRightChild(node.getLeftChild().getRightChild());
            node.setLeftChild(node.getLeftChild().getLeftChild());
        }

        // 删除的节点没有左孩子有右孩子，则直接将节点数据修改成右孩子
        if (node.getLeftChild() == null && node.getRightChild() != null) {
            node.setData(node.getRightChild().getData());
            node.setLeftChild(node.getRightChild().getLeftChild());
            node.setRightChild(node.getRightChild().getRightChild());
        }

        // 删除的节点既有左孩子又有右孩子，则将该节点补位为他的后继节点
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            // 找到后继节点
            TreeNode nextNode = getNextTreeNode(node);
            // 删除后继节点
            if (nextNode.getRightChild() == null) {
                // 后继节点没有右孩子，则直接删除
                nextNode.getParent().setLeftChild(null);
            } else {
                // 后继节点有右孩子，则修改数据并将nextNode的右孩子的父节点修改成nextNode的父节点
                nextNode.getRightChild().setParent(nextNode.getParent());
                if (nextNode.getRightChild().getData() < nextNode.getParent().getData()) {
                    nextNode.getParent().setLeftChild(nextNode.getRightChild());
                } else {
                    nextNode.getParent().setRightChild(nextNode.getRightChild());
                }
            }
            node.setData(nextNode.getData());
        }
    }


    /**
     * 获取某节点的后继节点
     * @param treeNode 当前节点
     * @return 后继节点
     */
    public TreeNode getNextTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode nextNode = null;
        // 判断是否存在右孩子
        if (treeNode.getRightChild() != null) {
            // 如果右孩子存在，则后继节点为右孩子最左边的后代节点
            nextNode = treeNode.getRightChild();
            while (nextNode.getLeftChild() != null) {
                nextNode = nextNode.getLeftChild();
            }
            return nextNode;
        }

        // 如果不存在右孩子

        if (treeNode.getParent().getLeftChild() == treeNode) {
            // 如果自身为父节点的左孩子，则后继节点为父节点
            return treeNode.getParent();
        } else {
            // 如果自身为父节点的右孩子，则后继节点为父节点的父节点，直至父节点为左孩子为止的那个节点的父节点，例如节点20
            nextNode = treeNode;
            while (nextNode == nextNode.getParent().getLeftChild()) {
                nextNode = nextNode.getParent();
            }
            return nextNode.getParent();
        }
    }



    /**
     * 搜索某个节点
     *
     * @param data 节点数据
     * @return 搜索到的节点
     */
    public TreeNode searchNode(int data) {
        TreeNode node = root;
        while (node != null && data != node.getData()) {
            if (data < node.getData()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return node;
    }


    public static void main(String[] args) {


        /**
         * 查找二叉树
         *                                22
         *                          10         26
         *                     8        18           33
         *                           17    20     30
         *                         12
         *
         */
        int[] dataArray = new int[]{22, 10, 18, 26, 33, 8, 17, 30, 12, 20};

        SearchBinaryTree searchBinaryTree = new SearchBinaryTree();
        // 添加节点
        for (int data : dataArray) {
            searchBinaryTree.put(data);
        }

        // 前序遍历输出
        searchBinaryTree.midOrderShow(searchBinaryTree.getRoot());
        System.out.println();

        // 删除节点后遍历
        searchBinaryTree.delete(26);
        searchBinaryTree.midOrderShow(searchBinaryTree.getRoot());

    }

}
