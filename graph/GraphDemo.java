package indi.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDemo {
    public static void main(String[] args) {
        int n = 5;
        String[] vertexName = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String v: vertexName){
            graph.insertVertex(v);
        }
        // B-C, A-C, A-B, B-E, B-D
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(1, 3, 1);
        graph.showGraph();
//        graph.dfs();
        graph.bfs();
    }
}

class Graph{
    private final ArrayList<String> vertexList;
    private final int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public String getName(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void insertVertex(String v){
        vertexList.add(v);
    }

    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    
    public void showGraph(){
        for (int[] row: edges){
            for (int col: row){
                System.err.printf("%d ", col);
            }
            System.err.println();
        }
    }

    public int getFirstAdjVex(int vertex){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[vertex][i] != 0){
                return i;
            }
        }
        return -1;
    }

    public int getNextAdjVex(int vertex){
        for (int i = vertex+1; i < vertexList.size(); i++) {
            if (edges[vertex][i] != 0){
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        for(int v = 0; v < vertexList.size(); v++){
            if (!isVisited[v]){
                dfs(v);
            }
        }
    }

    public void dfs(int vertex){
        System.out.print(getName(vertex)+"-->");
        isVisited[vertex] = true;
        for (int w = getFirstAdjVex(vertex); w != -1; w = getNextAdjVex(w)){
            if (!isVisited[w]){
                dfs(w);
            }
        }
    }

    public void bfs(){
        Queue<Integer> vexQueue = new LinkedList<>();
        for (int v = 0; v < vertexList.size(); v++){
            if (!isVisited[v]){
                System.out.print(getName(v)+"-->");
                isVisited[v] = true;
                vexQueue.offer(v);
                while (!vexQueue.isEmpty()){
                    Integer u = vexQueue.poll();
                    for (int w = getFirstAdjVex(u); w != -1; w = getNextAdjVex(w)){
                        if (!isVisited[w]){
                            System.out.print(getName(w)+"-->");
                            isVisited[w] = true;
                            vexQueue.offer(w);
                        }
                    }
                }
            }
        }
    }
}