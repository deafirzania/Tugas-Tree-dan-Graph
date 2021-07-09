package Graph;

public class Main {

    public static void main(String[] args) {
        Tubesgraph g = new Tubesgraph();
        g.addVertex("Bagun dari tidur sendiri");
        g.addVertex("Berangkat kuliah sendiri");
        g.addVertex("Janjian pulang bareng");
        g.addVertex("Singgah makan siang");
        g.addVertex("Nonton bioskop");
        g.addVertex("Jalan bareng di mall");
        g.addVertex("Sarapan pagi sendiri");
        g.addVertex("Mandi pagi sendiri");
        
        g.addEdge(7, 0);
        g.addEdge(6, 1);
        g.addEdge(4, 6);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(1,7);
        g.addEdge(5, 6);
        g.addEdge(4, 5);

        g.topologi();

        System.out.println();
        System.out.println("Adjacency matrix");
        g.display();

    }

}