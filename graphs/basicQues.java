import java.util.*;

public class basicQues{

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

    /* DFS:-
       1. Mark
       2. For all unvisited neighbours:
                                    i. Call for dfs(neighbours)
    */

    public static boolean hasPath(int src,int dest,boolean vis[]){

    }

    public static int allPaths(int src,int dest,boolean vis[],int wsf,String psf){
        //wsf-- weight so far
        //psf-- path so far


    }

    public static int maxWeightPath(int src,int dest){

    }

    public static void minWeightPath(int src,int dest){

    }

    public static int hamiltonian(int src){

    }
    
    public static void main(String args[]){

        constructGraph();
        System.out.println(searchEdge(0,2));
        removeEdge(0,1);
        removeVertex(2);
        display();
    }
}