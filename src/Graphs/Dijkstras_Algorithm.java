package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class DijkstrasAlgorithm {

    static HashMap<Integer, String> map = new HashMap<>();

    static int resultDistance;
    static ArrayList<String> resultPath = new ArrayList<String>();
 
    private static final int NO_PARENT = -1;
 
    private static void dijkstra(int[][] adjacencyMatrix, int startVertex, int endVertex)
    {
        int nVertices = adjacencyMatrix[0].length;
 
        int[] shortestDistances = new int[nVertices];
 
        boolean[] added = new boolean[nVertices];
 
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
         
        shortestDistances[startVertex] = 0;
 
        // Parent array to store shortest path tree
        int[] parents = new int[nVertices];
 
        // The starting vertex does not have a parent
        parents[startVertex] = NO_PARENT;
 
        // Find shortest path for all vertices
        for (int i = 1; i < nVertices; i++)
        {
 
            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.

            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
 
            // Mark the picked vertex as
            // processed

            added[nearestVertex] = true;
 
            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.

            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                 
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }
 
        printSolution(startVertex, endVertex, shortestDistances, parents);
    }
 
    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private static void printSolution(int startVertex, int endVertex, int[] distances, int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");
         
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            if (vertexIndex != startVertex && vertexIndex==endVertex)
            {
                System.out.print("\n" + map.get(startVertex) + " -> ");
                System.out.print(map.get(vertexIndex) + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }
 
    // Function to print shortest path
    // from source to currentVertex
    // using parents array
    private static void printPath(int currentVertex, int[] parents)
    {
         
        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(map.get(currentVertex) + " ");
        result.add(map.get(currentVertex));
    }
 
        // Driver Code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int begin = -1;
        int over = -1;

        map.put(0, "DEL");
        map.put(1, "BOM");
        map.put(2, "BLR");
        map.put(3, "HYD");
        map.put(4, "CCU");
        map.put(5, "MAA");
        map.put(6, "AMD");
        map.put(7, "GOI");
        map.put(8, "PAT");
        map.put(9, "COK");
        map.put(10, "LKO");
        map.put(11, "GAU");
        map.put(12, "PNQ");
        map.put(13, "JAI");
        map.put(14, "SXR");
        map.put(15, "BBI");
        map.put(16, "IXB");
        map.put(17, "VNS");
        map.put(18, "IXC");
        map.put(19, "IXR");

        int[][] cost = {{0,0,7781,9688,8925,8467,9611,0,9611,0,0,0,0,0,0,0,0,0,0,0}
                        {0,0,0,9937,0,0,0,6475,0,0,0,0,0,7939,16419,10502,0,0,0,0}
                        {12784,0,0,0,0,6307,0,10481,0,0,12210,6490,0,0,0,0,0,0,0,0}
                        {9960,0,0,0,0,0,9843,0,0,9965,0,0,0,0,0,0,0,0,12420,13640}
                        {0,0,0,0,0,9031,12817,0,0,0,0,0,16265,10567,18289,0,0,0,0,0}
                        {12613,0,6356,0,0,0,0,0,11461,0,0,11996,9060,0,0,0,0,0,0,0}
                        {10320,0,0,0,0,11934,0,0,0,0,0,15924,0,7262,0,0,0,0,10973,0}
                        {12937,5718,6984,0,13388,9354,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                        {9777,0,10651,0,0,0,0,0,0,0,4082,0,10662,8033,0,0,0,0,0,0}
                        {11142,10539,5560,8800,0,8266,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                        {0,0,0,0,0,0,9049,12349,0,0,0,9217,10391,7354,0,0,0,0,0,0}
                        {9294,11588,12688,0,0,0,0,0,0,0,0,0,11133,13430,0,0,0,0,0,0}
                        {11253,0,0,0,0,9875,0,0,0,0,0,10732,0,0,0,0,0,0,11748,9222}
                        {0,0,0,0,0,0,7090,7560,0,0,0,13430,9747,0,0,0,0,13430,0,0}
                        {12469,21973,23258,31659,0,0,0,0,0,0,11396,0,0,0,0,0,0,0,0,0}
                        {0,0,10143,0,8558,0,0,0,7620,0,0,0,10671,0,0,0,0,0,0,9731}
                        {9870,17628,13772,0,9742,16066,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                        {10218,0,13202,12525,7875,15629,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                        {0,0,0,0,20199,13950,0,12856,0,0,7915,0,0,9383,0,0,0,0,0,0}
                        {10834,0,10270,0,4645,0,0,0,0,13167,5335,0,0,0,0,0,0,0,0,0}
        }

        int[][] duration = {{0,130,170,150,150,185,0,160,0,0,0,0,0,0,0,0,0,0,0,0}
                            {0,0,105,0,0,0,70,0,0,0,0,0,0,110,170,135,0,0,0,0}
                            {155,0,0,0,0,90,0,0,160,0,0,175,90,0,0,0,0,0,0,0}
                            {135,0,0,0,0,0,95,0,0,0,130,0,0,0,0,0,0,120,150,0}
                            {0,0,0,0,0,145,160,0,0,0,0,0,165,255,285,0,0,0,0,0}
                            {165,0,55,0,0,0,0,0,155,0,0,180,105,0,0,0,0,0,0,0}
                            {95,0,0,0,0,125,0,0,0,0,0,250,0,70,0,0,0,0,110,0}
                            {160,80,70,0,155,90,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                            {110,0,155,0,0,0,0,0,0,0,55,0,125,130,0,0,0,0,0,0}
                            {180,125,85,95,0,75,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                            {0,0,0,0,0,0,110,150,0,0,0,120,115,95,0,0,0,0,0,0}
                            {165,160,195,0,0,0,0,0,0,0,0,0,195,165,0,0,0,0,0,0}
                            {130,0,0,0,0,105,0,0,0,0,0,200,0,0,0,0,0,0,155,140}
                            {0,0,0,0,0,0,80,130,0,0,0,150,95,0,0,0,0,105,0,0}
                            {95,150,285,175,0,0,0,0,0,0,245,0,0,0,0,0,0,0,0,0}
                            {0,0,125,0,60,0,0,0,90,0,0,0,105,0,0,0,0,0,0,80}
                            {135,180,170,0,70,160,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                            {90,0,140,115,80,145,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                            {0,0,0,0,150,200,0,140,0,0,75,0,0,80,0,0,0,0,0,0}
                            {105,0,135,0,80,0,0,0,0,240,145,0,0,0,0,0,0,0,0,0}
        }
        
        int[][] distance = {{0,1138,1709,1267,1312,1760,0,1504,0,0,0,0,0,0,0,0,0,0,0,0}
                            {0,0,834,0,0,0,444,0,0,0,0,0,0,911,1667,1361,0,0,0,0}
                            {1709,0,0,0,0,267,0,0,1579,0,0,2039,722,0,0,0,0,0,0,0}
                            {1267,0,0,0,0,0,887,0,0,0,1089,0,0,0,0,0,0,1022,1503,0}
                            {0,0,0,0,0,1385,1619,0,0,0,0,0,1577,1356,1834,0,0,0,0,0}
                            {1760,0,267,0,0,0,0,0,1492,0,0,1883,9060,0,0,0,0,0,0,0}
                            {756,0,0,0,0,1374,0,0,0,0,0,1943,0,525,0,0,0,0,939,0}
                            {1504,424,482,0,1734,733,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                            {856,0,1579,0,0,0,0,0,0,0,438,0,1388,935,0,0,0,0,0,0}
                            {2048,1063,367,455,0,512,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                             {0,0,0,0,0,0,927,1461,0,0,0,1067,1156,503,0,0,0,0,0,0}
                             {1455,2070,2039,0,0,0,0,0,0,0,0,0,1997,1571,0,0,0,0,0,0}
                             {1156,0,0,0,0,912,0,0,0,0,0,517,0,0,0,0,0,0,1375,1296}
                             {0,0,0,0,0,0,1356,1288,0,0,0,1571,936,0,0,0,0,719,0,0}
                            {642,1667,2330,1898,0,0,0,0,0,0,994,0,0,0,0,0,0,0,0,0}
                            {0,0,1165,0,381,0,0,0,599,0,0,0,1261,0,0,0,0,0,0,345}
                            {1125,1792,1863,0,447,1743,0,0,0,0,0,0,0,0,0,0,0,0,,20}
                            {666,0,1465,1022,7875,1414,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                            {0,0,0,0,1460,1996,0,1726,0,0,590,0,0,438,0,0,0,0,0,0}
                            {1007,0,1381,0,328,0,0,0,0,1743,588,0,0,0,0,0,0,0,0,0}
} 
        
        System.out.println("Enter the Source: ");
        String start = sc.next();
        System.out.println("Enter the Destination: ");
        String end = sc.next();

        for(int i=0; i<20; i++) {
            if(map.get(i).equals(start)) {
                begin = i;
            }
        }

        for(int i=0; i<20; i++) {
            if(map.get(i).equals(end)) {
                over = i;
            }
        }

        if(begin!=-1 && over!=-1) {
            dijkstra(cost, begin, over);
            
            System.out.println("\nThe final sequence: " + result);
        }
        else {
            System.out.println("Invlid Entry");
        }
    }
}
