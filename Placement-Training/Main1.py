import java.util.*;

class Main {

    LinkedList<Integer> adj[];
    int v;

    public Main(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {

        boolean visited[] = new boolean[v];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {

            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {

                int n = i.next();

                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Main g = new Main(n);

        int a, b;

        while (true) {

            a = sc.nextInt();
            b = sc.nextInt();

            if (a == -1 || b == -1)
                break;

            g.addEdge(a, b);
        }

        if (n == 0)
            System.out.println("Graph Doesn't exist");
        else {
            System.out.print("BFS: ");
            g.BFS(0);
        }

        sc.close();
    }
}