import java.util.Stack;

/**
 * 图的拓扑排序
 */
public class GraphTopologic {

    private int numVertexes;
    private VertexNode[] adjList;//邻接顶点的一维数组

    public GraphTopologic(int numVertexes) {
        this.numVertexes = numVertexes;
    }

    private void createGraph() {
        VertexNode node0 = new VertexNode(0, "v0");
        VertexNode node1 = new VertexNode(0, "v1");
        VertexNode node2 = new VertexNode(2, "v2");
        VertexNode node3 = new VertexNode(0, "v3");
        VertexNode node4 = new VertexNode(2, "v4");
        VertexNode node5 = new VertexNode(3, "v5");
        VertexNode node6 = new VertexNode(1, "v6");
        VertexNode node7 = new VertexNode(2, "v7");
        VertexNode node8 = new VertexNode(2, "v8");
        VertexNode node9 = new VertexNode(1, "v9");
        VertexNode node10 = new VertexNode(1, "v10");
        VertexNode node11 = new VertexNode(2, "v11");
        VertexNode node12 = new VertexNode(1, "v12");
        VertexNode node13 = new VertexNode(2, "v13");
        adjList = new VertexNode[numVertexes];
        adjList[0] = node0;
        adjList[1] = node1;
        adjList[2] = node2;
        adjList[3] = node3;
        adjList[4] = node4;
        adjList[5] = node5;
        adjList[6] = node6;
        adjList[7] = node7;
        adjList[8] = node8;
        adjList[9] = node9;
        adjList[10] = node10;
        adjList[11] = node11;
        adjList[12] = node12;
        adjList[13] = node13;
        node0.firstEdge = new EdgeNode(11);
        node0.firstEdge.next = new EdgeNode(5);
        node0.firstEdge.next.next = new EdgeNode(4);
        node1.firstEdge = new EdgeNode(8);
        node1.firstEdge.next = new EdgeNode(4);
        node1.firstEdge.next.next = new EdgeNode(2);
        node2.firstEdge = new EdgeNode(9);
        node2.firstEdge.next = new EdgeNode(6);
        node2.firstEdge.next.next = new EdgeNode(5);
        node3.firstEdge = new EdgeNode(13);
        node3.firstEdge.next = new EdgeNode(2);
        node4.firstEdge = new EdgeNode(7);
        node5.firstEdge = new EdgeNode(12);
        node5.firstEdge.next = new EdgeNode(8);
        node6.firstEdge = new EdgeNode(5);
        node8.firstEdge = new EdgeNode(7);
        node9.firstEdge = new EdgeNode(11);
        node9.firstEdge.next = new EdgeNode(10);
        node10.firstEdge = new EdgeNode(13);
        node12.firstEdge = new EdgeNode(9);
    }


    //边表顶点
    class EdgeNode {
        private int adjVert;    // 顶点下表
        private EdgeNode next;  // 后继节点

        public EdgeNode(int adjVert) {
            this.adjVert = adjVert;
        }
    }

    //邻接顶点
    class VertexNode {
        private int in;         // 入度
        private String data;    // 数据
        private EdgeNode firstEdge;

        public VertexNode(int in, String data) {
            this.in = in;
            this.data = data;
        }
    }


    /**
     * 拓扑排序
     * 思路：定义一个栈，存放入度为0的节点，入度为0则代表可以执行，执行之后则出度的那个节点就减少一个入度，循环直至栈为空
     */
    private void topologicaSort() {
        Stack<Integer> stack = new Stack<>();

        // 先将入度为0 的节点压入栈中
        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i].in == 0) {
                stack.push(i);
            }
        }

        int count = 0;
        // 循环出栈输出，直至栈为空
        while (!stack.isEmpty()) {
            int index = stack.pop();
            System.out.println("顶点：" + adjList[index].data);
            count++;
            for (EdgeNode edgeNode = adjList[index].firstEdge; edgeNode != null; edgeNode = edgeNode.next) {
                if (--adjList[edgeNode.adjVert].in == 0) {
                    // 若输出之后的顶点入度也没0，则压入栈中
                    stack.push(edgeNode.adjVert);
                }
            }
        }

        if (count != numVertexes) {
            System.out.println("拓扑排序失败！！！！");
        }
    }


    public static void main(String[] args) {

        GraphTopologic graphTopologic = new GraphTopologic(14);
        graphTopologic.createGraph();

        // 拓扑排序
        graphTopologic.topologicaSort();


    }


}
