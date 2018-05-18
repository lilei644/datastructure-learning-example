

/**
 * 图的最小生成树，kruskal算法
 */
public class GraphKruskal {

    private Edge[] edges;
    private int edgeSize;

    public GraphKruskal(int edgeSize) {
        this.edgeSize = edgeSize;
        edges = new Edge[edgeSize];
        createEdgeKruskal();
    }

    /**
     * 创建边的集合，从小到大
     */
    private void createEdgeKruskal() {
        Edge edge0 = new Edge(4, 7, 7);
        Edge edge1 = new Edge(2, 8, 8);
        Edge edge2 = new Edge(0, 1, 10);
        Edge edge3 = new Edge(0, 5, 11);
        Edge edge4 = new Edge(1, 8, 12);
        Edge edge5 = new Edge(3, 7, 16);
        Edge edge6 = new Edge(1, 6, 16);
        Edge edge7 = new Edge(5, 6, 17);
        Edge edge8 = new Edge(1, 2, 18);
        Edge edge9 = new Edge(6, 7, 19);
        Edge edge10 = new Edge(3, 4, 20);
        Edge edge11 = new Edge(3, 8, 21);
        Edge edge12 = new Edge(2, 3, 22);
        Edge edge13 = new Edge(3, 6, 24);
        Edge edge14 = new Edge(4, 5, 26);

        edges[0] = edge0;
        edges[1] = edge1;
        edges[2] = edge2;
        edges[3] = edge3;
        edges[4] = edge4;
        edges[5] = edge5;
        edges[6] = edge6;
        edges[7] = edge7;
        edges[8] = edge8;
        edges[9] = edge9;
        edges[10] = edge10;
        edges[11] = edge11;
        edges[12] = edge12;
        edges[13] = edge13;
        edges[14] = edge14;
    }


    /**
     * kruskal算法创建最小生成树
     */
    public void createMinSpanTreeKruskal() {
        // 定义一个一维数组，下标为连线的起点，值为连线的终点
        int[] parent = new int[edgeSize];
        for (int i = 0; i < edgeSize; i++) {
            parent[i] = 0;
        }

        int sum = 0;
        for (Edge edge : edges) {

            // 找到起点和终点在临时连线数组中的最后连接点
            int start = find(parent, edge.start);
            int end = find(parent, edge.end);

            // 通过起点和终点找到的最后连接点是否为同一个点，是则产生回环
            if (start != end) {

                // 没有产生回环则将临时数组中，起点为下标，终点为值
                parent[start] = end;
                System.out.println("访问到了节点：{" + start + "," + end + "}，权值：" + edge.weight);
                sum += edge.weight;
            }
        }
        System.out.println("最小生成树的权值总和：" + sum);
    }


    /**
     * 获取集合的最后节点
     */
    private int find(int parent[], int index) {
        while (parent[index] > 0) {
            index = parent[index];
        }
        return index;
    }


    /**
     * 连接顶点的边
     */
    class Edge {

        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {

        GraphKruskal graphKruskal = new GraphKruskal(15);
        graphKruskal.createMinSpanTreeKruskal();

    }

}


