

/**
 * 插入排序，分直接插入排序和二分法插入排序
 */
public class InsertSort {

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
     * 直接插入排序：从1开始遍历数组，每个数字都在前面已经遍历的数字中插入
     * 从小到大排序的话碰到比它大的则往后移，直到比它小为止
     */
    private void insertSort() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            // 在前面已经遍历过的数字中比较若小于则往后移
            for (j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
        show();
    }


    /**
     * 二分插入排序：从1开始遍历，已经遍历的数组中头是left，尾是right，遍历到的数字与中间的数字对比
     * 若小于中间的数字则right变更成中间数字前面的一个数字，反之则变更left
     * 直至最后left>right则插入
     */
    private void binaryInsertSort() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int left = 0, right = i - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 将遍历到比他大的数字全部往后移一位
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            array[left] = temp;
        }
        show();
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();

        // 直接插入排序
//        insertSort.insertSort();

        // 二分插入排序
        insertSort.binaryInsertSort();

    }


}
