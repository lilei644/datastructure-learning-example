
/**
 * 选择排序、冒泡排序
 */
public class SelectSort {

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
     * 选择排序：找到当前数中最大的数字，找到后与最后一个位置的数字交换位置，直至循环遍历完所有的数为止
     */
    private void selectSort() {

        for (int i = 0; i < array.length; i++) {

            // 定义最大数字的下标，默认为0
            int max = 0;
            for (int j = 0; j < array.length - i; j++) {

                // 找到比自己大的数就更新下标
                if (array[max] < array[j]) {
                    max = j;
                }
            }

            // 将找到最大的数与最后一个数字交换位置
            int temp = array[array.length - i - 1];
            array[array.length - i - 1] = array[max];
            array[max] = temp;
        }

        show();

    }


    /**
     * 冒泡排序：两两比较，大者交换位置，则每一圈比较最大的数就会冒到最后，循环直至遍历完所有
     */
    private void bubbleSort() {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        show();
    }


    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();

        // 选择排序
//        selectSort.selectSort();

        // 冒泡排序
        selectSort.bubbleSort();

    }

}
