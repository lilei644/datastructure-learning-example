/**
 * 堆排序
 */
public class HeapSort {

    private int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};


    /**
     * 输出数组
     */
    private void show() {
        for (int number : array) {
            System.out.println(number);
        }
    }


    /**
     * 堆排序，将数组构建成大堆二叉树，即父节点比叶子节点大的二叉树
     * 从小到大排序的话则每次直接将根节点放置到最后一位，循环往复直至遍历完所有为止
     */
    private void heapSort() {

        // 先构建一次大堆二叉树，做一个基本的排序
        buildMaxHeap();

        for (int i = array.length - 1; i > 0; i--) {
            // 将最大值与最后一个位置的数交换
            exchangeValue(0, i);

            // 重新构建大堆二叉树，从0开始往下检测是否需要重新构建大堆
            maxHeap(i, 0);
        }

        show();

    }


    /**
     * 构建大堆二叉树，从最底层开始往上构建，最底层的父节点则是总长度的一半
     */
    private void buildMaxHeap() {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeap(length, i);
        }
    }


    /**
     * 构建大堆二叉树的节点，若修改了顺序，则递归重新构建下一层
     *
     * @param length 构建数据数组长度
     * @param node 构建堆排序的父节点
     */
    private void maxHeap(int length, int node) {
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        // 找到一个节点和他的孩子节点中的最大值下标
        int maxIndex = node;
        if (left < length && array[left] > array[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && array[right] > array[maxIndex]) {
            maxIndex = right;
        }

        // 如果不是父节点最大，则跟最大的孩子节点交换
        if (maxIndex != node) {
            exchangeValue(node, maxIndex);
            maxHeap(length, maxIndex);
        }
    }



    /**
     * 交换两个下标的数值
     *
     * @param first  第一个下标
     * @param second 第二个下标
     */
    private void exchangeValue(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }


    public static void main(String[] agrs) {
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort();
    }

}
