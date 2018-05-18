import java.util.LinkedList;

/**
 * 图，图的构建，深度优先遍历，广度优先遍历，prim算法最小生成树
 */
public class Graph {

    private int vertexSize;                 // 顶点数量
    private int[][] matrix;                 // 存放数据的二维数组
    private static final int MAX_WEIGHT = Integer.MAX_VALUE;        // 无穷大
    private boolean[] isVisited;            // 存放被访问的节点


    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        isVisited = new boolean[vertexSize];
    }


    /**
     * 获取某个顶点的出度
     *
     * @param index 顶点序号
     * @return 出度
     */
    public int getOutDegree(int index) {
        int degree = 0;
        for (int i = 0; i < vertexSize; i++) {
            int weight = matrix[index][i];
            if (weight > 0 && weight < MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * 获取某个顶点的入度
     *
     * @param index 顶点序号
     * @return 入度
     */
    public int getInDegree(int index) {
        int degree = 0;
        for (int i = 0; i < vertexSize; i++) {
            int weight = matrix[i][index];
            if (weight > 0 && weight < MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }


    /**
     * 获取某顶点的第一个邻接点的权值
     *
     * @param index 顶点
     * @return 第一个邻接点
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexSize; i++) {
            int weight = matrix[index][i];
            if (weight > 0 && weight < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 获取顶点v，从index开始的后续邻接顶点
     *
     * @param v     顶点v
     * @param index 开始的邻接点
     * @return 后续点
     */
    public int getNextNeighbor(int v, int index) {
        for (int i = index + 1; i < vertexSize; i++) {
            int weight = matrix[v][i];
            if (weight > 0 && weight < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 图的深度优先遍历
     *
     * @param index 遍历的顶点
     */
    public void depthFirstSearch(int index) {
        isVisited[index] = true;
        int w = getFirstNeighbor(index);
        while (w != -1) {
            if (!isVisited[w]) {
                System.out.println("访问到了节点：" + w + "，权值：" + matrix[index][w]);
                depthFirstSearch(w);
            }
            w = getNextNeighbor(index, w);
        }
    }


    /**
     * 图的广度优先遍历，利用队列存储要遍历的起始顶点
     *
     * @param index 遍历开始的顶点
     */
    public void broadFirstSearch(int index) {
        isVisited[index] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println("访问到了节点：" + index);
        queue.add(index);

        while (!queue.isEmpty()) {
            int next = queue.removeFirst();
            int w = getFirstNeighbor(next);
            while (w != -1) {
                if (!isVisited[w]) {
                    queue.add(w);
                    isVisited[w] = true;
                    System.out.println("访问到了节点：" + w + "，权值：" + matrix[next][w]);
                }
                w = getNextNeighbor(next, w);
            }
        }
    }


    /**
     * 最小生成树，普里姆(prim)算法
     */
    public void createMinSpanTreePrim() {
        // 定义一维数组，存放用于比较最小权值的顶点权值，0代表已经比较过
        int[] lowcost = new int[vertexSize];

        // 初始化数组为第一个顶点的权值
        System.arraycopy(matrix[0], 0, lowcost, 0, vertexSize);

        int sum = 0;
        // 循环比较
        for (int i = 0; i < vertexSize; i++) {

            // 先比较找出最小的权值节点
            int min = -1;
            for (int j = 0; j < vertexSize; j++) {
                if (lowcost[j] > 0 && lowcost[j] < MAX_WEIGHT) {
                    if (min == -1 || lowcost[min] > lowcost[j]) {
                        min = j;
                    }
                }
            }

            // 判断是否全部为0，找不到最小值
            if (min == -1) {
                break;
            }

            System.out.println("访问到了节点：" + min + "，权值：" + lowcost[min]);
            sum += lowcost[min];

            // 将当前节点的值修改成0
            lowcost[min] = 0;

            // 将存放最小权值的数组与下一个节点的所有连接点对比，找出最小权值
            for (int j = 0; j < vertexSize; j++) {
                if (matrix[min][j] < lowcost[j]) {
                    lowcost[j] = matrix[min][j];
                }
            }
        }
        System.out.println("最小生成树的权值总和：" + sum);
    }


    public static void main(String[] args) {

        Graph graph = new Graph(9);
        // 初始化图
        int[] graph0 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] graph1 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] graph2 = new int[]{MAX_WEIGHT, 18, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] graph3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
        int[] graph4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] graph5 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] graph6 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        int[] graph7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] graph8 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graph.matrix[0] = graph0;
        graph.matrix[1] = graph1;
        graph.matrix[2] = graph2;
        graph.matrix[3] = graph3;
        graph.matrix[4] = graph4;
        graph.matrix[5] = graph5;
        graph.matrix[6] = graph6;
        graph.matrix[7] = graph7;
        graph.matrix[8] = graph8;


        // 获取入度
        int outDegree = graph.getOutDegree(1);
        int inDegree = graph.getInDegree(1);
        System.out.println("出度：" + outDegree + "，入度：" + inDegree);

        // 深度优先遍历
        graph.depthFirstSearch(0);
        // 广度优先遍历
        graph.broadFirstSearch(0);

        // 普里姆算法获取最小生成树
        graph.createMinSpanTreePrim();

    }


}
