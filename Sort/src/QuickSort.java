import java.util.Stack;

/**
 * 快速排序
 */
public class QuickSort {

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
     * 快速排序：找到某个点排序之后它应该所在的位置
     */
    private void quickSort() {
        quickSort(0, array.length - 1);
        show();
    }


    /**
     * 快速排序(非递归)：自己定义栈，模拟递归操作。虽然解决了内存溢出的问题，但是自定义栈的入栈和出栈操作较费时
     */
    private void quickSortStack() {

        // 定义一个栈，用于存放需要遍历的基数点
        Stack<Integer> stack = new Stack<>();

        // 先获取一次基数的位置，压入栈中
        int startLow = 0;
        int startHigh = array.length - 1;
        int startMid = getMiddle(startLow, startHigh);
        stack.push(startLow);
        stack.push(startMid - 1);
        stack.push(startMid + 1);
        stack.push(startHigh);

        // 由于栈是先进后出，刚好满足快速排序递归方式的这种由内往外的遍历方式
        while (!stack.isEmpty()) {
            int low,high, mid;
            high = stack.pop();
            low = stack.pop();
            mid = getMiddle(low, high);

            // 对原基数点进行再次查找，找到新的基数位置后继续压入栈中
            if (low < mid - 1) {
                stack.push(low);
                stack.push(mid - 1);
            }

            if (high > mid + 1) {
                stack.push(mid + 1);
                stack.push(high);
            }
        }
        show();
    }



    /**
     * 找到开始和结束位置之间以第一个数为基数，这个基数应该所在的位置
     * 找到之后以基数为中心点拆分成前后两段，依次递归进行本操作，直至最后遍历完所有基数为止
     *
     * @param low  开始的点下标
     * @param high 结束的点下标
     */
    private void quickSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = getMiddle(low, high);
        quickSort(low, mid - 1);
        quickSort(mid + 1, high);
    }

    /**
     * 通过比较获取最开始基数最后所在的位置
     *
     * @param low  最开始的位置
     * @param high 结束的位置
     * @return 最后基数所在的位置
     */
    private int getMiddle(int low, int high) {
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        // 快速排序
        quickSort.quickSort();

//        // 非递归的快速排序
//        quickSort.quickSortStack();
    }


}
