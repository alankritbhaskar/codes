import java.util.*;

//Graph basics

public class l001{

    public static class Edge{
        int v=0;//termination vertex of the graph
        int w=0;//weight of the edge of the graph

        public Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    static int N=7;
    static ArrayList<Edge> graph[]=new ArrayList[N];//array of arraylists

    //adding a bi-directional graph edge
    public static void addEdge(int u,int v,int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }
    
    //a function to display the graph 
     public static void display(){
     for(int i=0;i<N;i++){
         System.out.print(i+"--> ");
         for(Edge e: graph[i])
         System.out.print("("+e.v+","+e.w+") ,");
         System.out.println();
     }
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
     
     // DFS:-
     // 1.Mark
     // 2.For all unvisited neighbours
     //           -->2.1 visit them and perform the task

     public static boolean hasPath(int src,int dest,boolean visited[]){
     
     if(src==dest)
     return true;

     visited[src]=true;//1. Mark
     boolean res=false;
     for(Edge e: graph[src]){
         if(!visited[e.v]){//2
             res=res || hasPath(src+1,dest,visited);//2.1
         }
     }
     visited[src]=false;
     return res;
     }

    //  public static int allPaths(int src,int dest,boolean visited[],String psf,int wsf){
    
    //     if(src == dest){
    //         System.out.println(psf + src + "@" + wsf);
    //         return 1;
    //     }

    //     vis[src] = true;
    //     int count = 0;
    //     for(Edge e: graph[src]){
    //         if(!vis[e.v])
    //         count+=allPath(e.v,dest,vis,psf + src + " ", wsf + e.w);
            
    //     }
        
    //     vis[src] = false;
    //     return count;
    // }
    //  if(src==dest){
    //      System.out.println(psf+src+"@"+wsf);
    //      return 1;
    //  }

    //  visited[src]=true;
    //   int count=0;
    //  for(Edge e:graph[src]){
    //      if(!visited[e.v]){
    //          count+=allPaths(src+1,dest,visited,psf+e.v,wsf+e.w);
    //      }
    //  }
    //  visited[src]=false;
    //  return count;
    //  }

    //  public static void maxWeightPath(int u,int v){


    //  }

    //  public static void minWeightPath(int ,int v){


    //  }

    public static int hamiltonianPath(int src,int osrc,boolean vis[],String psf,int edgeCount)
    {
      
      if(edgeCount==N-1){
      psf+=src;
      int idx=searchEdge(src,osrc);
      if(idx!=0)
      System.out.println("cycle: "+psf+"");
      else
      System.out.println("path: "+psf+"");
      return 1;
      }
      vis[src]=true;
      int count=0;
        for(Edge e:graph[src]){
            if(!vis[e.v])
            count+=hamiltonianPath(e.v,osrc,vis,psf+src,edgeCount+1);            
            }
        vis[src]=false;
        return count;
    }

     public static void constructGraph(){
        for(int i = 0;i<N;i++) 
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

       
        boolean visited[]=new boolean[N];
        System.out.println(hamiltonianPath(0,0,visited,"",0));
   
        display();
       
     }

     public static void main(String args[]){
         constructGraph();
     }
}
