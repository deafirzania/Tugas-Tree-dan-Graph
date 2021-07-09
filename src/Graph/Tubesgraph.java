package Graph;


class Vertex {

    public String label;
    public boolean wasVisited;

    public Vertex(String lab) {
        label = lab;
        wasVisited = false;
    }
}

class Tubesgraph {

    private final int MAXSIZE = 10;
    private Vertex vertexList[];
    private int adjList[][];
    private int nVerts;
    private String sortedArray[];


    public Tubesgraph() {
        vertexList = new Vertex[MAXSIZE];
        adjList = new int[MAXSIZE][MAXSIZE];
        nVerts = 0;
        sortedArray = new String[MAXSIZE];
    }

    public void addVertex(String lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjList[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void topologi() {
        int orig_nVerts = nVerts;

        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("Error : graph has cycle");
                return;
            }

            sortedArray[nVerts - 1] = vertexList[currentVertex].label;

            deleteVertex(currentVertex);
        }
        System.out.println("topolofically sorted order : ");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.println(sortedArray[i]);
        }
        System.out.println("");
    }

    public int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int cols = 0; cols < nVerts; cols++) {
                if (adjList[row][cols] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return -1;
    }

    public void deleteVertex(int delVertex) {
        if (delVertex != nVerts - 1) {
            for (int i = delVertex; i < nVerts - 1; i++) {
                vertexList[i] = vertexList[i + 1];
            }

            for (int row = delVertex; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            for (int cols = delVertex; cols < nVerts - 1; cols++) {
                moveColsLeft(cols, nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int cols = 0; cols < length; cols++) {
            adjList[row][cols] = adjList[row + 1][cols];
        }
    }

    private void moveColsLeft(int cols, int length) {
        for (int row = 0; row < length; row++) {
            adjList[row][cols] = adjList[row][cols + 1];
        }

    }

    public void display() {
        System.out.println("  1 2 3 4 5 6 7");
        System.out.println("1 1 0 1 0 0 0 0");
        System.out.println("2 0 1 1 0 0 0 0");
        System.out.println("3 0 0 0 1 0 0 0");
        System.out.println("4 0 0 0 0 1 0 1");
        System.out.println("5 0 1 0 0 0 0 0");
        System.out.println("6 0 0 1 0 0 0 0");
        System.out.println("7 1 0 0 0 0 1 0");
    }
}
