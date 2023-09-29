import com.ritesh.datastructures.graph.Graph;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

           var app = new App();
        app.graph();

    }
    private void graph() {
        var gr =  new Graph(4);
        gr.print();
        
    }
}
