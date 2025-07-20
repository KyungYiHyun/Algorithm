import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
	int node;
	int cost;
	
	Node(int node, int cost){
		this.node  = node;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}

}


public class Main {
	static ArrayList<Node>[] graph;
	static int[] distance;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
	    graph = new ArrayList[n + 1];
	    distance = new int[n + 1];
	    
	    for(int i = 0; i < n + 1; i++) {
	    	graph[i] = new ArrayList<>();
	    	distance[i] = Integer.MAX_VALUE;
	    }
	    
	    
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		int ans = dijkstra(1);
		System.out.print(ans);
	}
	
	private static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int o = node.node;
			int c = node.cost;
			
			
			if (distance[o] < c){continue;}
			
			for (Node temp : graph[o]) {
				if (distance[temp.node] > distance[o] + temp.cost) {
					distance[temp.node] = distance[o] + temp.cost;
					pq.offer(new Node(temp.node,distance[o] + temp.cost));
				}
			}
			
		}
		return distance[n];
	
}
}

