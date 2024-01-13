import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int to,cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

    }

    static int N,E;
    static ArrayList<ArrayList<Node>> graph;
    static PriorityQueue<Node> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int node_1 = Integer.parseInt(st.nextToken());
        int node_2 = Integer.parseInt(st.nextToken());
        que = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
        int max_1 = sol(1,node_1) + sol(node_1,node_2) + sol(node_2, N);
        int max_2 = sol(1,node_2) + sol(node_2,node_1) + sol(node_1, N);
        int max = Math.min(max_1,max_2);

        if(max >0)  System.out.println(max);
        else System.out.println(-1);


    }
    public static int sol(int start, int end){

        int[] dist = new int[N+1];
        boolean[] check = new boolean[N+1];
        for (int i = 0; i <=N ; i++) {
            dist[i] = 1_000_000;
        }
        dist[start] = 0;
        que.add(new Node(start, 0));
        while (!que.isEmpty()){
            Node node = que.poll();
            int to = node.to;

            if(check[to]) continue;
            else check[to] = true;
            for (Node nod: graph.get(to)) {
                if(dist[nod.to] >= dist[to] + nod.cost){
                    dist[nod.to] = dist[to] + nod.cost;
                    que.add(new Node(nod.to, dist[nod.to]));
                }
            }
        }
        if (dist[end] == 1_000_000){
            return -3_000_000;
        }
        return dist[end];
    }
}
