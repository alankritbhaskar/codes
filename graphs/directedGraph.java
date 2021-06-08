public class directedGraph{

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
        
    }
    public void dfsTopo(int src,boolean vis[],ArrayList<Integer> ans){
        // Pseudo-code:-
        // 1. Mark
        // 2. For all unvisited nbrs
            //  2.1. Call for dfs
        // 3. Store in vector/stack/arraylist

        vis[src] = true;
        for(Edge e: graph[src]){
            if(vis[e.v] == false)
                dfsTopo(e.v,vis,ans);
        }
        ans.add(src); // Store in array while coming back in tree
    }

    public void topoSort(int n){
        boolean vis[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ;i < n;i++){
            if(vis[i] == false)
            dfsTopo(i,src,ans);
        }

        for(int i = 0;i < ans.size();i++){
            System.out.print(ans.get(i)+"-> ");
        }
        System.out.println();
    }

// Kahn's Algorithm

    public static kahnsAlgo(int n){
        ArrayList<Integer> indegree = new ArrayList<>();

        for(int i = 0;i < n;i++){
            for(Edge e: graph[i])
            indegree.set(i,indegree.get(i)++);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Integer> que = new LinkedList<>();

    // Place those elements with 0 indegree first in queue

        for(int i = 0;i < n;i++){
            if(indegree.get(i) == 0)
            que.addLast(i);
        }

        int level = 0;

        while(que.size() != 0){
            int size = que.size();

            while(size-- > 0){
                int rvtx = que.removeFirst();
                
                ans.add(rvtx);
                for(Edge e: graph[rvtx]){
                    indegree.set(e.v,indegree.get(e.v)-1);
                    if(indegree.get(e.v) == 0)
                    que.addLast(e.v);
                }
            }
            level++;
        }

        for(int i = 0;i < ans.size();i++)
            System.out.print(ans.get(i));

        System.out.println();
    }

    
}