import java.sql.Statement;
import java.util.Stack;

public class Main7 {

    public static void main(String[] args) {
//        testGraph();
//        testDfs();
 //       testBfs();
        homework();
    }



    private static void homework(){
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула");
        graph.addEdge("Москва","Рязань");
        graph.addEdge("Москва","Калуга");

        graph.addEdge("Тула","Липецк");
        graph.addEdge("Липецк","Воронеж");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Саратов","Воронеж");
        graph.addEdge("Калуга","Орел");
        graph.addEdge("Орел","Курск");
        graph.addEdge("Курск","Воронеж");

        Stack<String> result = graph.shortestPath("Москва","Воронеж");
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
            sb.append(" -> ");
        }
        sb.delete(sb.length()-4,sb.length());
        System.out.println(sb);




    }

    private static void testBfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }

    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

    private static void testGraph() {
        Graph graph = new Graph(5);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdges("A", "B", "C");
        graph.addEdges("B", "A", "C", "D");
        graph.addEdges("C", "A", "B", "D");
        graph.addEdges("D", "B", "C");

        graph.display();
    }
}