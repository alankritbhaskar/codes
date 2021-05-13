import java.util.*;

public class bfs{

    public static class Edge{
        int v=0;
        int w=0;
        public Edge(int v,int w){
        this.v=v;
        this.w=w;
        }
    }

  
    static int n=7;
    static ArrayList<Edge>[] graph=new ArrayList[n];
    
    //add an edge in bidirectional graph
    
    public static void addEdge(int u,int v,int w){
    graph[u].add(new Edge(v,w));
    graph[v].add(new Edge(u,w));
    }

     public static int searchEdge(int u,int v){
     
     for(int i=0;i<graph[u].size();i++){
         Edge e=graph[u].get(i);
         if(e.v==v)//check that for vertex u is there any edge which terminates at vertex v..... if yes then return the index of vertex u.
         return i;
     }

     return -1;
     }
    
     public static void removeEdge(int u,int v){
     
     int v1=searchEdge(u,v);//index of vertex u is stored here 
     graph[u].remove(v1);
     int v2=searchEdge(v,u);//index of vertex v is stored here
     graph[v].remove(v2);
     
     }

     public static void removeVertex(int a){
     
     //used from backward dirn bcoz harr time graph ke arraylist mein se edge remove krne pe usme reordering hojayegi so actually sare elements delete nhi honge
     for(int i=graph[a].size()-1;i>=0;i--){
         Edge e=graph[a].get(i);
         removeEdge(a,e.v);
     }
     }
 
    public static void display(){

        for(int i=0;i<n;i++){
            System.out.print(i+"-> ");
            for(Edge e: graph[i]){
            System.out.print("("+ e.v+", "+e.w+"), ");
            }
            System.out.println();
        }
    }

    public static void constructGraph(){

         for(int i = 0;i<n ;i++) 
        graph[i] = new ArrayList<Edge>();// to store a blank arraylist at each index in array i.e. a blank arraylist in array of arraylist 

        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);
        addEdge(2,5,6);
    }
    
    //    BFS:-
    //    1. queue que
    //    2. que <- src
    //    3. while(que.size()!=0)
    //       3.1. vtx <- que
    //       3.2. mark vtx
    //       3.3. for all unvisited nbrs
    //            3.3.1 insert in que <- nbrs

    public static void BFS_01(int src,boolean vis[]){
    LinkedList<Integer> que=new LinkedList<>();
    que.addLast(src);

    boolean cycle=false;
    
    while(que.size()!=0){
        int vtx = que.removeFirst();

        //optimum pos. for cycle detection
        if(vis[vtx]){
        cycle = true;
        continue;//agar same vtx pehle se visited hai to to usme nbrs ko que me add nhi krenge
        }

        vis[vtx]=true;
        
        for(Edge e: graph[vtx]){
         if(!vis[e.v])
         que.addLast(e.v);
    }
    }
    }

    //Delimitter-- for finding shortest distance till destination
    public static void BFS_02(int src,int dest,boolean vis[]){
    
    LinkedList<Integer> que=new LinkedList<>();
    que.addLast(src);
    que.addLast(null);
    boolean cycle=false;
    int level=0;
    while(que.size()!=1){
        int vtx=que.removeFirst();
        if(vis[vtx]){
            cycle=true;
            continue;
        }
        if(vtx==dest){
            System.out.println(level);// level-- it gives the shortest distance of destination from source node  
        }
        vis[vtx]=true;
        for(Edge e: graph[vtx]){
            if(!vis[e.v]){
                que.addLast(e.v);
            }
        }
        if(que.getFirst()==null){
            level++;
            que.addLast(que.removeFirst());
        }
    }
    }

    //......Cycle Wala BFS........
    public static void BFS_03_WithCycle(int src,boolean vis[]){
    LinkedList<Integer> que=new LinkedList<>();
    int dest = 6;
    que.addLast(src);
    boolean cycle=false;
    boolean found = false;

    int level=0;
    int dis[]=new int[n];//stores min. dist. from src vtx to all vertex

    while(que.size() != 0){
        int size = que.size();
        while(size-- > 0){
            int vtx = que.removeFirst();
            if(vis[vtx]){
                cycle=true;
                continue;
            }
            if(vtx == dest){
                found = true;
                continue;
            }
            dis[vtx]=level;
            
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    que.addLast(e.v);
                }
            }
        }
    }
        level++;
    }

// BFS for shortest path
    public static void BFS_04_WithoutCycle(int src,boolean vis[]){
    LinkedList<Integer> que=new LinkedList<>();
    que.addLast(src);
    vis[src]=true;

    int level=0;
    int dis[]=new int[n];
    while(que.size()!=0){
        int size=que.size();
        while(size-- > 0){
            int vtx=que.removeFirst();
            dis[vtx]=level;
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    vis[e.v]=true;
                    que.addLast(e.v);
                }
            }
        }
        level++;
    }
    }

// BFS for shortestPath Print

public static void BFS_04_WithoutCycle(int src,int dest,boolean vis[]){
    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(src);
    vis[src] = true;

    int atLevel = -1;
    int level = 0;
    int dis[] = new int[n];
    int parent[] = new int[n];
    Arrays.fill(parent,-1);

    while(que.size() != 0){
        int size = que.size();
        while(size-- > 0){
            int vtx = que.removeFirst();
            dis[vtx] = level;
            
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    vis[e.v] = true;
                    que.addLast(e.v);
                    parent[e.v] = vtx;
                }

                if(e.v == dest)
                    atLevel = level + 1;
            }
        }
        level++;
    }
    System.out.print(dest+"is present at distance:"+atLevel);
    int idx = dest;

    while(idx != -1){
        System.out.print(idx+"-> ");
        idx = parent[idx];
    }
    }

// If graphs are disconnected
    public static int BFS_GCC(int n){
        boolean vis[] = new boolean[n];

        int components = 0;
        for(int i = 0;i < n;i++){
            if(!vis[i]){
                BFS_03_WithCycle(i,vis);
                components++;
            }
        }
        return components;
    }

    public static void main(String args[]){

        constructGraph();
        System.out.println(searchEdge(0,2));
        removeEdge(0,1);
        removeVertex(2);
        display();
    }
}