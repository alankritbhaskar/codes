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
        
    }

    /* DFS:-
       1. Mark
       2. For all unvisited neighbours:
                                    i. Call for dfs(neighbours)
    */

    public static boolean hasPath(int src,int dest,boolean vis[]){
    if(src==dest){
        return true;
    }
    vis[src]=true;
    boolean ans=false;
    for(Edge e: graph[src]){
        if(!vis[e.v])
        ans=ans||hasPath(src+1,dest,vis);
    }
    vis[src]=false;
    return ans;
    }

    public static int allPaths(int src,int dest,boolean vis[],int wsf,String psf){
        //wsf-- weight so far
        //psf-- path so far
    if(src==dest){
        System.out.println(psf+src+" @"+wsf);
        return 1;
    }
    
    vis[src]=true;
    int c=0;
    for(Edge e: graph[src]){
        if(!vis[e.v]){
            c+=allPaths(e.v,dest,vis,wsf+e.w,psf+src);
        }
    }
    vis[src]=false;
    return c;
    }
    
    public static class Pair{
        int wt=0;
        String path="";
        boolean isDestHit=false;

        public Pair(String path,int wt,boolean isDestHit){
            this.path=path;
            this.wt=wt;
            this.isDestHit=isDestHit;
        }
    }
    public static int maxWeightPath(int src,int dest,boolean vis[]){
        Pair ans=maxWeightPaths(src,dest,vis);
        return ans.wt;
    }

    public static Pair maxWeightPaths(int src,int dest,boolean vis[]){
    if(src==dest){
    return new Pair(src+"",0,true);
    }

    vis[src]=true;
    Pair myAns=new Pair("",0,false);
    for(Edge e:graph[src]){
        if(!vis[e.v]){
            Pair recAns=maxWeightPaths(e.v,dest,vis);
            if(recAns.wt+e.w>myAns.wt && recAns.isDestHit){
                myAns.wt=recAns.wt+e.w;
                myAns.path=src+myAns.path;
                myAns.isDestHit=true;
            }
        }
    }
    vis[src]=false;
    return myAns;
    }

    public static int minWeightPath(int src,int dest,boolean vis[]){
    Pair ans=minWeightPaths(src,dest,vis);
    return ans.wt;
    }
    
    public static Pair minWeightPaths(int src,int dest,boolean vis[]){

        if(src==dest){
            return new Pair(src+"",(int)10e5,true);
        }

        vis[src]=true;
        Pair myAns=new Pair("",(int)10e5,false);
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                Pair recAns=minWeightPaths(e.v,dest,vis);
                if(recAns.wt+e.w<myAns.wt && myAns.isDestHit){
                    myAns.wt=recAns.wt+e.w;
                    myAns.path=src+recAns.path;
                    myAns.isDestHit=true;
                }
            }
        }
        vis[src]=false;
        return myAns;
    }
    
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

    public static void main(String args[]){

        constructGraph();
        // System.out.println(searchEdge(0,2));
        // removeEdge(0,1);
        // removeVertex(2);
        
        boolean vis[]=new boolean[n];
        int an=allPaths(1,4,vis,0,"");
        System.out.println(an);
        display();
    }
}