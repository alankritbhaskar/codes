import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class dijkstraAndPrims{

    public static class Edge{
        int v = 0;
        int w = 0;

        public Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph,int u,int v,int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void display(ArrayList<Edge>[] graph,int N){
        for(int i=0;i<N;i++){
            System.out.print(i + " -> ");
            for(Edge e: graph[i]){
                System.out.print("(" + e.v + ", " + e.w + "), ");
            }

            System.out.println();
        }
    }

    // PRIMS ALGO.-- finds mst in positive weighted undirected graph


    public class primsPair{
        int par = 0;
        int vtx = 0;
        int w = 0;

        primsPair(int vtx,int par,int w){
            this.par = par;
            this.vtx = vtx;
            this.w = w;
        }
    }

    // Implementation 1-- BFS METHOD without distance array   O( (E+V)log E )

    public static void primsAlgo1(ArrayList<Edge>[] graph,int n,int src){
        ArrayList<Edge>[] ngraph = new ArrayList[n];
        
        for(int i=0;i<n;i++) 
        ngraph[i] = new ArrayList<>();

        boolean[] vis = new boolean[n];
        
        PriorityQueue<primsPair> pq = new PriorityQueue<>((a,b)->{
            return a.w - b.w; // this - other
        });
        pq.add(new primsPair(src,-1,0));

        int edgeCount=0;

        while(edgeCount<=n-1){
            primsPair pair=pq.remove();// gives the smallest edge based on weight in the priority que
            if(vis[pair.vtx]){
                continue;// cycle check
            }

            //MST graph created here...............
            if(pair.par!=-1)
            {
                addEdge(ngraph,pair.par,pair.vtx,pair.w);
                edgeCount++;
            }       
            vis[pair.vtx]=true;
            for(Edge e:graph[pair.vtx]){
                if(!vis[e.v])
                pq.add(new primsPair(e.v,pair.vtx,e.w));
            }
        }
        display(ngraph);
    }

    //Implementation -2:- O( (V+E)log V )
    // Using 2 arrays(distance & visited array):-

    public static void primsAlgo2(ArrayList<Edge> graph[],int n){
        ArrayList<Edge> ngraphs[]=new ArrayList<>[n];

        for(int i=0;i<n;i++)
        ngraphs[i]=new ArrayList<>();

        int vis[]=new int[n];
        int dis[]=new int[n];
        int par[]=new int[n];

        Arrays.fill(dis,(int)1e8);
        Arrays.fill(par,-1);

        PriorityQueue<primsPair> pq=new PriorityQueue<>((a,b)->{
            return a.w-b.w;
        });
        pq.add(new primsPair(0,-1,0));
        dis[0]=0;
        int edgeCount=0;
        while(edgeCount<=n-1){
            primsPair pair=pq.remove();
            if(vis[pair.vtx]) continue;
            if(pair.par!=-1){
                addEdge(ngraphs,pair.par,pair.vtx,pair.w);
                edgeCount++;
            }
            vis[pair.vtx]=true;
            for(Edge e: graph[pair.vtx]){
                if(!vis[e.v] && e.w<dis[e.v]){
                    dis[e.v]=e.w;
                    pq.add(new primsPair(e.v,pair.vtx,e.w));
                }
            }
        }
        display(ngraphs);
    }


    //Dijkstra Algorithm(Single Source Shortest Path):-

    //Time- complexity:-
    /* Standard--- O( (V+E)log V ) byy writing our own priority queue to perform update operation

       Using optimized BFS variant--- O( (V+E)log E )
    */

    //1. Works for positive edge weights only.
    //2. Works on directed or undirected graph.

    public class dijkstraPair{

        int vtx=0;
        int par=0;
        int wsf=0;

        dijkstraPair(int vtx,int par,int wsf){
            this.vtx=vtx;
            this.par=par;
            this.wsf=wsf;
        }
    }

    public static void dijkstraAlgo(ArrayList<Edge> graph[],int n){
        boolean vis[]=new boolean[n];
        int dis[]=new int[n];//here, it is compulsory
        int par[]=new int[n];

        Arrays.fill(dis,(int)1e8);
        Arrays.fill(par,-1);

        PriorityQueue<dijkstraPair> pq=new PriorityQueue<>((a,b){
            a.wsf-b.wsf;//min priority que based on wsf
        });
        pq.add(new dijkstraPair(0,-1,0));
        dis[0]=0;
        int edgeCount=0;
        while(edgeCount<=n-1){
            dijkstraPair pair=pq.remove();
            if(vis[pair.vtx]) continue;
            if(pair.par!=-1)
            edgeCount++;
            vis[pair.vtx]=true;
            par[pair.vtx]=pair.par;
            for(Edge e: graph[pair.vtx]){
                if(!vis[e.v] && pair.wsf+e.w<dis[e.v]){
                    dis[e.v]=pair.wsf+e.w;
                    pq.add(new primsPair(e.v,pair.vtx,e.w+pair.wsf));
                }
            }
        }
    }

    // Bellman Ford:-- O(V*E)

    //edges={{u,v,w},....}

    public static void bellmanFordAlgo_1(int edges[][],int n,int src){
    int dis[]=new int[n];
    Arrays.fill(dis,(int)1e8);

    dis[src]=0;
    boolean negativeCycle=false;
    for(int i=1;i<=n;i++){
        boolean isAnyUpdate=false;
        int ndis[]=new int[n];
        for(int i=0;i<n;i++)
        ndis[i]=dis[i];
        for(int e[]: edges){
            if(dis[e[0]]!=(int)1e8 && dis[e[0]+e[2]<ndis[e[1]])
            ndis[e[1]]=dis[e[0]]+e[2];
        }
        if(isAnyUpdate && i==n)
        negativeCycle=true;
        if(!isAnyUpdate && i<n)
        break;
    }
    }
    
    public static void bellmanFordAlgo_2(int edges[][],int n,int src){
    int dis[]=new int[n];
    Arrays.fill(dis,(int)1e8);

    dis[src]=0;
    boolean negativeCycle=false;
    for(int i=1;i<=n;i++){
        boolean isAnyUpdate=false;
        for(int e[]: edges){
            if(dis[e[0]]!=(int)1e8 && dis[e[0]]+e[2]<dis[e[1]])
            dis[e[1]]=dis[e[0]]+e[2];
        }
        if(isAnyUpdate && i==n)
        negativeCycle=true;
        if(!isAnyUpdate && i<n)
        break;
    }
    }
    }

