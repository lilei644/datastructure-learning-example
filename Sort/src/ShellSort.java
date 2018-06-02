
/**
 * 希尔排序，非稳定排序算法
 */
public class ShellSort {

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
     * 希尔排序：定义一个增量m，比较的数字集合总数为n，则将集合分成n/m组，每组进行插入排序
     * 随后m递减，多次比较之后就可得出排序后的集合
     */
    private void shellSort() {
        int m = array.length;
        while (true) {
            // 本次增量的变化方式为 m/2
            m = m / 2;
            // 分组后的数组下标为n/m的摩
            for (int i = 0; i < m; i++) {
                // 分组后数组的数据为原数组下标摩为i的数
                for (int j = i + m; j < array.length; j += m) {
                    // 每组内部进行插入排序（此处使用直接插入排序方式，也可使用二分法插入）
                    int temp = array[j];
                    int k;
                    // 在前面已经遍历过的数字中比较若小于则往后移
                    for (k = j - m; k >= i; k -=m) {
                        if (temp < array[k]) {
                            array[k + m] = array[k];
                        } else {
                            break;
                        }
                    }
                    array[k + m] = temp;
                }
            }

            if (m == 1) {
                break;
            }
        }
        show();
    }


    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort();
    }
}
