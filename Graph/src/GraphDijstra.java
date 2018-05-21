/**
 * 图的最短路径，迪杰斯特拉(dijstra)算法
 */
public class GraphDijstra {

    private int vertexSize;                 // 顶点数量
    private int[][] matrix;                 // 存放数据的二维数组
    private static final int MAX_WEIGHT = 10000;    // 模拟代表无穷大
    private boolean[] isVisited;            // 存放被访问的节点


    public GraphDijstra(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        isVisited = new boolean[vertexSize];
    }


    /**
     * 图的最短路径(图中两个顶点的最短距离)，迪杰斯特拉算法
     * 算法思想：类似prim算法，定义一个一维数组，用来存储V0到某点的最短路径
     */
    public void shortestPathDijstra() {

        // 定义一维数组用来存储V0到每个点的最短路径，找到比原来更短的则直接覆盖
        int[] paths = new int[vertexSize];

        // 先将数组初始化
        System.arraycopy(matrix[0], 0, paths, 0, vertexSize);

        isVisited[0] = true;
        for (int i = 1; i < vertexSize; i++) {

            // 在已经存在的路径中找到一条未被访问且最短的路径
            int min = MAX_WEIGHT;
            int minIndex = -1;
            for (int j = 1; j < vertexSize; j++) {
                if (!isVisited[j] && paths[j] < min) {
                    min = paths[j];
                    minIndex = j;
                }
            }

            if (minIndex == -1) {
                continue;
            }
            isVisited[minIndex] = true;

            // 找到的最短路径节点的可使用边中，判断是否比已经存在的最短路径短，是则进行覆盖
            for (int k = 1; k < vertexSize; k++) {
                if (!isVisited[k] && (min + matrix[minIndex][k] < paths[k])) {
                    paths[k] = min + matrix[minIndex][k];
                }
            }
        }

        for (int i = 1; i < vertexSize; i++) {
            System.out.println("V0到V" + i + "的最短路径为：" + paths[i]);
        }
    }


    public static void main(String[] args) {

        GraphDijstra graph = new GraphDijstra(9);
        // 初始化图
        int[] graph0 = new int[]{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] graph1 = new int[]{1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] graph2 = new int[]{5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] graph3 = new int[]{MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] graph4 = new int[]{MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
        int[] graph5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
        int[] graph6 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
        int[] graph7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
        int[] graph8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 5, 4, 0};

        graph.matrix[0] = graph0;
        graph.matrix[1] = graph1;
        graph.matrix[2] = graph2;
        graph.matrix[3] = graph3;
        graph.matrix[4] = graph4;
        graph.matrix[5] = graph5;
        graph.matrix[6] = graph6;
        graph.matrix[7] = graph7;
        graph.matrix[8] = graph8;

        // 图的最短路径
        graph.shortestPathDijstra();

    }
}
