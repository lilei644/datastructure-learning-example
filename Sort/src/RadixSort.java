/**
 * 基数排序，又叫桶排序
 */
public class RadixSort {


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
     * 基数排序，先按个位将所有数字按照个位的值放入0-9的二维数组中，依次取出之后再按十位
     * 如此循环直至个十百千等等所有位数遍历完为止
     */
    private void radixSort() {

        // 定义二位数组用来存储每个基数以及基数下的数值
        int[][] temp;

        // 定义一维数组记录基数下保存了几位
        int[] position;

        int radix = 1;

        while (true) {
            position = new int[10];
            temp = new int[10][array.length];

            for (int i = 0; i < array.length; i++) {
                int value = (array[i] / radix) % 10;
                temp[value][position[value]] = array[i];
                position[value]++;
            }

            // 判断是否所有的数值都在0位上，都在0位上则表示排序完成
            if (position[0] == array.length) {
                break;
            }

            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < position[i]; j++) {
                    array[index] = temp[i][j];
                    index++;
                }
            }

            radix = radix * 10;
        }
        show();
    }


    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort();
    }


}
