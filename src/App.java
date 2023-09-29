import com.ritesh.datastructures.graph.Graph;
import com.ritesh.datastructures.tree.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        var app = new App();
        app.graph();
        app.tree();

    }

    private void graph() {
        var gr = new Graph(4);
        gr.print();

    }

    private void tree() {
        BinaryTree bt = new BinaryTree(3);
        for (int i = 4; i < 10; i++) {
            bt.addNode(i);
            System.out.println("added - " + i);
        }

        bt.preOrder(bt.rootNode);

    }
}
